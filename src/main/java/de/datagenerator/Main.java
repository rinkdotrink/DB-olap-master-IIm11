package de.datagenerator;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.datagenerator.generator.DataGeneratorStrategy;

public class Main {

   public static void main(final String[] args) {
      int kundeIdx = 0; 
      int produktIdx = 1;
      int warenkoerbeIdx = 2;
      int produkteInWarenkoerbeIdx = 3;
      
      long anzKunde = Long.valueOf(args[kundeIdx]);
      long anzProdukte = Long.valueOf(args[produktIdx]);
      long anzWarenkoerbe = Long.valueOf(args[warenkoerbeIdx]);
      long anzProdukteInWarenkorb = Long.valueOf(args[produkteInWarenkoerbeIdx]);

      Injector injector = Guice.createInjector(new DBModule());
      DataGeneratorStrategy dataGeneratorStrategy =
         injector.getInstance(DataGeneratorStrategy.class);
      dataGeneratorStrategy.generateTemplateMethod(anzKunde, anzProdukte,
                                                   anzWarenkoerbe,
                                                   anzProdukteInWarenkorb);
   }
}
