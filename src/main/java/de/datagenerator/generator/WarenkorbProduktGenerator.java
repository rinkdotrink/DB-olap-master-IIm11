package de.datagenerator.generator;

import com.google.inject.Inject;

import de.datagenerator.creator.Creator;
import de.datagenerator.dbwriter.DBWarenkorbProduktWriter;

public class WarenkorbProduktGenerator
   extends DataGeneratorStrategy {

   private long produktId = 0;

   private long modzaehler = 0;

   private long warenkorbId = 0;

   private long bestellZeilenId = 0;

   @Inject
   public WarenkorbProduktGenerator(final Creator aCreator,
                                    final DBWarenkorbProduktWriter aDbWriter) {
      setCreator(aCreator);
      setDBWriter(aDbWriter);
   }

   @Override
   public final void generateProdukteInWarenkorb(final long aAnzahlBestellzeilen,
                                                 final long aAnzahlProdukteInWarenkorb) {
      if (aAnzahlBestellzeilen == 1) {
         createWarenkorbProdukt();
      }
      for (long aktBestellzeile = 0; aktBestellzeile < aAnzahlBestellzeilen / 2; aktBestellzeile++) {
         createWarenkorbProdukt();
         createWarenkorbProdukt();
         warenkorbId++;
      }
      getDBWriter().close();
   }

   private void createWarenkorbProdukt() {
      produktId = modzaehler % 5;
      setFactoryMethodProduct(getCreator().factMethWarenkorbProdukt(bestellZeilenId,
                                                                    warenkorbId,
                                                                    produktId));
      getDBWriter().write(getFactoryMethodProduct());
      modzaehler++;
      bestellZeilenId++;
   }

}
