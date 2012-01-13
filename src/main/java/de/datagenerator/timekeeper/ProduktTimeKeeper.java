package de.datagenerator.timekeeper;


public class ProduktTimeKeeper
   extends TimeKeeper {
   
   static public void endTime() {
      System.out.println("schreibe " + produkte + " Produkte: "
         + getRunningTimeKundeInSeconds() + " s");
   }

}
