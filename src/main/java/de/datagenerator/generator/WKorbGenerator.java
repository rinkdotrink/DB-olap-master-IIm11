package de.datagenerator.generator;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import de.datagenerator.creator.Creator;
import de.datagenerator.dbwriter.IDBWriter;

public class WKorbGenerator
   extends Generator {

   @Inject
   public WKorbGenerator(final Creator aCreator,
                         @Named("WKorb") final IDBWriter aDbWriter) {
      setCreator(aCreator);
      setDBWriter(aDbWriter);
   }

   @Override
   public final void generateWarenkorb(final long aKunden,
                                       final long aWarenkoerbeProKunde) {
      long kundenId;
      long warenkorbId = 0;
      for (long iKunde = 0; iKunde < aKunden; iKunde++) {
         kundenId = iKunde;
         for (long iWarenkorbProKunde = 0; iWarenkorbProKunde < aWarenkoerbeProKunde; iWarenkorbProKunde++) {
            setProduct(getCreator().createWKorb(warenkorbId, kundenId));
            getDBWriter().write(getProduct());
            warenkorbId++;
         }
      }
      getDBWriter().close();
   }

}
