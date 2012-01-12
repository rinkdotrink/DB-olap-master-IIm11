package de.datagenerator.timekeeper;

import java.util.Date;

public class WKorbProduktTimeKeeper {

   static long startWKorbProdukt = 0;

   public static void startTimeWKorbProdukt() {
      startWKorbProdukt = new Date().getTime();
   }

   public static void endTimeWKorbProdukt() {
      System.out.println("schreibe WKorbProdukte: "
         + getRunningTimeWKorbProduktInSeconds() + " s");
   }

   private static long getRunningTimeWKorbProduktInSeconds() {
      long runningTime = new Date().getTime() - startWKorbProdukt;
      return runningTime / 1000;
   }

}
