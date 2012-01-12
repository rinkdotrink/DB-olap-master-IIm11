package de.datagenerator;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import de.datagenerator.creator.Creator;
import de.datagenerator.dbwriter.DBKundeWriter;
import de.datagenerator.dbwriter.DBProduktWriter;
import de.datagenerator.dbwriter.DBWKorbProduktWriter;
import de.datagenerator.dbwriter.DBWKorbWriter;
import de.datagenerator.dbwriter.IDBWriter;
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
      bind(IDBWriter.class).annotatedWith(Names.named("Kunde")).to(DBKundeWriter.class);
      bind(IDBWriter.class).annotatedWith(Names.named("Produkt")).to(DBProduktWriter.class);
      bind(IDBWriter.class).annotatedWith(Names.named("WKorb")).to(DBWKorbWriter.class);
      bind(IDBWriter.class).annotatedWith(Names.named("WKorbProdukt")).to(DBWKorbProduktWriter.class);
   }
}
