package de.datagenerator.generator;

import com.google.inject.Inject;

import de.datagenerator.creator.Creator;
import de.datagenerator.dbwriter.DBKundeWriter;

public class KundenGenerator
   extends DataGeneratorStrategy {

   @Inject
   public KundenGenerator(final Creator aCreator, final DBKundeWriter aDbWriter) {
      setCreator(aCreator);
      setDBWriter(aDbWriter);
   }

   @Override
   public final void generateKunden(final long aAnzahl) {
      long aId;
      String aName;
      long aKundenNummer;
      for (long i = 0; i < aAnzahl; i++) {
         aId = i;
         aName = "Customer" + aId;
         aKundenNummer = i;
         setFactoryMethodProduct(getCreator().factMethKunde(aId, aName,
                                                            aKundenNummer));
         getDBWriter().write(getFactoryMethodProduct());
      }
      getDBWriter().close();
   }

}
