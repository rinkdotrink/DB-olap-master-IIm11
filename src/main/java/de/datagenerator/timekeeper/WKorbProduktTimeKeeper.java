package de.datagenerator.timekeeper;

import java.util.Date;

public class WKorbProduktTimeKeeper
   extends TimeKeeper {

   public static void startTimeWKorbProdukt() {
      start = new Date().getTime();
      System.out.print("schreibe [" + kunden + " Kunden * " + wKoerbeProKunde
         + " Warenkoerbe pro Kunde * " + produkteInWarenkorb
         + " Produkte in Warenkorb =] " + kunden * wKoerbeProKunde
         * produkteInWarenkorb + " WarenkorbProdukte: ");
   }

   static public void endTime() {
      System.out.println(getRunningTimeKundeInSeconds() + " s");
      allTime += getRunningTimeKundeInSeconds();
      System.out.println("TotalTime: " +allTime+ " s");
   }
}
