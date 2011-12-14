package de.db;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

	public static void main(String[] args) {
		long anzKunde = 5;
		long anzProdukte = 5;
		long anzWarenkoerbe = 3;
		long anzProdukteInWarenkorb = 2;

		Injector injector = Guice.createInjector(new DBModule());
		DataGenerator dataGenerator = injector.getInstance(DataGenerator.class);
		dataGenerator.generate(anzKunde, anzProdukte, anzWarenkoerbe,
				anzProdukteInWarenkorb);
	}
}
