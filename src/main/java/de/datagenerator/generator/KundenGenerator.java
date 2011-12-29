package de.datagenerator.generator;

import com.google.inject.Inject;

import de.datagenerator.creator.Creator;
import de.datagenerator.dbwriter.DBKundeWriter;

public class KundenGenerator
   extends Generator {

   @Inject
   public KundenGenerator(final Creator aCreator, final DBKundeWriter aDbWriter) {
      setCreator(aCreator);
      setDBWriter(aDbWriter);
   }

   @Override
   public final void generateKunden(final long aKunden) {
      long aId;
      String aName;
      long aKundenNummer;
      for (long i = 0; i < aKunden; i++) {
         aId = i;
         aName = "Customer" + aId;
         aKundenNummer = i;
         setProduct(getCreator().createKunde(aId, aName, aKundenNummer));
         getDBWriter().write(getProduct());
      }
      getDBWriter().close();
   }

}
