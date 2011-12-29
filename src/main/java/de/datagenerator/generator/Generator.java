package de.datagenerator.generator;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.datagenerator.DBModule;
import de.datagenerator.creator.Creator;
import de.datagenerator.datamodel.Product;
import de.datagenerator.dbwriter.DBWriter;

public class Generator {

   private Creator creator;

   private Product product;

   private DBWriter dbWriter;

   private Generator strategy;

   private Injector injector = Guice.createInjector(new DBModule());

   public void generate(final long aKunden, final long aProdukte,
                        final long aWarenkoerbeProKunde,
                        final long aProdukteInWarenkorb) {
      generateKunden(aKunden);
      generateProdukte(aProdukte);
      generateWarenkorb(aKunden, aWarenkoerbeProKunde);
      generateProdukteInWarenkorb(aKunden * aWarenkoerbeProKunde
         * aProdukteInWarenkorb, aProdukteInWarenkorb);
   }

   public void generateKunden(final long aAnzahl) {
      strategy = injector.getInstance(KundenGenerator.class);
      strategy.generateKunden(aAnzahl);
   };

   public void generateProdukte(final long aAnzahl) {
      strategy = injector.getInstance(ProduktGenerator.class);
      strategy.generateProdukte(aAnzahl);
   };

   public void generateWarenkorb(final long aKunden,
                                 final long aWarenkoerbeProKunde) {
      strategy = injector.getInstance(WKorbGenerator.class);
      strategy.generateWarenkorb(aKunden, aWarenkoerbeProKunde);
   };

   public void generateProdukteInWarenkorb(final long aBestellzeilen,
                                           final long aProdukteInWarenkorb) {
      strategy = injector.getInstance(WKorbProduktGenerator.class);
      strategy.generateProdukteInWarenkorb(aBestellzeilen, aProdukteInWarenkorb);
   };

   protected final Creator getCreator() {
      return creator;
   }

   protected final void setCreator(final Creator aCreator) {
      this.creator = aCreator;
   }

   protected final Product getProduct() {
      return product;
   }

   protected final void setProduct(final Product aProduct) {
      this.product = aProduct;
   }

   protected final void setDBWriter(final DBWriter aDBWriter) {
      this.dbWriter = aDBWriter;
   }

   protected final DBWriter getDBWriter() {
      return dbWriter;
   }
}
