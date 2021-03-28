String preprevCountryName = "";//To detect the previous opreation country //<>// //<>//
Boolean fit_status = false;

ArrayList<Float> currentPoints;
ArrayList<Float> currentPointsY;
WeightedObservedPoints obs;
CountryPlot fitPlot = new CountryPlot();
void datafit(Marker marker) {
  if (fit_status) {
    if (!preprevCountryName.equals(marker.getId())) {
      //Updata the cataloglist
      String[] temp = new String[cataList.size()];
      temp = cataList.toArray(temp);
      String countryId = marker.getId();
      preprevCountryName = countryId;
      List m = Arrays.asList(temp);
      cp5.get(DropdownList.class, "CatalogsListX").setItems(m);
      cp5.get(DropdownList.class, "CatalogsListY").setItems(m);
      cp5.get(DropdownList.class, "CatalogsListX").addItem("Inter_Year", cataList.size());
      if (fit_plot) {
        if (temp != null) {
          if ((int)cp5.get(DropdownList.class, "CatalogsListX").getValue() == cataList.size()) {
            String y = temp[(int)cp5.get(DropdownList.class, "CatalogsListY").getValue()];

            if (catalogs.get(y).country.get(countryId) != null) {
              int index = catalogs.get(y).country.get(countryId).index + 1;
              Float[][] valueY = catalogs.get(y).country.get(countryId).value;
              String countryName = catalogs.get(y).country.get(countryId).countryName;
              fitPlot.plot = new GPlot(this);
              currentPoints = new ArrayList<Float>();
              currentPointsY = new ArrayList<Float>();

              GPointsArray plotpoints = new GPointsArray(index);
              obs = new WeightedObservedPoints();
              for (int i = 0; i < index; i++) {
                plotpoints.add(valueY[0][i], valueY[1][i]);
                obs.add(valueY[0][i], valueY[1][i]);
                currentPoints.add(valueY[0][i]);
                currentPointsY.add(valueY[1][i]);
              }

              fitPlot.plot.setPos(5, 20);
              fitPlot.plot.setPoints(plotpoints);
              fitPlot.plot.getTitle().setText(countryName);
              fitPlot.plot.getTitle().setTextAlignment(LEFT);
              fitPlot.plot.getXAxis().getAxisLabel().setText("Inter_Year");
              fitPlot.plot.getYAxis().getAxisLabel().setText(y);
              fitPlot.plot.getYAxis().getAxisLabel().setOffset(0.5);
              fitPlot.plot.getYAxis().getAxisLabel().setRotate(true);
              fitPlot.plot.getYAxis().getAxisLabel().setTextAlignment(RIGHT);
              fitPlot.plot.getYAxis().getAxisLabel().setRelativePos(1);
              fitPlot.plot.getYAxis().getAxisLabel().setOffset(40);
              fitPlot.plot.getYAxis().setOffset(0.5);
              fitPlot.plot.getYAxis().setExpTickLabels(true);
              fitPlot.plot.getXAxis().setExpTickLabels(true);
              fitPlot.plot.getYAxis().setRotateTickLabels(false);

              polyFitPoints();
            }
          } else {
            String x = temp[(int)cp5.get(DropdownList.class, "CatalogsListX").getValue()];
            String y = temp[(int)cp5.get(DropdownList.class, "CatalogsListY").getValue()];

            if (catalogs.get(x).country.get(countryId) != null && catalogs.get(y).country.get(countryId) != null) {
              Float[][] valueX = catalogs.get(x).country.get(countryId).value;
              int index = catalogs.get(x).country.get(countryId).index + 1;
              Float[][] valueY = catalogs.get(y).country.get(countryId).value;
              String countryName = catalogs.get(x).country.get(countryId).countryName;
              fitPlot.plot = new GPlot(this);
              currentPoints = new ArrayList<Float>();
              currentPointsY = new ArrayList<Float>();

              GPointsArray plotpoints = new GPointsArray(index);
              obs = new WeightedObservedPoints();
              for (int i = 0; i < index; i++) {
                float target = valueX[0][i];
                int target_index = findFloatinArray(target, valueY[0]);
                if (target_index != -1) {
                  plotpoints.add(valueX[1][i], valueY[1][target_index]);
                  obs.add(valueX[1][i], valueY[1][target_index]);
                  currentPoints.add(valueX[1][i]);
                  currentPointsY.add(valueY[1][target_index]);
                }
              }

              fitPlot.plot.setPos(5, 20);
              fitPlot.plot.setPoints(plotpoints);
              fitPlot.plot.getTitle().setText(countryName);
              fitPlot.plot.getTitle().setTextAlignment(LEFT);
              fitPlot.plot.getXAxis().getAxisLabel().setText(x);
              fitPlot.plot.getYAxis().getAxisLabel().setText(y);
              fitPlot.plot.getYAxis().getAxisLabel().setOffset(0.5);
              fitPlot.plot.getYAxis().getAxisLabel().setRotate(true);
              fitPlot.plot.getYAxis().getAxisLabel().setTextAlignment(RIGHT);
              fitPlot.plot.getYAxis().getAxisLabel().setRelativePos(1);
              fitPlot.plot.getYAxis().getAxisLabel().setOffset(40);
              fitPlot.plot.getYAxis().setOffset(0.5);
              fitPlot.plot.getYAxis().setExpTickLabels(true);
              fitPlot.plot.getXAxis().setExpTickLabels(true);
              fitPlot.plot.getYAxis().setRotateTickLabels(false);

              polyFitPoints();
            }
          }
        }
      }
    }
  }
}

void fit_draw() {
  if (fit_plot && fitPlot.plot != null) {
    GPlot nowplot = fitPlot.plot;
    nowplot.beginDraw();
    nowplot.drawBackground();
    nowplot.setOuterDim(700, 300);
    nowplot.drawBox();
    nowplot.drawXAxis();
    nowplot.drawYAxis();
    nowplot.drawTitle();
    nowplot.drawGridLines(GPlot.BOTH);
    if (nowplot.getLayer("fit_layer") != null) {
      nowplot.getLayer("fit_layer").drawLines();
    }
    nowplot.drawPoints();
    nowplot.endDraw();
    if (nowplot.isOverBox(mouseX, mouseY)) {
      eventDispatcher.unregister(map, "pan", map.getId());
      eventDispatcher.unregister(map, "zoom", map.getId());
    }
  }
}

Boolean exp_fit_status = true;
Boolean gaussian_fit_status = true;
void polyFitPoints() {
  if (fit_status) {
    if (cp5.get(DropdownList.class, "FitMethod")!= null) {
      int type = (int)cp5.get(DropdownList.class, "FitMethod").getValue();
      if (type == 0 && cp5.get(Numberbox.class, "ddegree") != null) {

        //start to fit
        int degree = (int)cp5.get(Numberbox.class, "ddegree").getValue();
        PolynomialCurveFitter fitter = PolynomialCurveFitter.create(degree);
        final double[] coeff = fitter.fit(obs.toList());
        
        //printArray(coeff);

        //get the fit points and culculate the RMSE , R-square

        //total sum of squares
        float r_square = 0;
        float square_y = 0;
        float mean_y = 0;
        Float[] pointX = new Float[currentPoints.size()];
        float[] points = new float[currentPointsY.size()];
        for (int l = 0; l < currentPointsY.size(); l++) {
          points[l] = currentPointsY.get(l);
          pointX[l] = currentPoints.get(l);
          mean_y += currentPointsY.get(l);
        }
        mean_y = mean_y/currentPointsY.size();
        //if (degree == 1) {
        //  float[] pointxx = new float[currentPoints.size()];
        //  for (int l = 0; l < currentPointsY.size(); l++) {
        //    pointxx[l] =  pointX[l];
        //  }
        //  float[] temp_coeff = leastSquareLinearFit(pointxx, points);
        //  coeff[0] = temp_coeff[0];
        //  coeff[1] = temp_coeff[1];
        //} else {
        //  coeff = fitter.fit(obs.toList());
        //}
        for (float point : points) {
          square_y += sq(point - mean_y);
        }

        float rmse = 0;
        GPointsArray plotpoints1 = new GPointsArray(currentPoints.size());
        float[] fitPoints = new float[currentPoints.size()];
        for (int i = 0; i < currentPoints.size(); i++) {
          fitPoints[i] = (float)coeff[0];
          for (int j = 1; j < degree+1; j++) {
            fitPoints[i] += coeff[j]*pow(currentPoints.get(i), j);
          }
          //RMSE
          rmse += sq(fitPoints[i] - currentPointsY.get(i));

          plotpoints1.add(currentPoints.get(i), fitPoints[i]);
        }
        r_square = 1-rmse/square_y;
        rmse = sqrt(rmse/currentPoints.size());

        //more points predicate
        float period = 0;
        float max = maxs(pointX);
        float min = mins(pointX);
        period = (max - min)/currentPoints.size();
        int predicate_num = 0;
        predicate_num = (int)(currentPoints.size() * cp5.getController("slider111").getValue()/100);
        for (int i = 0; i < predicate_num; i++) {
          max += period;
          float value = (float)coeff[0];
          for (int j = 1; j < degree+1; j++) {
            value += coeff[j]*pow(max, j);
          }
          plotpoints1.add(max, value);
        }

        fitPlot.plot.addLayer("fit_layer", plotpoints1);
        fitPlot.plot.getLayer("fit_layer").setPointColor(color(0, 0, 255));

        String result = "";
        result = String.format("%.02e", coeff[0]);
        for (int k = 1; k < degree+1; k++) {
          result += " + "+String.format("%.02e", coeff[k])+"*x^"+k;
        }
        result += "\nRMSE: "+rmse;
        result += "\nR-square: "+r_square;
        cp5.remove("fitResult");
        Textarea myTextlabelA;
        myTextlabelA = cp5.addTextarea("fitResult")
          .setPosition(5, 500)
          .setColorValue(0xffffff00)
          .setFont(createFont("Georgia", 15))
          .setWidth(245)
          .setHeight(280)
          .setText(result)
          .moveTo("FIT")
          ;
      } else if (type == 1) {
        if (gaussian_fit_status) {
          gaussian_fit_status = false;
          double[] parameters = GaussianCurveFitter.create().fit(obs.toList());
          float r_square = 0;
          float square_y = 0;
          float mean_y = 0;
          float[] points =new float[currentPointsY.size()];
          for (int l = 0; l < currentPointsY.size(); l++) {
            points[l] = currentPointsY.get(l);
            mean_y += currentPointsY.get(l);
          }
          mean_y = mean_y/currentPointsY.size();
          for (float point : points) {
            square_y += sq(point - mean_y);
          }

          float rmse = 0;
          GPointsArray plotpoints1 = new GPointsArray(currentPoints.size());
          float[] fitPoints = new float[currentPoints.size()];
          for (int i = 0; i < currentPoints.size(); i++) {
            fitPoints[i] = (float)parameters[0]*exp(-sq((float)(currentPoints.get(i)-parameters[1]))/(2*sq((float)parameters[2])));

            //RMSE
            rmse += sq(fitPoints[i] - currentPointsY.get(i));

            plotpoints1.add(currentPoints.get(i), fitPoints[i]);
          }
          r_square = 1-rmse/square_y;
          rmse = sqrt(rmse/currentPoints.size());
          fitPlot.plot.addLayer("fit_layer", plotpoints1);
          fitPlot.plot.getLayer("fit_layer").setPointColor(color(0, 0, 255));

          String result = "";
          result += " + "+String.format("%.02e", parameters[0])+"*exp(-(x-"+String.format("%.02e", parameters[1])+")^2/(2*"+String.format("%.02e", parameters[2])+"^2))";

          result += "\nRMSE: "+rmse;
          result += "\nR-square: "+r_square;
          cp5.remove("fitResult");
          Textarea myTextlabelA;
          myTextlabelA = cp5.addTextarea("fitResult")
            .setPosition(5, 400)
            .setColorValue(0xffffff00)
            .setFont(createFont("Georgia", 15))
            .setWidth(245)
            .setHeight(280)
            .setText(result)
            .moveTo("FIT")
            ;
          gaussian_fit_status = true;
        }
      } else if (type == 2) {
        if (exp_fit_status) {
          exp_fit_status = false;
          float r_square = 0;
          float square_y = 0;
          float mean_y = 0;
          float[] pointsY =new float[currentPointsY.size()];
          float[] pointsX =new float[currentPointsY.size()];
          for (int l = 0; l < currentPointsY.size(); l++) {
            pointsX[l] = currentPoints.get(l);
            pointsY[l] = currentPointsY.get(l);
            mean_y += currentPointsY.get(l);
          }
          mean_y = mean_y/currentPointsY.size();
          for (float point : pointsY) {
            square_y += sq(point - mean_y);
          }

          float rmse = 0;
          GPointsArray plotpoints1 = new GPointsArray(currentPoints.size());
          float[] fitPoints = new float[currentPoints.size()];
          float[] fit_result;
          fit_result = exp_fit(pointsX, pointsY);

          for (int i = 0; i < currentPoints.size(); i++) {
            fitPoints[i] = (float)(fit_result[0] + fit_result[1]*exp((float)(fit_result[2]*currentPoints.get(1))));

            //RMSE
            rmse += sq(fitPoints[i] - currentPointsY.get(i));

            plotpoints1.add(currentPoints.get(i), fitPoints[i]);
          }
          r_square = 1-rmse/square_y;
          rmse = sqrt(rmse/currentPoints.size());
          fitPlot.plot.addLayer("fit_layer", plotpoints1);
          fitPlot.plot.getLayer("fit_layer").setPointColor(color(0, 0, 255));

          String result = "";
          result = String.format("%.02e", fit_result[0])+" + "+fit_result[1]+"*e^("+fit_result[2]+" x)";

          result += "\nRMSE: "+rmse;
          result += "\nR-square: "+r_square;
          cp5.remove("fitResult");
          Textarea myTextlabelA;
          myTextlabelA = cp5.addTextarea("fitResult")
            .setPosition(5, 400)
            .setColorValue(0xffffff00)
            .setFont(createFont("Georgia", 15))
            .setWidth(245)
            .setHeight(280)
            .setText(result)
            .moveTo("FIT")
            ;
          exp_fit_status = true;
        }
      }
    }
  }
}

float[] exp_fit(float[] x, float[] y) {
  //y = a+be^(cx)
  float[] dx = new float[x.length];
  float[] dy = new float[y.length];
  float[] cx = new float[x.length];

  for (int i = y.length-1; i > 0; i--) {
    dy[i] = y[i]-y[i-1];
    dx[i] = x[i]-x[i-1];
    cx[i] = (x[i]+x[i-1])/2;
  }

  float[] c_appro = new float[y.length];
  float c_result = 0;
  float NaN_cout = 0;
  for (int i = y.length-1; i > 1; i--) {
    c_appro[i] = log((dy[i]/dx[i])/(dy[i-1]/dx[i-1]))/(cx[i]-cx[i-1]);
    if (!Float.isNaN(c_appro[i])) {
      c_result += c_appro[i];
    } else {
      NaN_cout++;
    }
  }
  c_result = c_result/(y.length-2-NaN_cout);
  NaN_cout = 0;

  float[] b_appro = new float[y.length];
  float b_result = 0;
  for (int i = y.length-1; i > 0; i--) {
    b_appro[i] = (y[i]-y[i-1])/(exp(c_result*x[i])-exp(c_result*x[i-1]));
    if (!Float.isNaN(b_appro[i])) {
      b_result += b_appro[i];
    } else {
      NaN_cout++;
    }
  }
  b_result = b_result/(y.length-1-NaN_cout);
  NaN_cout = 0;

  float[] a_appro = new float[y.length];
  float a_result = 0;
  for (int i = y.length-1; i > 0; i--) {
    a_appro[i] = y[i]-b_result*exp(c_result*x[i]);
    if (!Float.isNaN(a_appro[i])) {
      a_result += a_appro[i];
    } else {
      NaN_cout++;
    }
  }
  a_result = a_result/(y.length-1-NaN_cout);
  NaN_cout = 0;

  float[][] points = new float[2][y.length];
  for (int i = y.length-1; i > -1; i--) {
    points[0][i] = x[i];
    points[1][i] = log(y[i]-a_result);
  }
  float[] coeff = leastSquareLinearFit(points[0], points[1]);

  println("slope = " + coeff[1]);
  println("intercept = " + coeff[0]);
  b_result = exp((float)coeff[0]);
  c_result = (float)coeff[1];
  float[] result = {a_result, b_result, c_result};
  println("y="+a_result+"+"+b_result+"*e^("+c_result+"*x)");
  return result;
}

float[] leastSquareLinearFit(float[] x, float[] y) {
  float sum_x2 = 0.0;
  float sum_y  = 0.0;
  float sum_x  = 0.0;
  float sum_xy = 0.0;


  for (int i = 0; i < y.length; ++i) {
    sum_x2 += x[i]*x[i];
    sum_y  += y[i];
    sum_x  += x[i];
    sum_xy += x[i]*y[i];
  }

  float a = (y.length*sum_xy - sum_x*sum_y)/(y.length*sum_x2 - sum_x*sum_x);
  float b = (sum_x2*sum_y - sum_x*sum_xy)/(y.length*sum_x2-sum_x*sum_x);

  float[] result = {b, a};
  return result;
}
