void loadDataFromCSV(String fileName) {
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

        // debug_message
        println(dataEntry.id);

        dataEntry.value[0][0] = valuea;
        dataEntry.value[1][0] = Float.parseFloat(columns[3]);
        country.put(dataEntry.id, dataEntry);
      }
    }
  }
}

HashMap<String, CountryData> loadCoordFromCSV(String fileName) {
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
