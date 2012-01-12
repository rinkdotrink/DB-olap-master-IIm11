package de.datagenerator.generator.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class WKorbGeneratorUtil {

   public static Date getDate(int tt, int mm, int yyyy) {
      Calendar calender = new GregorianCalendar(yyyy, mm - 1, tt);
      Date date = calender.getTime();
      return date;
   }
}
