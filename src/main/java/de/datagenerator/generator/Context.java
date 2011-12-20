package de.datagenerator.generator;

import de.datagenerator.dbwriter.DBWriter;

public class Context extends DataGeneratorStrategy {

	DataGeneratorStrategy strategy;

	public void generate(long anzKunden, long anzProdukte,
			long anzWarenkoerbeProKunde, long anzProdukteInWarenkorb) {

		generateTemplateMethod(anzKunden, anzProdukte,
				anzWarenkoerbeProKunde, anzProdukteInWarenkorb);
	}

	protected void generateKunden(long anzahl) {
//		this.dbWriter = new DBKundeWriter();
		strategy = new KundenGenerator(dbWriter);
		strategy.generateKunden(anzahl);
	};

	protected void generateProdukte(long anzahl) {
//		this.dbWriter = new DBProduktWriter();
		strategy = new ProduktGenerator(dbWriter);
		strategy.generateProdukte(anzahl);
	};
	
	public void setDBWriter(DBWriter dbWriter){
		this.dbWriter = dbWriter;
	}

	protected void generateWarenkorb(long anzahlKunde,
			long anzahlWarenkoerbeProKunde) {
//		this.dbWriter = new DBWarenkorbWriter();
		strategy = new WarenkorbGenerator(dbWriter);
		strategy.generateWarenkorb(anzahlKunde, anzahlWarenkoerbeProKunde);
	};

	protected void generateProdukteInWarenkorb(long anzahlBestellzeilen,
			long anzahlProdukteInWarenkorb) {
//		this.dbWriter = new DBWarenkorbProduktWriter();
		strategy = new WarenkorbProduktGenerator(dbWriter);
		strategy.generateProdukteInWarenkorb(anzahlBestellzeilen,
				anzahlProdukteInWarenkorb);
	};

}
