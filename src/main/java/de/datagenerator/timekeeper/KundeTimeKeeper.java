package de.datagenerator.timekeeper;


public class KundeTimeKeeper
   extends TimeKeeper {

   static public void endTime() {
      System.out.println("schreibe " + kunden + " Kunden: "
         + getRunningTimeKundeInSeconds() + " s");
   }
}
