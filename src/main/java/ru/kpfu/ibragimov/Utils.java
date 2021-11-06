package ru.kpfu.ibragimov;

import java.util.Date;
import java.util.UUID;

public class Utils {

  public static String randomString() {
    return UUID.randomUUID().toString();
  }

  public static String getYear(Date date) {
    return date.toString().split(" ")[5];
  }

  public static int getMonth(Date date) {
   switch (date.toString().split(" ")[1]) {
     case "Jan":
       return 1;
     case "Feb":
       return 2;
     case "Mar":
       return 3;
     case "Apr":
       return 4;
     case "May":
       return 5;
     case "Jun":
       return 6;
     case "Jul":
       return 7;
     case "Aug":
       return 8;
     case "Sep":
       return 9;
     case "Oct":
       return 10;
     case "Nov":
         return 11;
     case "Dec":
       return 12;
     default:
       return -1;
   }
  }

  public static String getDay(Date date) {
    return date.toString().split(" ")[2];
  }

  public static String getTime(Date date) {
    return date.toString().split(" ")[3];
  }

  public static String getTimeStamp(Date d) {
    String month = getMonth(d) < 10 ? "0" + Integer.toString(getMonth(d)) : Integer.toString(getMonth(d));
    return getYear(d) + "-" + month + "-" + getDay(d) + "T" + getTime(d);
  }
}
