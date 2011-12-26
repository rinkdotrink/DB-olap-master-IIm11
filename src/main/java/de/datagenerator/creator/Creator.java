package de.datagenerator.creator;

import de.datagenerator.datamodel.FactoryMethodProduct;
import de.datagenerator.datamodel.Kunde;
import de.datagenerator.datamodel.Produkt;
import de.datagenerator.datamodel.Warenkorb;
import de.datagenerator.datamodel.WarenkorbProdukt;

public class Creator {

   public final FactoryMethodProduct factMethKunde(final long aId,
                                                   final String aName,
                                                   final long aKundenNummer) {
      return new Kunde(aId, aName, aKundenNummer);
   }

   public final FactoryMethodProduct factMethProdukt(final long aId,
                                                     final String aName,
                                                     final Integer aPreis) {
      return new Produkt(aId, aName, aPreis);
   }

   public final FactoryMethodProduct factMethWarenkorb(final long aId,
                                                       final long aKundenId) {
      return new Warenkorb(aId, aKundenId);
   }

   public final FactoryMethodProduct factMethWarenkorbProdukt(final long aBestellzeileId,
                                                              final long aWarenkorbId,
                                                              final long aProduktId) {
      return new WarenkorbProdukt(aBestellzeileId, aWarenkorbId, aProduktId);
   }

}
