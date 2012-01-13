package de.datagenerator.timekeeper;


public class WKorbProduktTimeKeeper
   extends TimeKeeper {


   static public void endTime() {
      System.out.println("schreibe " + kunden * wKoerbeProKunde * produkteInWarenkorb + " WarenkorbProdukte: "
         + getRunningTimeKundeInSeconds() + " s");
   }
}
