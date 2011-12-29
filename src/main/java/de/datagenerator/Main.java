package de.datagenerator;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.datagenerator.generator.Generator;

public class Main {

   public static void main(final String[] args) {
      final int kundeIdx = 0;
      final int produktIdx = 1;
      final int wKoerbeIdx = 2;
      final int produkteInWKorbIdx = 3;

      long kunden = Long.valueOf(args[kundeIdx]);
      long produkte = Long.valueOf(args[produktIdx]);
      long wKoerbe = Long.valueOf(args[wKoerbeIdx]);
      long produkteInWKorb = Long.valueOf(args[produkteInWKorbIdx]);

      Injector injector = Guice.createInjector(new DBModule());
      Generator dataGenStrat = injector.getInstance(Generator.class);
      dataGenStrat.generate(kunden, produkte, wKoerbe, produkteInWKorb);
   }
}
