package de.datagenerator.timekeeper;

import java.util.Date;

public class KundeTimeKeeper
   extends TimeKeeper {

   public static void startTimeKunde() {
      start = new Date().getTime();      
      System.out.print("schreibe " + kunden + " Kunden: ");
   }

   public static void endTime() {
      System.out.println(getRunningTimeKundeInSeconds() + " s");
      allTime += getRunningTimeKundeInSeconds();
   }
}
