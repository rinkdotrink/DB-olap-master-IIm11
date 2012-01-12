package de.datagenerator;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MyDate
   implements Serializable {

   private static final long serialVersionUID = 3551621824261286937L;
   private Date date;
   private Calendar calender;

   public MyDate() {
   }

   public MyDate(int tt, int mm, int yyyy) {
      int day = Integer.valueOf(tt);
      int month = Integer.valueOf(mm);
      int year = Integer.valueOf(yyyy);

      calender = new GregorianCalendar(year, month - 1, day);
      date = calender.getTime();
   }

   public Date getDate() {
      return date;
   }
}
