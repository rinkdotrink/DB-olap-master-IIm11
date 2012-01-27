package de.datagenerator.timekeeper;

import java.util.Date;

public class WKorbTimeKeepter
   extends TimeKeeper {

   public static void startTimeWKorb() {
      start = new Date().getTime();
      System.out.print("schreibe [" + kunden + " Kunden * " + wKoerbeProKunde + " Warenkoerbe pro Kunde =] " + kunden * wKoerbeProKunde
         + " Warenkoerbe: ");
   }

   static public void endTime() {
      System.out.println(getRunningTimeKundeInSeconds() + " s");
      allTime += getRunningTimeKundeInSeconds();
   }
}
