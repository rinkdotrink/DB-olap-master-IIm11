package de.datagenerator;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.datagenerator.generator.DataGeneratorStrategy;

public class Main {

	public static void main(String[] args) {
		long anzKunde = Long.valueOf(args[0]);
		long anzProdukte = Long.valueOf(args[1]);
		long anzWarenkoerbe = Long.valueOf(args[2]);
		long anzProdukteInWarenkorb = Long.valueOf(args[3]);

		Injector injector = Guice.createInjector(new DBModule());
		DataGeneratorStrategy dataGeneratorStrategy = injector
				.getInstance(DataGeneratorStrategy.class);
		dataGeneratorStrategy.generateTemplateMethod(anzKunde, anzProdukte,
				anzWarenkoerbe, anzProdukteInWarenkorb);
	}
}
