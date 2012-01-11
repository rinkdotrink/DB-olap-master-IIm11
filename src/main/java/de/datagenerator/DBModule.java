package de.datagenerator;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

import de.datagenerator.creator.Creator;
import de.datagenerator.dbwriter.DBKundeWriter;
import de.datagenerator.dbwriter.DBProduktWriter;
import de.datagenerator.dbwriter.DBWKorbProduktWriter;
import de.datagenerator.dbwriter.DBWKorbWriter;
import de.datagenerator.generator.Generator;
import de.datagenerator.generator.KundenGenerator;
import de.datagenerator.generator.ProduktGenerator;
import de.datagenerator.generator.WKorbGenerator;
import de.datagenerator.generator.WKorbProduktGenerator;

public class DBModule
   extends AbstractModule {

   @Override
   protected void configure() {
      bind(Generator.class).in(Singleton.class);
      bind(Creator.class).in(Singleton.class);
      bind(WKorbGenerator.class).in(Singleton.class);
      bind(KundenGenerator.class).in(Singleton.class);
      bind(ProduktGenerator.class).in(Singleton.class);
      bind(WKorbProduktGenerator.class).in(Singleton.class);
      bind(DBKundeWriter.class).in(Singleton.class);
      bind(DBProduktWriter.class).in(Singleton.class);
      bind(DBWKorbWriter.class).in(Singleton.class);
      bind(DBWKorbProduktWriter.class).in(Singleton.class);
   }
}
