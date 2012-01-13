package de.datagenerator.timekeeper;


public class WKorbTimeKeepter
   extends TimeKeeper {


   static public void endTime() {
      System.out.println("schreibe " + kunden * wKoerbeProKunde + " Warenkoerbe: "
         + getRunningTimeKundeInSeconds() + " s");
   }
}
