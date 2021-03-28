import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import grafica.*; 
import controlP5.*; 
import org.apache.commons.math3.*; 
import org.apache.commons.math3.fitting.*; 
import org.apache.commons.lang3.*; 
import de.fhpotsdam.unfolding.*; 
import de.fhpotsdam.unfolding.core.*; 
import de.fhpotsdam.unfolding.data.*; 
import de.fhpotsdam.unfolding.events.*; 
import de.fhpotsdam.unfolding.geo.*; 
import de.fhpotsdam.unfolding.interactions.*; 
import de.fhpotsdam.unfolding.mapdisplay.*; 
import de.fhpotsdam.unfolding.mapdisplay.shaders.*; 
import de.fhpotsdam.unfolding.marker.*; 
import de.fhpotsdam.unfolding.providers.*; 
import de.fhpotsdam.unfolding.texture.*; 
import de.fhpotsdam.unfolding.tiles.*; 
import de.fhpotsdam.unfolding.ui.*; 
import de.fhpotsdam.unfolding.utils.*; 
import de.fhpotsdam.utils.*; 
import java.util.*; 
import java.util.Map; 
import ddf.minim.*; 
import ddf.minim.ugens.*; 

import org.apache.commons.math3.ml.neuralnet.*; 
import org.apache.commons.math3.ml.neuralnet.twod.*; 
import org.apache.commons.math3.ml.neuralnet.twod.util.*; 
import org.apache.commons.math3.ml.neuralnet.oned.*; 
import org.apache.commons.math3.ml.neuralnet.sofm.*; 
import org.apache.commons.math3.ml.neuralnet.sofm.util.*; 
import org.apache.commons.math3.ml.clustering.*; 
import org.apache.commons.math3.ml.clustering.evaluation.*; 
import org.apache.commons.math3.ml.distance.*; 
import org.apache.commons.math3.analysis.*; 
import org.apache.commons.math3.analysis.differentiation.*; 
import org.apache.commons.math3.analysis.integration.*; 
import org.apache.commons.math3.analysis.integration.gauss.*; 
import org.apache.commons.math3.analysis.function.*; 
import org.apache.commons.math3.analysis.polynomials.*; 
import org.apache.commons.math3.analysis.solvers.*; 
import org.apache.commons.math3.analysis.interpolation.*; 
import org.apache.commons.math3.stat.interval.*; 
import org.apache.commons.math3.stat.ranking.*; 
import org.apache.commons.math3.stat.clustering.*; 
import org.apache.commons.math3.stat.*; 
import org.apache.commons.math3.stat.inference.*; 
import org.apache.commons.math3.stat.correlation.*; 
import org.apache.commons.math3.stat.descriptive.*; 
import org.apache.commons.math3.stat.descriptive.rank.*; 
import org.apache.commons.math3.stat.descriptive.summary.*; 
import org.apache.commons.math3.stat.descriptive.moment.*; 
import org.apache.commons.math3.stat.regression.*; 
import org.apache.commons.math3.linear.*; 
import org.apache.commons.math3.*; 
import org.apache.commons.math3.distribution.*; 
import org.apache.commons.math3.distribution.fitting.*; 
import org.apache.commons.math3.complex.*; 
import org.apache.commons.math3.ode.*; 
import org.apache.commons.math3.ode.nonstiff.*; 
import org.apache.commons.math3.ode.events.*; 
import org.apache.commons.math3.ode.sampling.*; 
import org.apache.commons.math3.random.*; 
import org.apache.commons.math3.primes.*; 
import org.apache.commons.math3.optim.*; 
import org.apache.commons.math3.optim.linear.*; 
import org.apache.commons.math3.optim.nonlinear.vector.*; 
import org.apache.commons.math3.optim.nonlinear.vector.jacobian.*; 
import org.apache.commons.math3.optim.nonlinear.scalar.*; 
import org.apache.commons.math3.optim.nonlinear.scalar.gradient.*; 
import org.apache.commons.math3.optim.nonlinear.scalar.noderiv.*; 
import org.apache.commons.math3.optim.univariate.*; 
import org.apache.commons.math3.exception.*; 
import org.apache.commons.math3.exception.util.*; 
import org.apache.commons.math3.fitting.leastsquares.*; 
import org.apache.commons.math3.fitting.*; 
import org.apache.commons.math3.dfp.*; 
import org.apache.commons.math3.fraction.*; 
import org.apache.commons.math3.special.*; 
import org.apache.commons.math3.geometry.*; 
import org.apache.commons.math3.geometry.hull.*; 
import org.apache.commons.math3.geometry.enclosing.*; 
import org.apache.commons.math3.geometry.spherical.twod.*; 
import org.apache.commons.math3.geometry.spherical.oned.*; 
import org.apache.commons.math3.geometry.euclidean.threed.*; 
import org.apache.commons.math3.geometry.euclidean.twod.*; 
import org.apache.commons.math3.geometry.euclidean.twod.hull.*; 
import org.apache.commons.math3.geometry.euclidean.oned.*; 
import org.apache.commons.math3.geometry.partitioning.*; 
import org.apache.commons.math3.geometry.partitioning.utilities.*; 
import org.apache.commons.math3.optimization.*; 
import org.apache.commons.math3.optimization.linear.*; 
import org.apache.commons.math3.optimization.direct.*; 
import org.apache.commons.math3.optimization.fitting.*; 
import org.apache.commons.math3.optimization.univariate.*; 
import org.apache.commons.math3.optimization.general.*; 
import org.apache.commons.math3.util.*; 
import org.apache.commons.math3.genetics.*; 
import org.apache.commons.math3.transform.*; 
import org.apache.commons.math3.filter.*; 
import org.apache.commons.lang3.*; 
import org.apache.commons.lang3.arch.*; 
import org.apache.commons.lang3.builder.*; 
import org.apache.commons.lang3.compare.*; 
import org.apache.commons.lang3.concurrent.*; 
import org.apache.commons.lang3.event.*; 
import org.apache.commons.lang3.exception.*; 
import org.apache.commons.lang3.math.*; 
import org.apache.commons.lang3.mutable.*; 
import org.apache.commons.lang3.reflect.*; 
import org.apache.commons.lang3.text.*; 
import org.apache.commons.lang3.text.translate.*; 
import org.apache.commons.lang3.time.*; 
import org.apache.commons.lang3.tuple.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class map extends PApplet {

 //<>// //<>// //<>// //<>// //<>// //<>// //<>// //<>// //<>//

 //<>// //<>//























ControlP5 cp5;

//main map
UnfoldingMap map;
DebugDisplay debugDisplay;
EventDispatcher eventDispatcher = new EventDispatcher();

//global countries edge markers
List<Marker> countryMarkers;
//the mapprovider api
AbstractMapProvider provider1;
AbstractMapProvider provider2;

// data
HashMap<String, Catalog> catalogs = new HashMap<String, Catalog>();
HashMap<String, CountryData> countryCenter;
//catalogue names
String[] catalogue = new String[99];

//data file names
String[] filenames;

//rotate angle control
float rotateX;
float rotateZ;

public void setup() {
  music();
  plot3 = new GPlot(this);
  //default map size
  
  noStroke();

  //list the file to string
  listFile();

  //draw the buttons
  button();

  // Create debug display (optional: specify position and size)


  //initialize the map resource or control even
  provider1 = new StamenMapProvider.TonerBackground();
  //provider2 = new StamenMapProvider.TonerLite();
  provider2 = new Microsoft.AerialProvider();
  map = new UnfoldingMap(this);
  debugDisplay = new DebugDisplay(this, map);
  //MapUtils.createDefaultEventDispatcher(this, map);
  MouseHandler mouseHandler = new MouseHandler(this, map);
  KeyboardHandler keyboardHandler = new KeyboardHandler(this, map);
  eventDispatcher.addBroadcaster(mouseHandler);
  eventDispatcher.addBroadcaster(keyboardHandler);
  eventDispatcher.register(map, "zoom", map.getId());
  eventDispatcher.register(map, "pan", map.getId());

  //load countries edge marker
  List countries = GeoJSONReader.loadData(this, "countries.geo.json");
  countryMarkers = de.fhpotsdam.unfolding.utils.MapUtils.createSimpleMarkers(countries);
  //draw the countries edges
  for (Marker marker : countryMarkers) {
    marker.setColor(color(255, 255, 255, 0));
    marker.setHighlightColor(color(255, 0, 0, 100));
    marker.setStrokeWeight(2);
  }
  map.addMarkers(countryMarkers);

  //load plastic data
  //catalogs = loadDataFromCSV("plasticperpeople.csv");
  //load contries center coordinates data
  //loadDataFromCSV("populationpercontry.csv");
  catalogs = new HashMap<String, Catalog>();
  countryCenter = loadCoordFromCSV("country_centroids.csv");
  //map.panTo(new Location(0f, 0f));
}

public void draw() {

  //hint(ENABLE_DEPTH_TEST);

  pushMatrix();
  //control the 3D angle
  keycon();


  //initial the sketch
  background(0);


  translate(width*0.5f, height*0.5f);
  rotateX(rotateX);
  rotateZ(rotateZ);
  translate(-map.getWidth() / 2, -map.getHeight() / 2);

  //draw the map obviously!
  map.draw();

  //debugDisplay.draw();

  //some custom markers
  noStroke();
  circle(0, 0, 10);

  viz();

  popMatrix();
  scatter_operator();
  fuck_manage();
  classify();
  draw_classify();
  shadeLegend();
  hint(DISABLE_DEPTH_TEST);
  //drawdrawplot();
  dateacu();
  spanAndDance();
  shadeCountries();
  countryValue(cureentmarker);
  //make sure when user control the pannel don't effect the map
  if (mouseX < 280 || mouseY > 680) {
    eventDispatcher.unregister(map, "pan", map.getId());
    eventDispatcher.unregister(map, "zoom", map.getId());
  } else {
    eventDispatcher.register(map, "pan", map.getId());
    eventDispatcher.register(map, "zoom", map.getId());
  }
  drawdrawplot();
  fit_draw();
  draw_scatter_plot();
  if (classify_status) {
    if (plot3.isOverBox(mouseX, mouseY)) {
      eventDispatcher.unregister(map, "pan", map.getId());
      eventDispatcher.unregister(map, "zoom", map.getId());
    }
  }
}

//to control the provider change number
int c = 1;
int f = 1;
Boolean musicMode = false;

public void keycon() {
  if (!musicMode) {
    //rotate control the angle of map
    if (keyPressed) {
      if (key == 'w') {
        rotateX += 0.03f;
      } else if (key == 's') {
        rotateX -= 0.03f;
      } else if (key == 'a') {
        rotateZ -= 0.03f;
      } else if (key == 'd') {
        rotateZ += 0.03f;
      }
      if (key == 'h') {
        rotateX = rotateZ = 0;
        map.zoomAndPanTo(2, new Location(0f, -30f));
      }
    }
  }
}

public void keyPressed() {
  if (key == 'm') {
    musicMode = !musicMode;
    if (musicMode) {
      out.unmute();
    } else {
      out.mute();
    }
  }
  if (key == 'c') {
    c++;
    if (c%3 == 0) {
      map.mapDisplay.setProvider(new StamenMapProvider.TonerBackground());
      println(0);
    } else if (c%3 == 1) {
      map.mapDisplay.setProvider(new Microsoft.AerialProvider());
      println(1);
    } else if (c%3 == 2) {
      map.mapDisplay.setProvider(new StamenMapProvider.TonerLite());
      println(2);
    }
  }
  if (key == 'f') {
    f++;
  }
  if (musicMode) {
    if ( key == 'a' ) out.playNote(0, 1, new SineInstrument( ddf.minim.ugens.Frequency.ofPitch( "A4" ).asHz() ) );
    if ( key == 's' ) out.playNote(0, 1, new SineInstrument( ddf.minim.ugens.Frequency.ofPitch( "B4" ).asHz() ) );
    if ( key == 'd' ) out.playNote(0, 1, new SineInstrument( ddf.minim.ugens.Frequency.ofPitch( "C#5" ).asHz() ) );
    if ( key == 'f' ) out.playNote(0, 1, new SineInstrument( ddf.minim.ugens.Frequency.ofPitch( "D5" ).asHz() ) );
    if ( key == 'g' ) out.playNote(0, 1, new SineInstrument( ddf.minim.ugens.Frequency.ofPitch( "E5" ).asHz() ) );
    if ( key == 'h' ) out.playNote(0, 1, new SineInstrument( ddf.minim.ugens.Frequency.ofPitch( "F#5" ).asHz() ) );
    if ( key == 'j' ) out.playNote(0, 1, new SineInstrument( ddf.minim.ugens.Frequency.ofPitch( "G#5" ).asHz() ) );
    if ( key == 'k' ) out.playNote(0, 1, new SineInstrument( ddf.minim.ugens.Frequency.ofPitch( "A5" ).asHz() ) );
    if ( key == 'l' ) out.playNote(0, 1, new SineInstrument( ddf.minim.ugens.Frequency.ofPitch( "B5" ).asHz() ) );
    if ( key == ';' ) out.playNote(0, 1, new SineInstrument( ddf.minim.ugens.Frequency.ofPitch( "C#6" ).asHz() ) );
    if ( key == '\'') out.playNote(0, 1, new SineInstrument( ddf.minim.ugens.Frequency.ofPitch( "E6" ).asHz() ) );
  }
}

Marker cureentmarker;
Boolean movePlot = true;
//mark the mouse choosen marker
public void mouseMoved() {
  if (f%2 == 1) {
    // Deselect all marker
    for (Marker marker : map.getMarkers()) {
      marker.setSelected(false);
    }

    // Select hit marker
    // Note: Use getHitMarkers(x, y) if you want to allow multiple selection.
    Marker marker = map.getFirstHitMarker(mouseX, mouseY);
    if (marker != null) {
      marker.setSelected(true);
      drawPlot(marker);
      datafit(marker);
      cureentValueStatus = true;
      cureentmarker = marker;
    }
  }

  if (drawPPP) {
    if (movePlot) {
      if (mouseX < 300 && mouseY < 200) {
        plotOffY-=300;
        movePlot = !movePlot;
      } else if (mouseX < 300 && mouseY > 500) {
        plotOffY+=300;
        movePlot = !movePlot;
      }
    } else {
      if (mouseX < 300 && mouseY < 500 && mouseY > 200) {
        movePlot = !movePlot;
      }
    }
  }
}
public void loadDataFromCSV(String fileName) {
  //load the csv data

  String[] rows = loadStrings("data/userdata/"+fileName);

  //process the header
  String header = rows[0].split(",")[3];
  if (catalogs.get(header)!=null) {
    println("Nothing to do.");
    return;
  }
  
  if (header != null) {
    Catalog catalog = new Catalog();
    catalog.id = header;
    catalog.year = rows[0].split(",")[2];
    catalog.country = new HashMap<String, CountryData>();
    catalogs.put(catalog.id, catalog);
    importedItem.add(header);
  }

  rows[0] = "nothing";

  //load the catalog class
  HashMap<String, CountryData> country = catalogs.get(header).country;
  //initial CountryID
  String CountryId;
  //process data with ID
  for (String row : rows) {
    // Reads country name and population density value from CSV row
    String[] columns = row.split(",");
    if (columns.length > 3 &&!(columns[1].equals("OWID_WRL"))&& !(columns[1].equals("")) && !(columns[2].equals("")) && !(columns[3].equals(""))) {
      CountryId = columns[1];
      if (country.get(CountryId) != null) {
        Float valuea = Float.parseFloat(columns[2]);
        if (valuea > 9999999) {
          Integer valueb = Integer.parseInt(columns[2]);
          valuea = getExactDate(valueb/10000, valueb%10000/100, valueb%100);
        }
        CountryData data = country.get(CountryId);
        int in = ++data.index;
        data.value[0][in] = valuea;
        data.value[1][in] = Float.parseFloat(columns[3]);
      } else {
        Float valuea = Float.parseFloat(columns[2]);
        if (valuea > 9999999) {
          Integer valueb = Integer.parseInt(columns[2]);
          valuea = getExactDate(valueb/10000, valueb%10000/100, valueb%100);
        }
        CountryData dataEntry = new CountryData();
        dataEntry.index = 0;
        dataEntry.value = new Float[2][9999];
        dataEntry.countryName = columns[0];
        dataEntry.id = columns[1];
        dataEntry.value[0][0] = valuea;
        dataEntry.value[1][0] = Float.parseFloat(columns[3]);
        country.put(dataEntry.id, dataEntry);
      }
    }
  }
}

public HashMap<String, CountryData> loadCoordFromCSV(String fileName) {
  HashMap<String, CountryData> countryCenter = new HashMap<String, CountryData>();

  String[] rows = loadStrings(fileName);
  rows[0] = "nothing";
  for (String row : rows) {
    // Reads country name and population density value from CSV row
    String[] columns = row.split(",");
    if (columns.length >= 3) {
      CountryData dataEntry = new CountryData();
      dataEntry.countryName = columns[0];
      dataEntry.id = columns[1];
      dataEntry.longtitude = Float.parseFloat(columns[2]);
      dataEntry.latitude = Float.parseFloat(columns[3]);
      countryCenter.put(dataEntry.id, dataEntry);
    }
  }

  return countryCenter;
}

class CountryData {
  String countryName;
  String id;
  Float[][] value;
  int index;
  Float latitude;
  Float longtitude;
}

class Catalog {
  String id;
  //Date type
  String year;
  HashMap<String, CountryData> country;
}
Boolean classify_status = false; //<>//
GPlot plot3;

public void classify() {
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
        plot3.getYAxis().getAxisLabel().setOffset(0.5f);
        plot3.getYAxis().getAxisLabel().setRotate(true);
        plot3.getYAxis().getAxisLabel().setTextAlignment(RIGHT);
        plot3.getYAxis().getAxisLabel().setRelativePos(1);
        plot3.getYAxis().getAxisLabel().setOffset(40);
        plot3.getYAxis().setOffset(0.5f);
        plot3.getYAxis().setExpTickLabels(true);
        plot3.getYAxis().setRotateTickLabels(false);
        plot3.setPoints(points3);
        plot3.startHistograms(GPlot.VERTICAL);
        plot3.getHistogram().setDrawLabels(true);
        plot3.getHistogram().setRotateLabels(true);
        plot3.getHistogram().setBgColors(new int[] {color(255, 0, 0, 10)});
        plot3.getHistogram().setLineColors(new int[] {color(255, 0, 0, 10)});
        plot3.activatePanning();
        plot3.activateZooming(1.2f, LEFT, RIGHT);
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
          plot3.getLayer("layers"+j).getHistogram().setBgColors(new int[] {color(255, 0, 0, map(j, 0, (int)cp5.get(Numberbox.class, "NUM_Classify").getValue()-1, 10, 255))});
          plot3.getLayer("layers"+j).getHistogram().setLineColors(new int[] {color(255, 0, 0, map(j, 0, (int)cp5.get(Numberbox.class, "NUM_Classify").getValue()-1, 10, 255))});
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

public void draw_classify() {
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
public void fuck_manage() {
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
Boolean math_status = false;

public void control_math() {
  if (math_status) {
    cp5.remove("math_con");
    cp5.addGroup("math_con")
      .moveTo("MATH");
    cp5.addDropdownList("CatalogsListMathX")
      .setLabel("X:")
      .setPosition(10, 40)
      .setSize(250, 200)
      .setBarHeight(25)
      .setItemHeight(20)
      .setFont(createFont("Georgia", 15))
      .setGroup("math_con")
      ;

    cp5.addDropdownList("CatalogsListMathY")
      .setLabel("Y:")
      .setPosition(10, 280)
      .setSize(250, 200)
      .setBarHeight(25)
      .setItemHeight(20)
      .setFont(createFont("Georgia", 15))
      .setGroup("math_con")
      ;
    cp5.addDropdownList("math_method")
      .setLabel("Operators:")
      .setPosition(10, 160)
      .setSize(250, 200)
      .setBarHeight(25)
      .setItemHeight(20)
      .setFont(createFont("Georgia", 15))
      .setGroup("math_con")
      ;

    String[] temp = new String[cataList.size()];
    temp = cataList.toArray(temp);
    List m = Arrays.asList(temp);
    cp5.get(DropdownList.class, "CatalogsListMathX").setItems(m);
    cp5.get(DropdownList.class, "CatalogsListMathY").setItems(m);

    String[] operators = {"+", "-", "x", "÷"};
    List k = Arrays.asList(operators);
    cp5.get(DropdownList.class, "math_method").setItems(k);


    Button c = cp5.addButton("math_operator", 10);
    c.setLabel("CONFIRM")
      .setPosition(190, 500)
      .setGroup("math_con")
      ;

    cp5.addTextfield("newCatalogName")
      .setPosition(10, 400)
      .setAutoClear(false)
      .setLabel("New catalog name")
      .setSize(250, 20)
      .setGroup("math_con")
      ;
  }
}

public void math_operator() {
  String[] temp = new String[cataList.size()];
  temp = cataList.toArray(temp);
  if (temp != null) {
    String x = temp[(int)cp5.get(DropdownList.class, "CatalogsListMathX").getValue()];
    String y = temp[(int)cp5.get(DropdownList.class, "CatalogsListMathY").getValue()];

    int type = (int)cp5.get(DropdownList.class, "math_method").getValue();

    Catalog catalog = new Catalog();
    catalog.id = cp5.get(Textfield.class, "newCatalogName").getText();
    catalog.year = "year";
    catalog.country = new HashMap<String, CountryData>();
    catalogs.put(catalog.id, catalog);
    cataList.add(catalog.id);

    HashMap<String, CountryData> country = catalogs.get(catalog.id).country;
    String CountryId;

    HashMap<String, CountryData> countryX = catalogs.get(x).country;
    HashMap<String, CountryData> countryY = catalogs.get(y).country;

    for (String keys : countryX.keySet()) {
      if (countryY.get(keys) != null) {
        CountryData dataEntry = new CountryData();
        CountryData data = countryX.get(keys);
        dataEntry.id = data.id;
        dataEntry.countryName = data.countryName;
        dataEntry.value = new Float[2][9999];
        Float[][] valueX = data.value;
        Float[][] valueY = countryY.get(keys).value;
        int index = data.index + 1;

        int index_dataEnty = 0;
        if (type == 0) {
          for (int i = 0; i < index; i++) {
            float target = valueX[0][i];
            int target_index = findFloatinArray(target, valueY[0]);
            if (target_index != -1) {
              dataEntry.value[0][index_dataEnty] = valueX[0][i];
              dataEntry.value[1][index_dataEnty++] = valueX[1][i] + valueY[1][target_index];
            }
          }
          dataEntry.index = --index_dataEnty;
        } else if (type == 1) {
          for (int i = 0; i < index; i++) {
            float target = valueX[0][i];
            int target_index = findFloatinArray(target, valueY[0]);
            if (target_index != -1) {
              dataEntry.value[0][index_dataEnty] = valueX[0][i];
              dataEntry.value[1][index_dataEnty++] = valueX[1][i] - valueY[1][target_index];
            }
          }
          dataEntry.index = --index_dataEnty;
        } else if (type == 2) {
          for (int i = 0; i < index; i++) {
            float target = valueX[0][i];
            int target_index = findFloatinArray(target, valueY[0]);
            if (target_index != -1) {
              dataEntry.value[0][index_dataEnty] = valueX[0][i];
              dataEntry.value[1][index_dataEnty++] = valueX[1][i] * valueY[1][target_index];
            }
          }
          dataEntry.index = --index_dataEnty;
        } else if (type == 3) {
          for (int i = 0; i < index; i++) {
            float target = valueX[0][i];
            int target_index = findFloatinArray(target, valueY[0]);
            if (target_index != -1) {
              dataEntry.value[0][index_dataEnty] = valueX[0][i];
              dataEntry.value[1][index_dataEnty++] = valueX[1][i] / valueY[1][target_index];
            }
          }
          dataEntry.index = --index_dataEnty;
        }
        country.put(dataEntry.id, dataEntry);
      }
    }

    //update importlist for viz items
    HashMap<String, Float[]> yearss = new HashMap<String, Float[]>();
    Float[] year;
    int mm = 0;
    int hh = 0;
    String keyss = "helloyou";


    for (String name : cataList) {
      ArrayList<String> years  = new ArrayList<String>();
      HashMap<String, CountryData> country1 = catalogs.get(name).country;
      for (String key1 : country1.keySet()) {
        keyss = key1;
        break;
      }
      for (String keys : country1.keySet()) {
        hh = country1.get(keys).index;
        if (hh > mm) {
          mm = hh;
          keyss = keys;
        }
      }

      year = country1.get(keyss).value[0];
      yearss.put(name, year);
    }
    sliders(yearss);
    currentMaxMin(1);
  }
}
public String[] listFileNames(String dir) { //<>// //<>//
  File file = new File(dir);
  if (file.isDirectory()) {
    String names[] = file.list();
    return names;
  } else {
    // If it's not a directory
    return null;
  }
}

public void listFile() {
  String path = sketchPath("data/userdata/");
  filenames = listFileNames(path);
}


Boolean autochangedate = false;
float[] prevyear;
public void dateacu() {
  float[] year;
  String[] temp = new String[cataList.size()];
  temp = cataList.toArray(temp);
  year = new float[cataList.size()];
  int ind = 0;
  for (String k : temp) {
    year[ind++] = cp5.getController("year"+k).getValue();
  }
  if (Arrays.equals(prevyear, year)) {
    if (autochangedate) {
      for (String k : temp) {
        cp5.get(Numberbox.class, "year"+k).setValue(float2date2float(cp5.getController("year"+k).getValue()));
        cp5.get(Textlabel.class, "label"+k).setText(float2date(cp5.getController("year"+k).getValue()));
        autochangedate = !autochangedate;
      }
    }
  } else {
    prevyear = year;
    autochangedate = !autochangedate;
  }
}

HashMap<String, Scrollers> listControl = new HashMap<String, Scrollers>();
ArrayList<String> importedItem = new ArrayList<String>();

public void button() {

  cp5 = new ControlP5(this);
  Label.setUpperCaseDefault(false);

  cp5.addTextlabel("labelbbbb")
    .setText("A simple map, A simple world.")
    .setPosition(5, 730)
    .setColorValue(0xffffff00)
    .setFont(createFont("Georgia", 15))
    ;

  cp5.addFrameRate().setInterval(10).setPosition(0, height - 30);

  cp5.getTab("default")
    .activateEvent(true)
    .setLabel("VIEW")
    .setId(1)
    ;

  cp5.addTab("import");

  cp5.getTab("import")
    .activateEvent(true)
    .setLabel("IMPORT")
    .setId(2)
    ;

  cp5.addTab("DATA");

  cp5.getTab("DATA")
    .activateEvent(true)
    .setLabel("DATA")
    .setId(3)
    ;

  cp5.addTab("PLOT");

  cp5.getTab("PLOT")
    .activateEvent(true)
    .setLabel("PLOT")
    .setId(4)
    ;

  cp5.addTab("FIT");
  cp5.getTab("FIT")
    .activateEvent(true)
    .setLabel("FIT")
    .setId(5)
    ;

  cp5.addTab("CLASSIFY");
  cp5.getTab("CLASSIFY")
    .activateEvent(true)
    .setLabel("CLASSIFY")
    .setId(6)
    ;
    
  cp5.addTab("MATH");
  cp5.getTab("MATH")
    .activateEvent(true)
    .setLabel("MATH")
    .setId(7)
    ;
    
  cp5.addTab("SCATTER");
  cp5.getTab("SCATTER")
    .activateEvent(true)
    .setLabel("SCATTER")
    .setId(8)
    ;
  // create a few controllers

  List l = Arrays.asList(filenames);
  /* add a ScrollableList, by default it behaves like a DropdownList */
  cp5.addScrollableList("FileList")
    .setPosition(10, 40)
    .setSize(250, 200)
    .setBarHeight(25)
    .setItemHeight(20)
    .addItems(l)
    .setFont(createFont("Georgia", 15))
    // .setType(ScrollableList.LIST) // currently supported DROPDOWN and LIST
    ;
  listControl.put("FileList", new Scrollers("FileList"));

  cp5.addScrollableList("ImportList")
    .setPosition(10, 280)
    .setSize(250, 200)
    .setBarHeight(25)
    .setItemHeight(20)
    .setFont(createFont("Georgia", 15))
    // .setType(ScrollableList.LIST) // currently supported DROPDOWN and LIST
    ;
  listControl.put("ImportList", new Scrollers("ImportList"));

  cp5.addDropdownList("CatalogsListX")
    .setLabel("X:")
    .setPosition(10, 40)
    .setSize(250, 200)
    .setBarHeight(25)
    .setItemHeight(20)
    .setFont(createFont("Georgia", 15))
    // .setType(ScrollableList.LIST) // currently supported DROPDOWN and LIST
    ;

  cp5.addDropdownList("CatalogsListY")
    .setLabel("Y:")
    .setPosition(10, 280)
    .setSize(250, 200)
    .setBarHeight(25)
    .setItemHeight(20)
    .setFont(createFont("Georgia", 15))
    // .setType(ScrollableList.LIST) // currently supported DROPDOWN and LIST
    ;

  Button b = cp5.addButton("imports", 1);
  b.setLabel("IMPORT")
    .setPosition(190, 250)
    ;

  Button c = cp5.addButton("visualize", 2);
  c.setLabel("CONFIRM")
    .setPosition(190, 500)
    ;


  // arrange controller in separate tabs
  cp5.getController("FileList").moveTo("import");
  cp5.getController("ImportList").moveTo("import");
  cp5.getController("CatalogsListX").moveTo("FIT");
  cp5.getController("CatalogsListY").moveTo("FIT");

  cp5.getController("imports").moveTo("import");
  cp5.getController("visualize").moveTo("import");
  // Tab 'global' is a tab that lies on top of any 
  // other tab and is always visible
}

String markerCatalog = "";
Boolean visualstatus = true;

public void controlEvent(ControlEvent theControlEvent) {
  //println("got a control event from controller with id "+theControlEvent.getName());
  String temp = theControlEvent.getName();
  if (theControlEvent.isTab()) {
    if (theControlEvent.getTab().getId() == 3) {
      cp5.getGroup("g1").moveTo("DATA");
      cp5.getGroup("g1").setPosition(5, 30);
    }
    if (theControlEvent.getTab().getId() == 4) {
      drawPPP = !drawPPP;
    }
    if (theControlEvent.getTab().getId() == 5) {
      fit_status = !fit_status;
      fit_plot = !fit_plot;
      //cp5.getController("slider111").setVisible(!cp5.getController("slider111").isVisible());
      cp5.getController("CatalogsListX").setVisible(true);
      cp5.getController("CatalogsListY").setVisible(true);
      Button d = cp5.addButton("fit_button", 3);
      d.setLabel("FIT")
        .setPosition(180, 500)
        .moveTo("FIT")
        ;
      cp5.getController("fit_button").setVisible(true);
      cp5.remove("FitMethod");
      cp5.remove("ddegree");
      cp5.remove("slider111");
    }
    if (theControlEvent.getTab().getId() == 6) {
      plot3 = new GPlot(this);
      cp5.getGroup("g1").moveTo("CLASSIFY");
      cp5.getGroup("g1").setPosition(5, 450);
      classify_status = !classify_status;
      cp5.remove("CatalogChoose");
      cp5.remove("NUM_Classify");
      cp5.addDropdownList("CatalogChoose")
        .setLabel("Select one to classify")
        .setPosition(10, 40)
        .setSize(150, 200)
        .setBarHeight(25)
        .setItemHeight(20)
        .setFont(createFont("Georgia", 15))
        .moveTo("CLASSIFY");
      // .setType(ScrollableList.LIST) // currently supported DROPDOWN and LIST
      ;
      cp5.addNumberbox("NUM_Classify")
        .setPosition(180, 40)
        .setRange(2, 10)
        .setSize(20, 20)
        .setScrollSensitivity(1)
        .setValue(2)
        .setMultiplier(1)
        .moveTo("CLASSIFY");
      ;
      String[] temp1 = new String[cataList.size()];
      temp1 = cataList.toArray(temp1);
      List m = Arrays.asList(temp1);
      cp5.get(DropdownList.class, "CatalogChoose").setItems(m);
      String k = temp1[(int)cp5.get(DropdownList.class, "CatalogChoose").getValue()];
    }
    if (theControlEvent.getTab().getId() == 7) {
      math_status = !math_status;
      control_math();
    }
    if (theControlEvent.getTab().getId() == 8) {
      cp5.getGroup("g1").moveTo("SCATTER");
      cp5.getGroup("g1").setPosition(5, 450);
      scatter_status = !scatter_status;
      scatter_con();
    }
  }
  if (temp.charAt(0)=='b' && temp.length() > 10) {
    String c = temp.substring(10);
    if (cataList.contains(c)) {
      markerCatalog = c;
      shadeStatus = !shadeStatus;
    }
  } else if (temp.length() > 4) {
    if (temp.charAt(0)=='y') {
      plot3 = new GPlot(this);
      String a = temp.substring(4);
      if (cataList.contains(a)) {
        currentMaxMin(0);
        //cp5.getController("year"+a).setValue(float2date2float(cp5.getController("year"+a).getValue()));
        //cp5.get(Numberbox.class, "year"+a).setValue(float2date2float(cp5.getController("year"+a).getValue()));
      }
    }
    //"SENSE"
    if (temp.charAt(0)=='S') {
      String b = temp.substring(5);
      if (cataList.contains(b)) {
        cp5.get(Numberbox.class, "year"+b).setMultiplier(Float.parseFloat(cp5.get(Textfield.class, "SENSE"+b).getText()));
      }
    }
    //Marker
    if (temp.equals("Cancel")) {
      visualstatus = !visualstatus;
    } else if (temp.equals("AutoS")) {
      spanStatus = !spanStatus;
    }
  }
  if (temp.length() > 9) {
    if (temp.substring(0, 10).equals("slider1111")) {
      for (int j = 0; j < (int)cp5.get(Numberbox.class, "NUM_Classify").getValue(); j++) {
        if (cp5.get(Textlabel.class, "labelll"+j) != null) {
          cp5.get(Textlabel.class, "labelll"+j).setText(Float.toString(cp5.get(Slider.class, "slider1111"+j).getValue()));
        }
      }
    }
  }
}

//void CLASSIFY_CO() {
//  classify();
//}

Boolean fit_plot = false;
public void fit_button() {
  String[] fitMethods = {"Polynomial", "Gaussian", "Exponential"};
  cp5.get(DropdownList.class, "CatalogsListX").setVisible(false);
  cp5.get(DropdownList.class, "CatalogsListY").setVisible(false);
  cp5.addDropdownList("FitMethod")
    .setLabel("FIT TYPE")
    .setPosition(10, 350)
    .setSize(150, 200)
    .setBarHeight(25)
    .setItemHeight(20)
    .setFont(createFont("Georgia", 15))
    .setItems(Arrays.asList(fitMethods))
    // .setType(ScrollableList.LIST) // currently supported DROPDOWN and LIST
    ;
  cp5.getController("FitMethod").moveTo("FIT");
  cp5.remove("fit_button");
  //cp5.get(DropdownList.class, "FitMethod").setVisible(true);
}

public void FitMethod(int n) {
  cp5.remove("ddegree");
  cp5.remove("slider111");
  if (n == 0) {
    cp5.addNumberbox("ddegree")
      .setPosition(170, 350)
      .setRange(0, 10)
      .setSize(20, 20)
      .setScrollSensitivity(1)
      .setValue(1)
      .setMultiplier(1)
      .moveTo("FIT");
    ;
    cp5.addSlider("slider111")
      .setRange(0, 100)
      .setValue(0)
      .setPosition(20, 450)
      .setSize(100, 10)
      .moveTo("FIT")
      ;
  } else if (n == 1) {
  }
}

public void FileList(int n) {
  scrolCon("FileList", n);
}

public void imports(int theN) {
  importedItem = new ArrayList<String>();
  catalogs = new HashMap<String, Catalog>();
  //traverse all listControl
  int[] ad = listControl.get("FileList").contro;
  for (int i = 0; i < 50; i++) {
    if (ad[i] %2 != 0) {
      println(filenames[i]);
      loadDataFromCSV(filenames[i]);
      //vizList.add(filenames[i]);
    }
  }

  //update importlist for viz items
  String[] temp1 = new String[importedItem.size()];
  temp1 = importedItem.toArray(temp1);
  List m = Arrays.asList(temp1);
  cp5.get(ScrollableList.class, "ImportList").setItems(m);
}


public void ImportList(int n) {
  scrolCon("ImportList", n);
}

ArrayList<String> cataList = new ArrayList<String>();

public void visualize(int theN) {
  cataList = new ArrayList<String>();
  HashMap<String, Float[]> yearss = new HashMap<String, Float[]>();
  String[] temp11 = new String[cataList.size()];
  temp11 = cataList.toArray(temp11);
  int[] ad = listControl.get("ImportList").contro;
  for (int i = 0; i < 50; i++) {
    if (ad[i] %2 != 0 && !(isIn(importedItem.get(i), temp11))) {
      println(importedItem.get(i));
      cataList.add(importedItem.get(i));
    }
  }
  //update importlist for viz items
  Float[] year;
  int mm = 0;
  int hh = 0;
  String keyss = "helloyou";


  for (String name : cataList) {
    ArrayList<String> years  = new ArrayList<String>();
    HashMap<String, CountryData> country = catalogs.get(name).country;
    for (String key1 : country.keySet()) {
      keyss = key1;
      break;
    }
    for (String keys : country.keySet()) {
      hh = country.get(keys).index;
      if (hh > mm) {
        mm = hh;
        keyss = keys;
      }
    }

    year = country.get(keyss).value[0];
    yearss.put(name, year);
  }
  sliders(yearss);
}

public void sliders(HashMap<String, Float[]> yearss) {
  int[] colorbox = {color(255, 0, 0), color(0, 0, 255), color(0, 255, 0), color(255, 255, 0), color(255, 0, 255), color(0, 255, 255), color(255, 255, 255)};
  int colorindex = -1;
  cp5.remove("g1");
  //list the viz list
  String[] temp = new String[cataList.size()];
  temp = cataList.toArray(temp);
  int heights = -30;

  Group g1 = cp5.addGroup("g1")
    .setPosition(5, 30)
    .setBackgroundHeight(100)
    .setBackgroundColor(color(255, 50))
    .setLabel("Year")
    .setWidth(250)
    .setSize(250, 250)
    ;
  cp5.getGroup("g1").moveTo("DATA");
  cp5.addButton("Cancel")
    .setPosition(10, 200)
    .setSize(20, 20)
    .setGroup("g1")
    ;
  cp5.addButton("AutoS")
    .setPosition(50, 200)
    .setSize(20, 20)
    .setGroup("g1")
    ;
  for (String a : temp) {
    float min = mins(yearss.get(a));
    float max = maxs(yearss.get(a));
    println("min"+min+"max"+max);
    if ((max - min) < 0.000001f) {
      cp5.addNumberbox("year"+a)
        .setPosition(5, heights+=35)
        .setSize(200, 20)
        .setRange(min, min+1)
        .setMultiplier(1) // set the sensitifity of the numberbox
        .setValue(min)
        .setGroup("g1")
        .setLabel(a)
        ;
      cp5.getController("year"+a).getCaptionLabel().align(11, 3);
      cp5.addTextlabel("label"+a)
        .setText("")
        .setPosition(5, heights+20)
        .setGroup("g1")
        ;
      cp5.addTextfield("SENSE"+a)
        .setPosition(220, heights)
        .setAutoClear(false)
        .setLabel("Sense")
        .setSize(20, 20)
        .setGroup("g1")
        ;
      cp5.addButton("bbbbbbbbbb"+a)
        .setPosition(199, heights)
        .setSize(20, 20)
        .setColorBackground(colorbox[++colorindex])
        .setLabelVisible(false)
        .setGroup("g1")
        ;

      println(a+":"+cp5.getController("year"+a).getValue());
    } else {
      cp5.addNumberbox("year"+a)
        .setPosition(5, heights+=35)
        .setSize(100, 20)
        .setRange(min, max)
        .setMultiplier(1) // set the sensitifity of the numberbox
        .setValue(max)
        .setGroup("g1")
        .setLabel(a)
        ;
      cp5.getController("year"+a).getCaptionLabel().align(11, 3);
      cp5.addTextlabel("label"+a)
        .setText("")
        .setPosition(5, heights+20)
        .setGroup("g1")
        ;
      cp5.addTextfield("SENSE"+a)
        .setPosition(220, heights)
        .setAutoClear(false)
        .setLabel("Sense")
        .setSize(20, 20)
        .setGroup("g1")
        ;
      cp5.addButton("bbbbbbbbbb"+a)
        .setPosition(199, heights)
        .setSize(20, 20)
        .setColorBackground(colorbox[++colorindex])
        .setLabelVisible(false)
        .setGroup("g1")
        ;
      println(a+":"+cp5.getController("year"+a).getValue());
    }
  }
  currentMaxMin(1);
}

String prev_countryID = "";
public void dataViewer(HashMap<String, Float[]> currentCountryMaxMinValue, String countryId) {
  if (!prev_countryID.equals(countryId)) {
    prev_countryID = countryId;
    int heights = -65;
    cp5.remove("g2");
    Group g2 = cp5.addGroup("g2")
      .setPosition(5, 440)
      .setBackgroundHeight(100)
      .setBackgroundColor(color(255, 50))
      .setLabel("DataViewer")
      .setWidth(250)
      .setSize(250, 281)
      ;
    cp5.getGroup("g2").moveTo("DATA");

    Textarea myTextlabelA;
    myTextlabelA = cp5.addTextarea("labellabel")
      .setPosition(5, heights+=70)
      .setColorValue(0xffffff00)
      .setFont(createFont("Georgia", 15))
      .setWidth(245)
      .setHeight(280)
      .setGroup("g2")
      ;

    //list the viz list
    String tt = "";
    String[] temp = new String[cataList.size()];
    temp = cataList.toArray(temp);
    for (String a : temp) {
      Float[] temps = currentCountryMaxMinValue.get(a);
      String countryname = "Wrong";
      HashMap<String, CountryData> country = catalogs.get(a).country;
      if (maxMin.get(a) != null) {
        tt += a+":\n\tWorld:\n\t  Max:" + country.get(maxMin.get(a).maxcountryname).countryName + ":" + maxMin.get(a).max 
          + "\n\t  Min:" + country.get(maxMin.get(a).mincountryname).countryName + ":" + maxMin.get(a).min + 
          "\n\t  Average:" + maxMin.get(a).aver + "\n";
      }

      if (country.get(countryId) != null) {
        countryname = country.get(countryId).countryName;
      }
      if (temps != null) {
        String s = "\t"+countryname+":\n\t  Value:"+temps[3]
          +"\n\t  Max :"+temps[0]+"\n\t  Min :"+temps[1]+"\n\t  Aver:"+temps[2]+"\n\n";
        tt = tt+s;
        cp5.get(Textarea.class, "labellabel")
          .setText(tt)
          ;
      } else {
        //countryname+":\n"+a+":\n"+"\tNo Data Here."
        tt = tt + "\t"+countryname+":\n\t  No Data Here."+"\n";
        cp5.get(Textarea.class, "labellabel")
          .setText(tt)
          ;
      }
    }
  }
}
String preprevCountryName = "";//To detect the previous opreation country //<>// //<>//
Boolean fit_status = false;

ArrayList<Float> currentPoints;
ArrayList<Float> currentPointsY;
WeightedObservedPoints obs;
CountryPlot fitPlot = new CountryPlot();
public void datafit(Marker marker) {
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
              fitPlot.plot.getYAxis().getAxisLabel().setOffset(0.5f);
              fitPlot.plot.getYAxis().getAxisLabel().setRotate(true);
              fitPlot.plot.getYAxis().getAxisLabel().setTextAlignment(RIGHT);
              fitPlot.plot.getYAxis().getAxisLabel().setRelativePos(1);
              fitPlot.plot.getYAxis().getAxisLabel().setOffset(40);
              fitPlot.plot.getYAxis().setOffset(0.5f);
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
              fitPlot.plot.getYAxis().getAxisLabel().setOffset(0.5f);
              fitPlot.plot.getYAxis().getAxisLabel().setRotate(true);
              fitPlot.plot.getYAxis().getAxisLabel().setTextAlignment(RIGHT);
              fitPlot.plot.getYAxis().getAxisLabel().setRelativePos(1);
              fitPlot.plot.getYAxis().getAxisLabel().setOffset(40);
              fitPlot.plot.getYAxis().setOffset(0.5f);
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

public void fit_draw() {
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
public void polyFitPoints() {
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

public float[] exp_fit(float[] x, float[] y) {
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

public float[] leastSquareLinearFit(float[] x, float[] y) {
  float sum_x2 = 0.0f;
  float sum_y  = 0.0f;
  float sum_x  = 0.0f;
  float sum_xy = 0.0f;


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
public float maxs(Float[] temp) {
  float num, max  = -Float.MAX_VALUE;
  for (Float item : temp)
  {
    if (item != null) {
      num = item;
      if (num >= max)
      {
        max = num;
      }
    }
  }
  return max;
}

public float mins(Float[] temp) {
  float num, min  = Float.MAX_VALUE;
  for (Float item : temp)
  {
    if (item != null) {
      num = item;
      if (num <= min)
      {
        min = num;
      }
    }
  }
  if (min == Float.MAX_VALUE) {
    return Float.MIN_VALUE;
  }
  return min;
}

public float avers(Float[] temp, int n) {
  if (n == 0) {
    return 0;
  }
  float num  = 0;
  float aver = 0;
  for (Float item : temp)
  {
    if (item != null) {
      num += item;
    }
  }
  aver = num/n;
  return aver;
}

public int findFloatinArray(float target, Float[] temp) {
  int index = -1;
  for (Float rabbit : temp) {
    if (rabbit != null) {
      index++;
      if (rabbit == target) {
        return index;
      }
    } else {
      return -1;
    }
  }
  return -1;
}

int[] daysPerMonth = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int[] daysPerMonthLeapYear = new int[] {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

public float getExactDate(int year, int month, int day) {
  boolean leapYear = false;

  if (year % 400 == 0) {
    leapYear = true;
  } else if (year % 100 == 0) {
    leapYear = false;
  } else if (year % 4 == 0) {
    leapYear = true;
  }

  if (leapYear) {
    return year + (month - 1f + day*1.0f/daysPerMonthLeapYear[month])/12f;
  } else {
    return year + (month - 1f + day*1.0f/daysPerMonth[month])/12f;
  }
}

public float float2date2float(float num) {
  boolean leapYear = false;

  String s = Float.toString(num);
  int year = Integer.parseInt(s.substring(0, s.indexOf(".")));
  if (year % 400 == 0) {
    leapYear = true;
  } else if (year % 100 == 0) {
    leapYear = false;
  } else if (year % 4 == 0) {
    leapYear = true;
  }
  String temp = Float.toString(Float.parseFloat(s.substring(s.indexOf(".")))*12+1);
  int month = Integer.parseInt(temp.substring(0, temp.indexOf(".")));
  float temp1 = (Float.parseFloat(s.substring(s.indexOf("."))))*12;
  String temp2 = Float.toString(temp1);
  int day;
  if (leapYear) {
    day = (int)ceil(Float.parseFloat(temp2.substring(temp2.indexOf(".")))*daysPerMonthLeapYear[month]);
  } else {
    day = (int)ceil(Float.parseFloat(temp2.substring(temp2.indexOf(".")))*daysPerMonth[month]);
  }
  //println("year"+year+"month"+month+"day"+day);
  return getExactDate(year, month, day);
}

public String float2date(float num) {
  boolean leapYear = false;

  String s = Float.toString(num);
  int year = Integer.parseInt(s.substring(0, s.indexOf(".")));
  if (year % 400 == 0) {
    leapYear = true;
  } else if (year % 100 == 0) {
    leapYear = false;
  } else if (year % 4 == 0) {
    leapYear = true;
  }
  String temp = Float.toString(Float.parseFloat(s.substring(s.indexOf(".")))*12+1);
  int month = Integer.parseInt(temp.substring(0, temp.indexOf(".")));
  float temp1 = (Float.parseFloat(s.substring(s.indexOf("."))))*12;
  String temp2 = Float.toString(temp1);
  int day;
  if (leapYear) {
    day = (int)ceil(Float.parseFloat(temp2.substring(temp2.indexOf(".")))*daysPerMonthLeapYear[month]);
  } else {
    day = (int)ceil(Float.parseFloat(temp2.substring(temp2.indexOf(".")))*daysPerMonth[month]);
  }
  return year+"-"+month+"-"+day;
}

public int[] kmeans(float[] x, float[] y, int k) {
  int per_cluster = x.length/k;

  ArrayList<float[]> temp_x = new ArrayList<float[]>();
  ArrayList<float[]> temp_y = new ArrayList<float[]>();
  for (int i = 0; i < k-1; i++) {
    float[] xx = new float[per_cluster];
    float[] yy = new float[per_cluster];
    for (int j = 0; j < per_cluster; j++) {
      xx[j] = x[i*per_cluster+j];
      yy[j] = y[i*per_cluster+j];
    }
    temp_x.add(xx);
    temp_y.add(yy);
  }
  float[] xx = new float[x.length- (k-1)*per_cluster];
  float[] yy = new float[x.length- (k-1)*per_cluster];
  int j = 0;
  for (int i = (k-1)*per_cluster; i < x.length; i++) {
    xx[j] = x[i];
    yy[j++] = y[i];
  }
  temp_x.add(xx);
  temp_y.add(yy);
  //float x_center = points_center(x);
  //float y_center = points_center(y);
  float[] x_center = new float[k];
  float[] y_center = new float[k];
  for (int i = 0; i < k; i++) {
    x_center[i] = points_center(temp_x.get(i), temp_x.get(i).length);
    y_center[i] = points_center(temp_y.get(i), temp_y.get(i).length);
  }

  float[][] distance = new float[k][x.length];
  for (int i = 0; i < k; i++) {
    distance[i] = distance(x, y, x_center[i], y_center[i]);
  }

  int[] prev_index = new int[x.length];
  int[] index = new int[x.length];

  do {
    prev_index = index;
    index = new int[x.length];
    for (int i = 0; i < x.length; i++) {
      float min = distance[0][i];
      index[i] = 0;
      for (int n = 1; n < k; n++) {
        if (min > distance[n][i]) {
          index[i] = n;
          min = distance[n][i];
        }
      }
    }

    x_center = new float[k];
    y_center = new float[k];
    for (int i = 0; i < k; i++) {
      float[] temptemp_x = new float[x.length];
      float[] temptemp_y = new float[x.length];
      int count = 0;
      for (int n = 0; n < x.length; n++) {
        if (index[n] == i) {
          temptemp_x[n] = x[n];
          temptemp_y[n] = y[n];
          count++;
        }
      }
      x_center[i] = points_center(temptemp_x, count);
      y_center[i] = points_center(temptemp_y, count);
    }
    distance = new float[k][x.length];
    for (int i = 0; i < k; i++) {
      distance[i] = distance(x, y, x_center[i], y_center[i]);
    }
  } while (!indexIsSame(index, prev_index));
  //println(x_center);

  return index;
}

public float points_center(float[] x, int count) {
  float center = 0;
  for (int i = 0; i < x.length; i++) {
    center += x[i];
  }
  center = center/count;
  return center;
}

public float[] distance(float[] x, float[] y, float x_center, float y_center) {
  float[] distance = new float[x.length];
  for (int i = 0; i < x.length; i++) {
    distance[i] = sq(x[i]-x_center)+sq(y[i]-y_center);
  }
  return distance;
}

public Boolean indexIsSame(int[] index, int[] prev_index) {
  int count = 0;
  for (int i = 0; i < index.length; i++) {
    if (index[i] == prev_index[i]) {
      count++;
    }
  }

  if (count == index.length) {
    return true;
  } else {
    return false;
  }
}

public int[] sort_fuck(int k, float[] x_center) {
  int[] temp_index = new int[k];
  for (int i = 0; i < k; i++) {
    temp_index[i] = i;
  }
  for (int i = 0; i < k-1; i++) {
    float min = x_center[i];
    int min_index = temp_index[i];
    for (int n = i; n < k-1; n++) {
      if (min > x_center[n+1]) {
        min = x_center[n+1];
        x_center[n+1] = x_center[i];
        x_center[i] = min;
        min_index = temp_index[n+1];
        temp_index[n+1] = temp_index[i];
        temp_index[i] = min_index;
      }
    }
  }
  return temp_index;
}

public order_data sort_data(float[] data, String[] name) {
  for (int i = 0; i < data.length-1; i++) {
    float min = data[i];
    String min_index = name[i];
    for (int n = i; n < data.length-1; n++) {
      if (min > data[n+1]) {
        min = data[n+1];
        data[n+1] = data[i];
        data[i] = min;
        min_index = name[n+1];
        name[n+1] = name[i];
        name[i] = min_index;
      }
    }
  }
  
  order_data order_data = new order_data();
  order_data.data = data;
  order_data.name = name;
  return order_data;
}

class order_data {
  float[] data;
  String[] name;
}
// import everything necessary to make sound.



// create all of the variables that will need to be accessed in
// more than one methods (setup(), draw(), stop()).
Minim minim;
AudioOutput out;

public void music() {
  // initialize the minim and out objects
  minim = new Minim(this);
  out   = minim.getLineOut();

  out.mute();
}

// to make an Instrument we must define a class
// that implements the Instrument interface.
class SineInstrument implements Instrument
{
  Oscil wave;
  ddf.minim.ugens.Line  ampEnv;
  
  SineInstrument( float frequency )
  {
    // make a sine wave oscillator
    // the amplitude is zero because 
    // we are going to patch a Line to it anyway
    wave   = new Oscil( frequency, 0, Waves.SINE );
    ampEnv = new ddf.minim.ugens.Line();
    ampEnv.patch( wave.amplitude );
  }
  
  // this is called by the sequencer when this instrument
  // should start making sound. the duration is expressed in seconds.
  public void noteOn( float duration )
  {
    // start the amplitude envelope
    ampEnv.activate( duration, 0.5f, 0 );
    // attach the oscil to the output so it makes sound
    wave.patch( out );
  }
  
  // this is called by the sequencer when the instrument should
  // stop making sound
  public void noteOff()
  {
    wave.unpatch( out );
  }
}
HashMap<String, CountryPlot> thePlot = new HashMap<String, CountryPlot>();
Boolean drawPPP = false;
String prevCountryName = "";
//PShape star;
//star = loadShape("star.svg");
//star.disableStyle();

int plotOffY = 0;

public void drawPlot(Marker marker) {
  if (drawPPP) {
    if (!prevCountryName.equals(marker.getId())) {
      String countryId = marker.getId();
      prevCountryName = countryId;
      String[] temp = new String[cataList.size()];
      temp = cataList.toArray(temp);
      thePlot = new HashMap<String, CountryPlot>();
      int heights = 20+plotOffY;
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
          CountryPlot.plot.setPos(50, heights+=300);
          CountryPlot.plot.setPoints(plotpoints);
          CountryPlot.plot.getTitle().setText(countryName+" "+k);
          CountryPlot.plot.getTitle().setTextAlignment(LEFT);
          CountryPlot.plot.getXAxis().getAxisLabel().setText(catalogs.get(k).year);
          CountryPlot.plot.getYAxis().getAxisLabel().setText(k);
          CountryPlot.plot.getYAxis().getAxisLabel().setOffset(0.5f);
          CountryPlot.plot.getYAxis().getAxisLabel().setRotate(true);
          CountryPlot.plot.getYAxis().getAxisLabel().setTextAlignment(RIGHT);
          CountryPlot.plot.getYAxis().getAxisLabel().setRelativePos(1);
          CountryPlot.plot.getYAxis().getAxisLabel().setOffset(40);
          CountryPlot.plot.getYAxis().setOffset(0.5f);
          CountryPlot.plot.getYAxis().setExpTickLabels(true);
          CountryPlot.plot.getXAxis().setExpTickLabels(true);
          CountryPlot.plot.getYAxis().setRotateTickLabels(false);
          CountryPlot.plot.activatePanning();
          CountryPlot.plot.activateZooming(1.2f, LEFT, RIGHT);
          thePlot.put(k, CountryPlot);
        }
      }
    }
  }
}

public void drawdrawplot() {
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
        if (nowplot.isOverBox(mouseX, mouseY)) {
          eventDispatcher.unregister(map, "pan", map.getId());
          eventDispatcher.unregister(map, "zoom", map.getId());
        }
      }
    }
    popMatrix();
  }
}

class CountryPlot {
  String cataName;
  GPlot plot;
}
Boolean scatter_status = false;
GPlot scatter_plot;

public void scatter_con() {
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

public void scatter_operator() {
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
    scatter_plot.getYAxis().getAxisLabel().setOffset(0.5f);
    scatter_plot.getYAxis().getAxisLabel().setRotate(true);
    scatter_plot.getYAxis().getAxisLabel().setTextAlignment(RIGHT);
    scatter_plot.getYAxis().getAxisLabel().setRelativePos(1);
    scatter_plot.getYAxis().getAxisLabel().setOffset(40);
    scatter_plot.getYAxis().setOffset(0.5f);
    scatter_plot.getYAxis().setExpTickLabels(true);
    scatter_plot.getXAxis().setExpTickLabels(true);
    scatter_plot.getYAxis().setRotateTickLabels(false);
    scatter_plot.activatePointLabels();
    scatter_plot.activatePanning();
    scatter_plot.activateZooming(1.2f, LEFT, RIGHT);
  }
}

public void draw_scatter_plot() {
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
public Boolean isIn(String s, String[] z) {
  for (String temp : z) {
    if (temp.equals(s)) {
      return true;
    }
  }
  return false;
}

public void scrolCon(String name, int n) {
  println(n, cp5.get(ScrollableList.class, name).getItem(n));
  listControl.get(name).contro[n]++;
  CColor c = new CColor();
  c.setBackground(0xffD4C098);
  CColor a = new CColor();
  a.setBackground(0xff002D5A);
  if (listControl.get(name).contro[n]%2 != 0) {
    cp5.get(ScrollableList.class, name).getItem(n).put("color", c);
  } else {
    cp5.get(ScrollableList.class, name).getItem(n).put("color", a);
  }
}

class Scrollers {
  String id;
  int[] contro;
  Scrollers(String s) {
    id = s;
    contro = new int[99];
  }
}

public void printAr(Float[] data) {
  for (Float temp : data) {
    if (temp != null) {
      print(temp+"\t");
    }
  }
}
ArrayList<String> vizList = new ArrayList<String>();
public void viz() {
  if (visualstatus) {
    String[] temp = new String[cataList.size()];
    temp = cataList.toArray(temp);
    int offX = -7;
    for (String k : temp) {
      if (catalogs.get(k) != null) {
        offX += 7;
        float max = maxMin.get(k).max;
        float min = maxMin.get(k).min;
        HashMap<String, CountryData> country = catalogs.get(k).country;
        for (Marker marker : countryMarkers) {
          // Find data for country of the current marker

          String countryId = marker.getId();

          //get country Coordinates
          CountryData coordEntry = countryCenter.get(countryId);
          //get data
          CountryData dataEntry = country.get(countryId);

          float year = cp5.getController("year"+k).getValue();
          int indexs = -1;
          if (country.get(countryId) != null) {
            indexs = findFloatinArray(year, country.get(countryId).value[0]);
          }

          //check the data
          if (indexs != -1 && coordEntry != null) {

            //get the location
            ScreenPosition pos = map.getScreenPosition(new Location(coordEntry.latitude, coordEntry.longtitude));
            //evaluate the height of column
            //println("country:"+countryId+"value:"+dataEntry.value[1][indexs]+"min"+min+"max"+max);
            float zz = 0;
            if (min != max) {
              zz = map(dataEntry.value[1][indexs], min, max, 0, 300);
            }

            //chage the column color
            if (offX == 0) {
              fill(255, 0, 0, zz);
            } else if (offX == 7) {
              fill(0, 0, 255, zz);
            } else if (offX == 14) {
              fill(0, 255, 0, zz);
            } else if (offX == 21) {
              fill(255, 255, 0, zz);
            } else if (offX == 28) {
              fill(255, 0, 255, zz);
            } else if (offX == 35) {
              fill(0, 255, 255, zz);
            } else if (offX == 42) {
              fill(255, 255, 255, zz);
            }
            //translate the axis and draw
            textAlign(CENTER, BOTTOM);
            textSize(5);
            pushMatrix();
            translate(pos.x+offX, pos.y, zz/2);
            box(5, 5, zz);
            fill(255, 0, 0);
            translate(0, 0, zz/2);
            rotateX(-HALF_PI);
            text(String.format("%.02e", dataEntry.value[1][indexs]), 0, 0, 0);
            popMatrix();
          }
        }
      }
    }
  }
}

Boolean cureentValueStatus = false;
int cureentValueSpeed = 0;
HashMap<String, Float[]> currentCountryMaxMinValue;
public void countryValue(Marker marker) {
  if (cureentValueStatus) {
    if (cureentValueSpeed++ % 30 == 0) {
      currentCountryMaxMinValue = new HashMap<String, Float[]>();
      String countryId = marker.getId();
      String[] temp = new String[cataList.size()];
      temp = cataList.toArray(temp);
      for (String k : temp) {
        if (catalogs.get(k) != null) {
          HashMap<String, CountryData> country = catalogs.get(k).country;
          CountryData dataEntry = country.get(countryId);
          if (dataEntry != null) {
            int indexs = findFloatinArray(cp5.getController("year"+k).getValue(), dataEntry.value[0]);
            if (indexs != -1) {
              HashMap<String, MaxMin> countryMaxMin = maxMin.get(k).countryMaxMin;
              Float[] currentCountryMaxMin = new Float[4];
              currentCountryMaxMin[0] = countryMaxMin.get(countryId).max;
              currentCountryMaxMin[1] = countryMaxMin.get(countryId).min;
              currentCountryMaxMin[2] = countryMaxMin.get(countryId).aver;
              currentCountryMaxMin[3] = dataEntry.value[1][indexs];
              currentCountryMaxMinValue.put(k, currentCountryMaxMin);
              //println(k+" "+countryId+"max:"+max+"min:"+min+"aver:"+aver+"value:"+value);
            }
          }
        }
      }
      dataViewer(currentCountryMaxMinValue, countryId);
    }
  }
}

//Storage the maxmin data of the vizList
HashMap<String, MaxMin> maxMin = new HashMap<String, MaxMin>();
//evaluate the vizList data
public void currentMaxMin(int status) {
  String[] temp = new String[cataList.size()];
  temp = cataList.toArray(temp);
  for (String k : temp) {
    if (catalogs.get(k) != null) {
      //Calculate the year max min
      Float[] data = new Float[9999];
      int index = 0;
      HashMap<String, CountryData> country = catalogs.get(k).country;
      float year = cp5.getController("year"+k).getValue();

      String[] name = new String[999];
      for (String keys : country.keySet()) {
        int indexs = findFloatinArray(year, country.get(keys).value[0]);
        if (indexs != -1) {
          name[index] = keys;
          data[index++] = country.get(keys).value[1][indexs];
        }
      }
      //printAr(data);

      //println(k+"max:"+maxs(data)+"min"+mins(data)+"aver:"+avers(data, index));

      if (maxMin.get(k) == null) {
        MaxMin tempMaxmin1 = new MaxMin();
        tempMaxmin1.max = maxs(data);
        tempMaxmin1.min = mins(data);
        tempMaxmin1.aver = avers(data, index);
        println("max"+tempMaxmin1.max);
        int number = findFloatinArray(tempMaxmin1.max, data);
        int number1 = findFloatinArray(tempMaxmin1.min, data);
        if (number != -1) {
          tempMaxmin1.maxcountryname = name[number];
        }
        if (number1 != -1) {
          tempMaxmin1.mincountryname = name[number1];
        }
        maxMin.put(k, tempMaxmin1);
      } else {
        maxMin.get(k).max = maxs(data);
        maxMin.get(k).min = mins(data);
        maxMin.get(k).aver = avers(data, index);
        int number = findFloatinArray(maxMin.get(k).max, data);
        int number1 = findFloatinArray(maxMin.get(k).min, data);
        if (number != -1) {
          maxMin.get(k).maxcountryname = name[number];
        }
        if (number1 != -1) {
          maxMin.get(k).mincountryname = name[number1];
        }
      }

      //calculate the countries maxmin
      if (status == 1) {
        println("status"+status);
        for (String keys : country.keySet()) {
          Float[] data1 = new Float[9999];
          int ind = country.get(keys).index + 1;
          for (int i = 0; i < ind; i++) {
            data1[i] = country.get(keys).value[1][i];
          }
          MaxMin tempMaxmin = new MaxMin();
          tempMaxmin.max = maxs(data1);
          tempMaxmin.min = mins(data1);
          tempMaxmin.aver = avers(data1, ind);
          //println("max:"+maxMin.get("Population").max);
          maxMin.get(k).countryMaxMin.put(keys, tempMaxmin);
        }
        //println(maxMin.get("Population").countryMaxMin.get("AFG").aver);
      }
    }
  }
}

Boolean shadeStatus = false;
public void shadeCountries() {
  if (shadeStatus) {
    for (Marker marker : countryMarkers) {
      // Find data for country of the current marker
      String countryId = marker.getId();
      HashMap<String, CountryData> country = catalogs.get(markerCatalog).country;
      if (maxMin.get(markerCatalog) != null) {
        Float max = maxMin.get(markerCatalog).max;
        Float min = maxMin.get(markerCatalog).min;
        if (country.get(countryId) != null) {
          float year = cp5.getController("year"+markerCatalog).getValue();
          int indexs = findFloatinArray(year, country.get(countryId).value[0]);
          if (indexs != -1) {
            // Encode value as brightness (values range: 0-1000)
            float transparency = map(country.get(countryId).value[1][indexs], min, max, 10, 255);
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


public void shadeLegend() {
  if (shadeStatus) {
    textSize(20);
    int heights = 78;
    Float max = maxMin.get(markerCatalog).max;
    Float min = maxMin.get(markerCatalog).min;
    noStroke();
    fill(255);
    rect(1200, 84, 20, 600);
    for (int i = 0; i < 100; i++) {
      fill(255, 0, 0, lerp(255, 10, i*0.01f));
      rect(1200, heights+=6, 20, 6);
      if (i % 10 == 0) {
        fill(255);
        text(String.format("%.02e", lerp(max, min, i*0.01f)), 1200, heights);
      }
    }
  }
}

//void shadeLegend() {
//  if (shadeStatus) {
//    textSize(20);
//    int heights = 75;
//    Float max = maxMin.get(markerCatalog).max;
//    Float min = maxMin.get(markerCatalog).min;
//    noStroke();
//    fill(255);
//    pushMatrix();
//    translate(1200, 384, 30);
//    //rect(1200, 84, 20, 600);
//    box(20,600,20);
//    popMatrix();
//    pushMatrix();
//    translate(1200, heights+=6, 30);
//    for (int i = 0; i < 100; i++) {
//      fill(255, 0, 0, lerp(255, 10, i*0.01f));
//      //rect(1200, heights+=6, 20, 6);
//      translate(0, 6, 0);
//      box(20,6,20);
//      if (i % 10 == 0) {
//        fill(255);
//        text(String.format("%.02e", lerp(max, min, i*0.1f)), 0, 0, 0);
//      }
//    }
//    popMatrix();
//  }
//}

Boolean spanStatus = false;
int spanSpeed = 0;
public void spanAndDance() {
  if (spanStatus) {
    spanSpeed++;
    if (spanSpeed % 30 == 0) {
      String[] temp = new String[cataList.size()];
      temp = cataList.toArray(temp);
      for (String k : temp) {
        println(cp5.get(Numberbox.class, "year"+k).getValue()+cp5.get(Numberbox.class, "year"+k).getMultiplier());
        cp5.get(Numberbox.class, "year"+k).setValue(cp5.get(Numberbox.class, "year"+k).getValue()+cp5.get(Numberbox.class, "year"+k).getMultiplier());
      }
    }
  }
}

class MaxMin {
  Float max;
  Float min;
  Float aver;
  String maxcountryname;
  String mincountryname;
  HashMap<String, MaxMin> countryMaxMin;
  MaxMin() {
    countryMaxMin = new HashMap<String, MaxMin>();
    maxcountryname = "";
    mincountryname = "";
  }
}
  public void settings() {  size(1280, 768, P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "map" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
