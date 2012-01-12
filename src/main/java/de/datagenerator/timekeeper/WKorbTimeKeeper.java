package de.datagenerator.timekeeper;

import java.util.Date;

public class WKorbTimeKeeper {

   static long startWKorb = 0;

   public static void startTimeWKorb() {
      startWKorb = new Date().getTime();
   }

   public static void endTimeWKorb() {
      System.out.println("schreibe WKoerbe: " + getRunningTimeWKorbInSeconds()
         + " s");
   }

   private static long getRunningTimeWKorbInSeconds() {
      long runningTime = new Date().getTime() - startWKorb;
      return runningTime / 1000;
   }
}
