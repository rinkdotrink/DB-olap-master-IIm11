package de.datagenerator.timekeeper;

import java.util.Date;

public class ProduktTimeKeeper {

   static long startProdukt = 0;

   public static void startTimeProdukt() {
      startProdukt = new Date().getTime();
   }

   public static void endTimeProdukt() {
      System.out.println("schreibe Produkte: "
         + getRunningTimeProduktInSeconds() + " s");
   }

   private static long getRunningTimeProduktInSeconds() {
      long runningTime = new Date().getTime() - startProdukt;
      return runningTime / 1000;
   }
}
