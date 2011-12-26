package de.datagenerator.generator;

import com.google.inject.Inject;

import de.datagenerator.creator.Creator;
import de.datagenerator.dbwriter.DBProduktWriter;

public class ProduktGenerator
   extends DataGeneratorStrategy {

   @Inject
   public ProduktGenerator(final Creator aCreator,
                           final DBProduktWriter aDbWriter) {
      setCreator(aCreator);
      setDBWriter(aDbWriter);
   }

   @Override
   public final void generateProdukte(final long aAnzahl) {
      long id;
      String name;
      Integer preis;
      for (long i = 0; i < aAnzahl; i++) {
         id = i;
         name = "Product" + id;
         preis = Integer.valueOf(1);
         setFactoryMethodProduct(getCreator().factMethProdukt(id, name, preis));
         getDBWriter().write(getFactoryMethodProduct());
      }
      getDBWriter().close();
   }

}
