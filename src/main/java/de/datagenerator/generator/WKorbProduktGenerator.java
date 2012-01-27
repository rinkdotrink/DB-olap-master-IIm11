package de.datagenerator.generator;

import java.util.Date;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import de.datagenerator.creator.Creator;
import de.datagenerator.dbwriter.IDBWriter;
import de.datagenerator.generator.util.WKorbGeneratorUtil;

public class WKorbProduktGenerator
   extends Generator {

   private long produktId = 0;
   private long warenkorbId = 0;
   private long bestellZeilenId = 0;

   @Inject
   public WKorbProduktGenerator(final Creator aCreator,
                                @Named("WKorbProdukt") final IDBWriter aDbWriter) {
      setCreator(aCreator);
      setDBWriter(aDbWriter);
   }

   @Override
   public final void generateProdukteInWKorb(final long aBestellzeilen,
                                             final long aProdukte,
                                             final long aProdukteInWarenkorb) {
      int tt = 01;
      int mm = 01;
      final int yyyy = 2011;
      
      for (long aktBestellzeile = 0; aktBestellzeile < aBestellzeilen; aktBestellzeile++) {
         mm = (int)(bestellZeilenId % 12) + 1;
         tt = (int)(bestellZeilenId % 26) + 1;
         Date datum = WKorbGeneratorUtil.getDate(tt,mm,yyyy);
         produktId = bestellZeilenId % aProdukte;
         setProduct(getCreator().createProdukteInWKorb(bestellZeilenId,
                                                       warenkorbId, produktId, datum));
         getDBWriter().write(getProduct());
         bestellZeilenId++;
         warenkorbId = bestellZeilenId / aProdukteInWarenkorb;
      }
      getDBWriter().close();
   }

}
