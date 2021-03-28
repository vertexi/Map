Boolean classify_status = false; //<>// //<>//
GPlot plot3;

void classify() {
  if (classify_status) {
    if (frameCount % 30 == 0) {
      String[] temp1 = new String[cataList.size()];
      temp1 = cataList.toArray(temp1);
      String k = temp1[(int)cp5.get(DropdownList.class, "CatalogChoose").getValue()];
      if (catalogs.get(k) != null) {
        int class_num = (int)cp5.get(Numberbox.class, "NUM_Classify").getValue();
        ArrayList<Float> data = new ArrayList<Float>();
        ArrayList<String> name = new ArrayList<String>();
        HashMap<String, CountryData> country = catalogs.get(k).country;
        float year = cp5.getController("year"+k).getValue();

        for (String keys : country.keySet()) {
          int indexs = findFloatinArray(year, country.get(keys).value[0]);
          if (indexs != -1) {
            name.add(keys);
            data.add(country.get(keys).value[1][indexs]);
          }
        }
        float[] value = new float[name.size()];
        String[] countryid = new String[name.size()];
        float[] tempy = new float[name.size()];
        for (int i = 0; i < name.size(); i++) {
          value[i] = data.get(i);
          countryid[i] = name.get(i);
        }
        //order the data first!
        order_data order_data = sort_data(value, countryid);


        float max = maxMin.get(k).max;
        float min = maxMin.get(k).min;
        int[] index = new int[order_data.data.length];
        Boolean indicate = true;
        int count1 = 0;
        for (int j = 0; j < class_num; j++) {
          if (cp5.getController("slider1111"+j).getValue() <= min) {
            count1++;
          }
        }
        if (count1 == class_num) {
          index = kmeans(order_data.data, tempy, class_num);
          float[] sample = new float[class_num];
          for (int i = 0; i < class_num; i++) {
            for (int j = 0; j < index.length; j++) {
              if (index[j] == i) {
                sample[i] = order_data.data[i];
                break;
              }
            }
          }
          int[] mod_index = sort_fuck(sample.length, sample);
          for (int j = 0; j < index.length; j++) {
            index[j] = mod_index[index[j]];
          }
          indicate = false;
        }

        if (indicate) {
          for (int i = 0; i < order_data.data.length; i++) {
            for (int j = class_num-1; j > -1; j--) {
              if (order_data.data[i] > cp5.getController("slider1111"+j).getValue()) {
                index[i] = j;
                break;
              }
            }
          }
        }

        int count = 0;
        GPointsArray points3 = new GPointsArray(order_data.data.length);
        for (int i = 0; i < order_data.data.length; i++) {
          if (index[i] == 0) {
            points3.add(i, order_data.data[i], order_data.name[i]);
            count = i;
          }
        }
        //plot3 = new GPlot(this);
        plot3.setPos(600, 450);
        plot3.getTitle().setText(k);
        plot3.getTitle().setTextAlignment(LEFT);
        plot3.getTitle().setRelativePos(0);
        plot3.getYAxis().getAxisLabel().setText(k);
        plot3.getYAxis().getAxisLabel().setOffset(0.5);
        plot3.getYAxis().getAxisLabel().setRotate(true);
        plot3.getYAxis().getAxisLabel().setTextAlignment(RIGHT);
        plot3.getYAxis().getAxisLabel().setRelativePos(1);
        plot3.getYAxis().getAxisLabel().setOffset(40);
        plot3.getYAxis().setOffset(0.5);
        plot3.getYAxis().setExpTickLabels(true);
        plot3.getYAxis().setRotateTickLabels(false);
        plot3.setPoints(points3);
        plot3.startHistograms(GPlot.VERTICAL);
        plot3.getHistogram().setDrawLabels(true);
        plot3.getHistogram().setRotateLabels(true);
        plot3.getHistogram().setBgColors(new color[] {color(255, 0, 0, 10)});
        plot3.getHistogram().setLineColors(new color[] {color(255, 0, 0, 10)});
        plot3.activatePanning();
        plot3.activateZooming(1.2, LEFT, RIGHT);
        //plot3.activateReset();
        GPointsArray points4;
        for (int j = 1; j < class_num; j++) {
          points4 = new GPointsArray(order_data.data.length);
          for (int i = count+1; i < order_data.data.length; i++) {
            if (index[i] == j) {
              points4.add(i, order_data.data[i], order_data.name[i]);
              count = i;
            }
          }
          if (j == class_num-1) {
            points4.add(count+1, 0, "end");
          }
          plot3.removeLayer("layers"+j);
          plot3.addLayer("layers"+j, points4);
          plot3.getLayer("layers"+j).startHistogram(GPlot.VERTICAL);
          plot3.getLayer("layers"+j).getHistogram().setBgColors(new color[] {color(255, 0, 0, map(j, 0, (int)cp5.get(Numberbox.class, "NUM_Classify").getValue()-1, 10, 255))});
          plot3.getLayer("layers"+j).getHistogram().setLineColors(new color[] {color(255, 0, 0, map(j, 0, (int)cp5.get(Numberbox.class, "NUM_Classify").getValue()-1, 10, 255))});
          plot3.getLayer("layers"+j).getHistogram().setDrawLabels(true);
          plot3.getLayer("layers"+j).getHistogram().setRotateLabels(true);
        }

        List<String> countryname = Arrays.asList(countryid);
        for (Marker marker : countryMarkers) {
          String countryId = marker.getId();
          if (countryname.contains(countryId)) {
            int n = countryname.lastIndexOf(countryId);
            // Encode value as brightness (values range: 0-1000)
            float transparency = map(index[n], 0, class_num-1, 10, 255);
            marker.setColor(color(255, 0, 0, transparency));
          } else {
            // No value available
            marker.setColor(color(100, 120));
          }
        }
      }
    }
  }
}

void draw_classify() {
  // Draw the third plot
  if (classify_status && plot3 != null) {
    plot3.beginDraw();
    plot3.drawBackground();
    plot3.setOuterDim(700, 300);
    plot3.drawBox();
    plot3.drawYAxis();
    plot3.drawTitle();
    plot3.drawHistograms();
    plot3.endDraw();
  }
}

int prev_order;
void fuck_manage() {
  if (classify_status) {
    if ((int)cp5.get(Numberbox.class, "NUM_Classify").getValue() != prev_order) {
      String[] temp1 = new String[cataList.size()];
      temp1 = cataList.toArray(temp1);
      String k = temp1[(int)cp5.get(DropdownList.class, "CatalogChoose").getValue()];
      float max = maxMin.get(k).max;
      float min = maxMin.get(k).min;
      cp5.remove("g8");
      Group g8 = cp5.addGroup("g8")
        .setPosition(5, 200)
        .setBackgroundHeight(100)
        .setBackgroundColor(color(255, 50))
        .setLabel("Threshold")
        .setWidth(250)
        .setSize(250, 250)
        .moveTo("CLASSIFY")
        ;
      int heights = 0;
      prev_order = (int)cp5.get(Numberbox.class, "NUM_Classify").getValue();
      for (int j = 0; j < (int)cp5.get(Numberbox.class, "NUM_Classify").getValue(); j++) {
        cp5.addSlider("slider1111"+j)
          .setRange(min, max)
          .setValue(0)
          .setPosition(20, heights+=20)
          .setSize(100, 10)
          .setGroup("g8")
          .setLabel("Thre:"+j)
          ;
        cp5.addTextlabel("labelll"+j)
          .setText("")
          .setPosition(20, heights+=20)
          .setGroup("g8")
          ;
      }
    }
  }
}
