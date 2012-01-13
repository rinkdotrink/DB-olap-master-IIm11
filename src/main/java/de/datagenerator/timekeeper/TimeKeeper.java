package de.datagenerator.timekeeper;

import java.util.Date;

public class TimeKeeper {

   static long start = 0;

   static long kunden;
   static long produkte;
   static long wKoerbeProKunde;
   static long produkteInWarenkorb;

   public static void setParameter(final long aKunden, final long aProdukte,
                                   final long aWKoerbeProKunde,
                                   final long aProdukteInWarenkorb) {
      kunden = aKunden;
      produkte = aProdukte;
      wKoerbeProKunde = aWKoerbeProKunde;
      produkteInWarenkorb = aProdukteInWarenkorb;

   }

   public static void startTime() {
      start = new Date().getTime();
   }

   protected static long getRunningTimeKundeInSeconds() {
      long runningTime = new Date().getTime() - start;
      return runningTime / 1000;
   }
}
