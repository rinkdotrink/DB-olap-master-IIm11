package de.datagenerator.generator;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import de.datagenerator.creator.Creator;
import de.datagenerator.dbwriter.IDBWriter;

public class WKorbProduktGenerator
   extends Generator {

   private long produktId = 0;
   private long warenkorbId = 0;
   private long bestellZeilenId = 0;

   @Inject
   public WKorbProduktGenerator(final Creator aCreator,
                                @Named("WKorbProdukt") final IDBWriter aDbWriter) {
      setCreator(aCreator);
      setDBWriter(aDbWriter);
   }

   @Override
   public final void generateProdukteInWKorb(final long aBestellzeilen,
                                             final long aProdukte,
                                             final long aProdukteInWarenkorb) {
      for (long aktBestellzeile = 0; aktBestellzeile < aBestellzeilen; aktBestellzeile++) {
         produktId = bestellZeilenId % aProdukte;
         setProduct(getCreator().createProdukteInWKorb(bestellZeilenId,
                                                       warenkorbId, produktId));
         getDBWriter().write(getProduct());
         bestellZeilenId++;
         warenkorbId = bestellZeilenId / aProdukteInWarenkorb;
      }
      getDBWriter().close();
   }

}
