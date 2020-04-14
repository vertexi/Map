String[] listFileNames(String dir) { //<>//
  File file = new File(dir);
  if (file.isDirectory()) {
    String names[] = file.list();
    return names;
  } else {
    // If it's not a directory
    return null;
  }
}

void listFile() {
  String path = sketchPath("data/userdata/");
  filenames = listFileNames(path);
}


Boolean autochangedate = false;
float[] prevyear;
void dateacu() {
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

void button() {

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
  cp5.getController("imports").moveTo("import");
  cp5.getController("visualize").moveTo("import");

  // Tab 'global' is a tab that lies on top of any 
  // other tab and is always visible
}

String markerCatalog = "";
Boolean visualstatus = true;

void controlEvent(ControlEvent theControlEvent) {
  println("got a control event from controller with id "+theControlEvent.getName());
  String temp = theControlEvent.getName();
  if (theControlEvent.isTab()) {
    if (theControlEvent.getTab().getId() == 4) {
      drawPPP = !drawPPP;
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
}

void FileList(int n) {
  scrolCon("FileList", n);
}

void imports(int theN) {
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


void ImportList(int n) {
  scrolCon("ImportList", n);
}

ArrayList<String> cataList = new ArrayList<String>();

void visualize(int theN) {
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

void sliders(HashMap<String, Float[]> yearss) {
  color[] colorbox = {color(255, 0, 0), color(0, 0, 255), color(0, 255, 0), color(255, 255, 0), color(255, 0, 255), color(0, 255, 255), color(255, 255, 255)};
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
    if ((max - min) < 0.000001) {
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

void dataViewer(HashMap<String, Float[]> currentCountryMaxMinValue, String countryId) {
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
        + "\n\t  Min:" + country.get(maxMin.get(a).mincountryname).countryName + ":" + maxMin.get(a).min + "\n";
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
