package de.datagenerator.timekeeper;

import java.util.Date;

public class KundeTimeKeeper {

   static long startKunde = 0;

   public static void startTimeKunde() {
      startKunde = new Date().getTime();
   }

   static public void endTimeKunde() {
      System.out.println("schreibe Kunden: " + getRunningTimeKundeInSeconds()
         + " s");
   }

   private static long getRunningTimeKundeInSeconds() {
      long runningTime = new Date().getTime() - startKunde;
      return runningTime / 1000;
   }
}
