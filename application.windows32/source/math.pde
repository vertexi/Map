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

int[] kmeans(float[] x, float[] y, int k) {
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

float points_center(float[] x, int count) {
  float center = 0;
  for (int i = 0; i < x.length; i++) {
    center += x[i];
  }
  center = center/count;
  return center;
}

float[] distance(float[] x, float[] y, float x_center, float y_center) {
  float[] distance = new float[x.length];
  for (int i = 0; i < x.length; i++) {
    distance[i] = sq(x[i]-x_center)+sq(y[i]-y_center);
  }
  return distance;
}

Boolean indexIsSame(int[] index, int[] prev_index) {
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

int[] sort_fuck(int k, float[] x_center) {
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

order_data sort_data(float[] data, String[] name) {
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
