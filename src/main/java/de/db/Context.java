package de.db;

import com.google.inject.Inject;

public class Context extends DataGeneratorStrategy {

	DataGeneratorStrategy strategy;
	DBWriter dbWriter;

	@Inject
	public Context(DBWriter dbWriter) {
		this.dbWriter = dbWriter;
	}

	public void generate(long anzKunden, long anzProdukte,
			long anzWarenkoerbeProKunde, long anzProdukteInWarenkorb) {

		generateTemplateMethod(anzKunden, anzProdukte,
				anzWarenkoerbeProKunde, anzProdukteInWarenkorb);
	}

	protected void generateKunden(long anzahl) {
		strategy = new KundenGenerator(dbWriter);
		strategy.generateKunden(anzahl);
	};

	protected void generateProdukte(long anzahl) {
		strategy = new ProduktGenerator(dbWriter);
		strategy.generateProdukte(anzahl);
	};

	protected void generateWarenkorb(long anzahlKunde,
			long anzahlWarenkoerbeProKunde) {
		strategy = new WarenkorbGenerator(dbWriter);
		strategy.generateWarenkorb(anzahlKunde, anzahlWarenkoerbeProKunde);
	};

	protected void generateProdukteInWarenkorb(long anzahlBestellzeilen,
			long anzahlProdukteInWarenkorb) {
		strategy = new WarenkorbProduktGenerator(dbWriter);
		strategy.generateProdukteInWarenkorb(anzahlBestellzeilen,
				anzahlProdukteInWarenkorb);
	};

}
