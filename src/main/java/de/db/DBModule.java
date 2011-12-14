package de.db;

import com.google.inject.AbstractModule;

public class DBModule extends AbstractModule{

    @Override
    protected void configure() {
		bind(DataGenerator.class).to(DataGeneratorImpl.class);
		bind(DBWriter.class).to(DBWriterImpl.class);
    }
}
