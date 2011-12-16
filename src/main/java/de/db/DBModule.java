package de.db;

import com.google.inject.AbstractModule;

public class DBModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Context.class);
		bind(DBWriter.class).to(DBWriterImpl.class);
	}
}
