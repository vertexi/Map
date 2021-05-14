Boolean scatter_status = false; //<>//
GPlot scatter_plot;

void scatter_con() {
  if (scatter_status) {
    cp5.remove("scatter_con");
    cp5.addGroup("scatter_con")
      .moveTo("SCATTER");

    cp5.addDropdownList("ScatterX")
      .setLabel("X:")
      .setPosition(10, 40)
      .setSize(250, 200)
      .setBarHeight(25)
      .setItemHeight(20)
      .setFont(createFont("Georgia", 15))
      .setGroup("scatter_con")
      ;

    cp5.addDropdownList("ScatterY")
      .setLabel("Y:")
      .setPosition(10, 280)
      .setSize(250, 200)
      .setBarHeight(25)
      .setItemHeight(20)
      .setFont(createFont("Georgia", 15))
      .setGroup("scatter_con")
      ;

    String[] temp = new String[cataList.size()];
    temp = cataList.toArray(temp);
    List m = Arrays.asList(temp);
    cp5.get(DropdownList.class, "ScatterX").setItems(m);
    cp5.get(DropdownList.class, "ScatterY").setItems(m);

    scatter_plot = new GPlot(this);
  }
}

void scatter_operator() {
  if (scatter_status && frameCount % 30 == 0) {
    String[] temp = new String[cataList.size()];
    temp = cataList.toArray(temp);

    String x = temp[(int)cp5.get(DropdownList.class, "ScatterX").getValue()];
    String y = temp[(int)cp5.get(DropdownList.class, "ScatterY").getValue()];

    HashMap<String, CountryData> countryX = catalogs.get(x).country;
    HashMap<String, CountryData> countryY = catalogs.get(y).country;


    //GPointsArray plotpoints = new GPointsArray(index);
    ArrayList<Float> value_x = new ArrayList<Float>();
    ArrayList<Float> value_y = new ArrayList<Float>();
    ArrayList<String> name = new ArrayList<String>();
    float year = cp5.getController("year"+x).getValue();
    for (String keys : countryX.keySet()) {
      if (countryY.get(keys) != null) {
        int target_index = findFloatinArray(year, countryX.get(keys).value[0]);
        int target_index1 = findFloatinArray(year, countryY.get(keys).value[0]);
        if (target_index != -1 && target_index1 != -1) {
          value_x.add(countryX.get(keys).value[1][target_index]);
          value_y.add(countryY.get(keys).value[1][target_index1]);
          name.add(keys);
        }
      }
    }
    GPointsArray plotpoints = new GPointsArray(value_x.size());
    for (int i = 0; i < value_x.size(); i++) {
      plotpoints.add(value_x.get(i), value_y.get(i), name.get(i));
    }
    
    scatter_plot.setPos(500, 450);
    scatter_plot.setPoints(plotpoints);
    scatter_plot.getTitle().setText(x + " & " + y);
    scatter_plot.getTitle().setTextAlignment(RIGHT);
    scatter_plot.getXAxis().getAxisLabel().setText(x);
    scatter_plot.getYAxis().getAxisLabel().setText(y);
    scatter_plot.getYAxis().getAxisLabel().setOffset(0.5);
    scatter_plot.getYAxis().getAxisLabel().setRotate(true);
    scatter_plot.getYAxis().getAxisLabel().setTextAlignment(RIGHT);
    scatter_plot.getYAxis().getAxisLabel().setRelativePos(1);
    scatter_plot.getYAxis().getAxisLabel().setOffset(40);
    scatter_plot.getYAxis().setOffset(0.5);
    scatter_plot.getYAxis().setExpTickLabels(true);
    scatter_plot.getXAxis().setExpTickLabels(true);
    scatter_plot.getYAxis().setRotateTickLabels(false);
    scatter_plot.activatePointLabels();
    scatter_plot.activatePanning();
    scatter_plot.activateZooming(1.2, LEFT, RIGHT);
  }
}

void draw_scatter_plot() {
  if (scatter_plot != null && scatter_status) {
    scatter_plot.beginDraw();
    scatter_plot.drawBackground();
    scatter_plot.setOuterDim(700, 300);
    scatter_plot.drawBox();
    scatter_plot.drawXAxis();
    scatter_plot.drawYAxis();
    scatter_plot.drawTitle();
    scatter_plot.drawGridLines(GPlot.BOTH);
    scatter_plot.drawPoints();
    scatter_plot.drawLabels();
    scatter_plot.endDraw();
    if (scatter_plot.isOverBox(mouseX, mouseY)) {
      eventDispatcher.unregister(map, "pan", map.getId());
      eventDispatcher.unregister(map, "zoom", map.getId());
    }
  }
}
