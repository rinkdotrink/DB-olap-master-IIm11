package de.datagenerator.generator;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.datagenerator.DBModule;
import de.datagenerator.creator.Creator;
import de.datagenerator.datamodel.FactoryMethodProduct;
import de.datagenerator.dbwriter.DBWriter;

public class DataGeneratorStrategy {

   private Creator creator;

   private FactoryMethodProduct factMethProd;

   private DBWriter dbWriter;

   private DataGeneratorStrategy strategy;

   private Injector injector = Guice.createInjector(new DBModule());

   public void generateTemplateMethod(final long aAnzKunden,
                                      final long aAnzProdukte,
                                      final long aAnzWarenkoerbeProKunde,
                                      final long aAnzProdukteInWarenkorb) {
      generateKunden(aAnzKunden);
      generateProdukte(aAnzProdukte);
      generateWarenkorb(aAnzKunden, aAnzWarenkoerbeProKunde);
      generateProdukteInWarenkorb(aAnzKunden * aAnzWarenkoerbeProKunde
         * aAnzProdukteInWarenkorb, aAnzProdukteInWarenkorb);
   }

   public void generateKunden(final long aAnzahl) {
      strategy = injector.getInstance(KundenGenerator.class);
      strategy.generateKunden(aAnzahl);
   };

   public void generateProdukte(final long aAnzahl) {
      strategy = injector.getInstance(ProduktGenerator.class);
      strategy.generateProdukte(aAnzahl);
   };

   public void generateWarenkorb(final long aAnzahlKunde,
                                 final long aAnzahlWarenkoerbeProKunde) {
      strategy = injector.getInstance(WarenkorbGenerator.class);
      strategy.generateWarenkorb(aAnzahlKunde, aAnzahlWarenkoerbeProKunde);
   };

   public void generateProdukteInWarenkorb(final long aAnzahlBestellzeilen,
                                           final long aAnzahlProdukteInWarenkorb) {
      strategy = injector.getInstance(WarenkorbProduktGenerator.class);
      strategy.generateProdukteInWarenkorb(aAnzahlBestellzeilen,
                                           aAnzahlProdukteInWarenkorb);
   };

   protected final Creator getCreator() {
      return creator;
   }

   protected final void setCreator(final Creator aCreator) {
      this.creator = aCreator;
   }

   protected final FactoryMethodProduct getFactoryMethodProduct() {
      return factMethProd;
   }

   protected final void setFactoryMethodProduct(final FactoryMethodProduct aFactoryMethodProduct) {
      this.factMethProd = aFactoryMethodProduct;
   }

   protected final void setDBWriter(final DBWriter aDBWriter) {
      this.dbWriter = aDBWriter;
   }

   protected final DBWriter getDBWriter() {
      return dbWriter;
   }
}
