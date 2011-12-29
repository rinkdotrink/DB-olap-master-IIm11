package de.datagenerator;

import com.google.inject.AbstractModule;

import de.datagenerator.creator.Creator;
import de.datagenerator.dbwriter.DBKundeWriter;
import de.datagenerator.dbwriter.DBProduktWriter;
import de.datagenerator.dbwriter.DBWKorbProduktWriter;
import de.datagenerator.dbwriter.DBWarenkorbWriter;
import de.datagenerator.generator.Generator;
import de.datagenerator.generator.KundenGenerator;
import de.datagenerator.generator.ProduktGenerator;
import de.datagenerator.generator.WKorbGenerator;
import de.datagenerator.generator.WKorbProduktGenerator;

public class DBModule
   extends AbstractModule {

   @Override
   protected void configure() {
      bind(Generator.class);
      bind(Creator.class);
      bind(WKorbGenerator.class);
      bind(KundenGenerator.class);
      bind(ProduktGenerator.class);
      bind(WKorbProduktGenerator.class);
      bind(DBKundeWriter.class);
      bind(DBProduktWriter.class);
      bind(DBWarenkorbWriter.class);
      bind(DBWKorbProduktWriter.class);
   }
}
