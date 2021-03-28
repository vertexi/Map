Boolean isIn(String s, String[] z) {
  for (String temp : z) {
    if (temp.equals(s)) {
      return true;
    }
  }
  return false;
}

void scrolCon(String name, int n) {
  println(n, cp5.get(ScrollableList.class, name).getItem(n));
  listControl.get(name).contro[n]++;
  CColor c = new CColor();
  c.setBackground(#D4C098);
  CColor a = new CColor();
  a.setBackground(#002D5A);
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

void printAr(Float[] data) {
  for (Float temp : data) {
    if (temp != null) {
      print(temp+"\t");
    }
  }
}
