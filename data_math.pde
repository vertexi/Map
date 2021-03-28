Boolean math_status = false;

void control_math() {
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

void math_operator() {
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
