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
   public final void generateProdukteInWKorb(final long aBestellzeilen,
                                             final long aProdukteInWKorb) {
      if (aBestellzeilen == 1) {
         createWKorbProdukt();
      }
      for (long aktBestellzeile = 0; aktBestellzeile < aBestellzeilen / 2; aktBestellzeile++) {
         createWKorbProdukt();
         createWKorbProdukt();
         warenkorbId++;
      }
      getDBWriter().close();
   }

   private void createWKorbProdukt() {
      produktId = modzaehler % 5;
      setProduct(getCreator().createProdukteInWKorb(bestellZeilenId,
                                                    warenkorbId, produktId));
      getDBWriter().write(getProduct());
      modzaehler++;
      bestellZeilenId++;
   }

}
