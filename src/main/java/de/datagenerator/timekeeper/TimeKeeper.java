package de.datagenerator.timekeeper;

import java.util.Date;

public abstract class TimeKeeper {

   static long start = 0;

   static long kunden;
   static long produkte;
   static long wKoerbeProKunde;
   static long produkteInWarenkorb;
   static long allTime = 0;

   public static void setParameter(final long aKunden, final long aProdukte,
                                   final long aWKoerbeProKunde,
                                   final long aProdukteInWarenkorb) {
      kunden = aKunden;
      produkte = aProdukte;
      wKoerbeProKunde = aWKoerbeProKunde;
      produkteInWarenkorb = aProdukteInWarenkorb;

   }

   protected static long getRunningTimeKundeInSeconds() {
      long runningTime = new Date().getTime() - start;
      return runningTime / 1000;
   }   
   
   
}
