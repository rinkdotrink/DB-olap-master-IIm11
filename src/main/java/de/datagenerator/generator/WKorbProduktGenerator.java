package de.datagenerator.generator;

import com.google.inject.Inject;

import de.datagenerator.creator.Creator;
import de.datagenerator.dbwriter.DBWKorbProduktWriter;

public class WKorbProduktGenerator
   extends Generator {

   private long produktId = 0;

   private long modzaehler = 0;

   private long warenkorbId = 0;

   private long bestellZeilenId = 0;

   @Inject
   public WKorbProduktGenerator(final Creator aCreator,
                                final DBWKorbProduktWriter aDbWriter) {
      setCreator(aCreator);
      setDBWriter(aDbWriter);
   }

   @Override
   public final void generateProdukteInWarenkorb(final long aBestellzeilen,
                                                 final long aProdukteInWarenkorb) {
      if (aBestellzeilen == 1) {
         createWarenkorbProdukt();
      }
      for (long aktBestellzeile = 0; aktBestellzeile < aBestellzeilen / 2; aktBestellzeile++) {
         createWarenkorbProdukt();
         createWarenkorbProdukt();
         warenkorbId++;
      }
      getDBWriter().close();
   }

   private void createWarenkorbProdukt() {
      produktId = modzaehler % 5;
      setProduct(getCreator().createWKorbProdukt(bestellZeilenId, warenkorbId,
                                                 produktId));
      getDBWriter().write(getProduct());
      modzaehler++;
      bestellZeilenId++;
   }

}
