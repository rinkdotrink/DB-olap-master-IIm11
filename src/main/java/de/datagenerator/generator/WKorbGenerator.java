package de.datagenerator.generator;



import java.util.Date;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import de.datagenerator.creator.Creator;
import de.datagenerator.dbwriter.IDBWriter;
import de.datagenerator.generator.util.WKorbGeneratorUtil;

public class WKorbGenerator
   extends Generator {

   @Inject
   public WKorbGenerator(final Creator aCreator, @Named("WKorb") final IDBWriter aDbWriter) {
      setCreator(aCreator);
      setDBWriter(aDbWriter);
   }

   @Override
   public final void generateWarenkorb(final long aKunden,
                                       final long aWarenkoerbeProKunde) {
      long kundenId;
      long warenkorbId = 0;
      int tt = 01;
      int mm = 01;
      final int yyyy = 2011;
      
      for (long iKunde = 0; iKunde < aKunden; iKunde++) {
         kundenId = iKunde;
         for (long iWarenkorbProKunde = 0; iWarenkorbProKunde < aWarenkoerbeProKunde; iWarenkorbProKunde++) {
            mm = (int)(warenkorbId % 12) + 1;
            Date datum = WKorbGeneratorUtil.getDate(tt,mm,yyyy);            
            setProduct(getCreator().createWKorb(warenkorbId, kundenId, datum));
            getDBWriter().write(getProduct());
            warenkorbId++;
         }
      }
      getDBWriter().close();
   }

}
