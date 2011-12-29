package de.datagenerator.generator;

import com.google.inject.Inject;

import de.datagenerator.creator.Creator;
import de.datagenerator.dbwriter.DBProduktWriter;

public class ProduktGenerator
   extends Generator {

   @Inject
   public ProduktGenerator(final Creator aCreator,
                           final DBProduktWriter aDbWriter) {
      setCreator(aCreator);
      setDBWriter(aDbWriter);
   }

   @Override
   public final void generateProdukte(final long aProdukte) {
      long id;
      String name;
      Integer preis;
      for (long i = 0; i < aProdukte; i++) {
         id = i;
         name = "Product" + id;
         preis = Integer.valueOf(1);
         setProduct(getCreator().createProdukt(id, name, preis));
         getDBWriter().write(getProduct());
      }
      getDBWriter().close();
   }

}
