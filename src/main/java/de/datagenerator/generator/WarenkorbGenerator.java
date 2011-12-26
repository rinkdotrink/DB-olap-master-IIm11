package de.datagenerator.generator;

import com.google.inject.Inject;

import de.datagenerator.creator.Creator;
import de.datagenerator.dbwriter.DBWarenkorbWriter;

public class WarenkorbGenerator
   extends DataGeneratorStrategy {

   @Inject
   public WarenkorbGenerator(final Creator aCreator,
                             final DBWarenkorbWriter aDbWriter) {
      setCreator(aCreator);
      setDBWriter(aDbWriter);
   }

   @Override
   public final void generateWarenkorb(final long aAnzahlKunden,
                                       final long aAnzahlWarenkoerbeProKunde) {
      long kundenId;
      long warenkorbId = 0;
      for (long iKunde = 0; iKunde < aAnzahlKunden; iKunde++) {
         kundenId = iKunde;
         for (long iWarenkorbProKunde = 0; iWarenkorbProKunde < aAnzahlWarenkoerbeProKunde; iWarenkorbProKunde++) {
            setFactoryMethodProduct(getCreator().factMethWarenkorb(warenkorbId,
                                                                   kundenId));
            getDBWriter().write(getFactoryMethodProduct());
            warenkorbId++;
         }
      }
      getDBWriter().close();
   }

}
