ArrayList<String> vizList = new ArrayList<String>();
void viz() {
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
void countryValue(Marker marker) {
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
void currentMaxMin(int status) {
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
void shadeCountries() {
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


void shadeLegend() {
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
        text(String.format("%.02e", lerp(max, min, i*0.1f)), 1200, heights);
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
void spanAndDance() {
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
