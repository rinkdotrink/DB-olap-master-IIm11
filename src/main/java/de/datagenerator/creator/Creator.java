package de.datagenerator.creator;

import java.util.Date;

import de.datagenerator.datamodel.Kunde;
import de.datagenerator.datamodel.Product;
import de.datagenerator.datamodel.Produkt;
import de.datagenerator.datamodel.WKorb;
import de.datagenerator.datamodel.WKorbProdukt;

public class Creator {

   public final Product createKunde(final long aId, final String aName,
                                    final long aKundenNr) {
      return new Kunde(aId, aName, aKundenNr);
   }

   public final Product createProdukt(final long aId, final String aName,
                                      final Integer aPreis) {
      return new Produkt(aId, aName, aPreis);
   }

   public final Product createWKorb(final long aId, final long aKundenId) {
      return new WKorb(aId, aKundenId);
   }

   public final Product createProdukteInWKorb(final long aBestellzeileId,
                                              final long aWKorbId,
                                              final long aProduktId,
                                              final Date aDatum) {
      return new WKorbProdukt(aBestellzeileId, aWKorbId, aProduktId, aDatum);
   }

}
