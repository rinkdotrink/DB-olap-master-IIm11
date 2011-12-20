package de.datagenerator;

import com.google.inject.AbstractModule;

import de.datagenerator.dbwriter.DBWriter;
import de.datagenerator.dbwriter.DBKundeWriter;
import de.datagenerator.generator.Context;

public class DBModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Context.class);
		bind(DBWriter.class).to(DBKundeWriter.class);
	}
}
