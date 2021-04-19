
import grafica.*;

GPlot plot;
void setup() {
  size(1024, 750);
  
  plot = new GPlot(this);
  // Prepare the points for the plot
  int nPoints = 100;
  GPointsArray points = new GPointsArray(nPoints);

  for (int i = 0; i < nPoints; i++) {
    points.add(i, 10*noise(0.1*i));
  }

  // Create a new plot and set its position on the screen

  plot.setPos(25, 25);
  // or all in one go
  // GPlot plot = new GPlot(this, 25, 25);

  // Set the plot title and the axis labels
  plot.setTitleText("A very simple example");
  plot.getXAxis().setAxisLabelText("x axis");
  plot.getYAxis().setAxisLabelText("y axis");

  // Add the points
  plot.setPoints(points);

  // Draw it!
}
void draw() {
  background(0);
  plot.beginDraw();
  plot.drawBackground();
  plot.setOuterDim(101, 101);
  plot.setDim(100, 100);

  plot.drawBox();
  plot.drawXAxis();
  plot.drawYAxis();
  plot.drawTitle();
  plot.drawGridLines(GPlot.BOTH);
  plot.drawLines();
  plot.drawPoints();
  plot.endDraw();
}
