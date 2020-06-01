HashMap<String, CountryPlot> thePlot = new HashMap<String, CountryPlot>();
Boolean drawPPP = false;
String prevCountryName = "";
//PShape star;
//star = loadShape("star.svg");
//star.disableStyle();

int plotOffY = 0;

void drawPlot(Marker marker) {
  if (drawPPP) {
    if (!prevCountryName.equals(marker.getId())) {
      String countryId = marker.getId();
      prevCountryName = countryId;
      String[] temp = new String[cataList.size()];
      temp = cataList.toArray(temp);
      thePlot = new HashMap<String, CountryPlot>();
      int heights = -280+plotOffY;
      for (String k : temp) {
        if (catalogs.get(k).country.get(countryId) != null) {
          CountryPlot CountryPlot = new CountryPlot();
          Float[][] value = catalogs.get(k).country.get(countryId).value;
          int index = catalogs.get(k).country.get(countryId).index + 1;
          String countryName = catalogs.get(k).country.get(countryId).countryName;
          CountryPlot.plot = new GPlot(this);
          CountryPlot.cataName = k;
          GPointsArray plotpoints = new GPointsArray(index);
          for (int i = 0; i < index; i++) {
            plotpoints.add(value[0][i], value[1][i]);
          }
          CountryPlot.plot.setPos(5, heights+=300);
          CountryPlot.plot.setPoints(plotpoints);
          CountryPlot.plot.getTitle().setText(countryName+" "+k);
          CountryPlot.plot.getTitle().setTextAlignment(LEFT);
          CountryPlot.plot.getXAxis().getAxisLabel().setText(catalogs.get(k).year);
          CountryPlot.plot.getYAxis().getAxisLabel().setText(k);
          CountryPlot.plot.getYAxis().getAxisLabel().setOffset(40);
          CountryPlot.plot.getYAxis().getAxisLabel().setRotate(true);
          CountryPlot.plot.getYAxis().getAxisLabel().setTextAlignment(RIGHT);
          CountryPlot.plot.getYAxis().getAxisLabel().setRelativePos(1);
          CountryPlot.plot.getYAxis().getAxisLabel().setOffset(40);
          CountryPlot.plot.getYAxis().setOffset(0.5);
          CountryPlot.plot.getYAxis().setExpTickLabels(true);
          CountryPlot.plot.getXAxis().setExpTickLabels(true);
          CountryPlot.plot.getYAxis().setRotateTickLabels(false);
          //CountryPlot.plot.getXAxis().setRotateTickLabels(true);
          thePlot.put(k, CountryPlot);
        }
      }
    }
  }
}

void drawdrawplot() {
  String[] temp = new String[cataList.size()];
  temp = cataList.toArray(temp);
  if (drawPPP) {
    pushMatrix();
    translate(0, 0, 50);
    for (String k : temp) {
      if (thePlot.get(k)!=null) {
        GPlot nowplot = thePlot.get(k).plot;
        nowplot.beginDraw();
        nowplot.drawBackground();
        nowplot.setOuterDim(700, 300);
        nowplot.drawBox();
        nowplot.drawXAxis();
        nowplot.drawYAxis();
        nowplot.drawTitle();
        nowplot.drawGridLines(GPlot.BOTH);
        nowplot.drawLines();
        nowplot.drawPoints();
        nowplot.endDraw();
      }
    }
    popMatrix();
  }
}

class CountryPlot {
  String cataName;
  GPlot plot;
}
