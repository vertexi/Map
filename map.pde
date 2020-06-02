import grafica.*; //<>// //<>// //<>// //<>// //<>// //<>// //<>// //<>// //<>//

import controlP5.*; //<>// //<>// //<>// //<>//

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

void setup() {
  music();
  plot3 = new GPlot(this);
  //default map size
  size(1280, 768, P3D);
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

void draw() {

  //hint(ENABLE_DEPTH_TEST);

  pushMatrix();
  //control the 3D angle
  keycon();


  //initial the sketch
  background(0);


  translate(width*0.5, height*0.5);
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
  fuck_manage();
  classify();
  drawdrawplot();
  fit_draw();
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

void keycon() {
  if (!musicMode) {
    //rotate control the angle of map
    if (keyPressed) {
      if (key == 'w') {
        rotateX += 0.03;
      } else if (key == 's') {
        rotateX -= 0.03;
      } else if (key == 'a') {
        rotateZ -= 0.03;
      } else if (key == 'd') {
        rotateZ += 0.03;
      }
      if (key == 'h') {
        rotateX = rotateZ = 0;
        map.zoomAndPanTo(2, new Location(0f, -30f));
      }
    }
  }
}

void keyPressed() {
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
void mouseMoved() {
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
