float maxs(Float[] temp) {
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

float mins(Float[] temp) {
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

float avers(Float[] temp, int n) {
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

int findFloatinArray(float target, Float[] temp) {
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

float getExactDate(int year, int month, int day) {
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

float float2date2float(float num) {
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

String float2date(float num) {
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
