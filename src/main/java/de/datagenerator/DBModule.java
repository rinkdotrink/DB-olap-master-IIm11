package de.datagenerator;

import com.google.inject.AbstractModule;

import de.datagenerator.creator.Creator;
import de.datagenerator.dbwriter.DBKundeWriter;
import de.datagenerator.dbwriter.DBProduktWriter;
import de.datagenerator.dbwriter.DBWarenkorbProduktWriter;
import de.datagenerator.dbwriter.DBWarenkorbWriter;
import de.datagenerator.generator.DataGeneratorStrategy;
import de.datagenerator.generator.KundenGenerator;
import de.datagenerator.generator.ProduktGenerator;
import de.datagenerator.generator.WarenkorbGenerator;
import de.datagenerator.generator.WarenkorbProduktGenerator;

public class DBModule
   extends AbstractModule {

   @Override
   protected void configure() {
      bind(DataGeneratorStrategy.class);
      bind(Creator.class);
      bind(WarenkorbGenerator.class);
      bind(KundenGenerator.class);
      bind(ProduktGenerator.class);
      bind(WarenkorbProduktGenerator.class);
      bind(DBKundeWriter.class);
      bind(DBProduktWriter.class);
      bind(DBWarenkorbWriter.class);
      bind(DBWarenkorbProduktWriter.class);
   }
}
