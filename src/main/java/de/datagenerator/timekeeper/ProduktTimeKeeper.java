package de.datagenerator.timekeeper;

import java.util.Date;

public class ProduktTimeKeeper
   extends TimeKeeper {

   public static void startTimeProdukt() {
      start = new Date().getTime();
      System.out.print("schreibe " + produkte + " Produkte: ");
   }

   static public void endTime() {
      System.out.println(getRunningTimeKundeInSeconds() + " s");
   }

}
