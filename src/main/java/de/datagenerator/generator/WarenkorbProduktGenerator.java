package de.datagenerator.generator;

import com.google.inject.Inject;

import de.datagenerator.creator.Creator;
import de.datagenerator.creator.WarenkorbProduktCreator;
import de.datagenerator.dbwriter.DBWriter;

public class WarenkorbProduktGenerator extends DataGeneratorStrategy {

	private Creator creator;
	private long produktId = 0;
	private long modzaehler = 0;
	private long warenkorbId = 0;
	private long bestellZeilenId = 0;
	
	@Inject
	public WarenkorbProduktGenerator(DBWriter dbWriter) {
		this.dbWriter = dbWriter;
		creator = new WarenkorbProduktCreator();
	}

	@Override
	protected void generateProdukteInWarenkorb(long anzahlBestellzeilen,
			long anzahlProdukteInWarenkorb) {
		if (anzahlBestellzeilen == 1) {
			createWarenkorbProdukt();
		}
		for (long aktBestellzeile = 0; aktBestellzeile < anzahlBestellzeilen / 2; aktBestellzeile++) {
			createWarenkorbProdukt();
			createWarenkorbProdukt();
			warenkorbId++;
		}
	}

	private void createWarenkorbProdukt() {
		produktId = modzaehler % 5;
		factMethProd = creator.factMethWarenkorbProdukt(bestellZeilenId,
				warenkorbId, produktId);
		dbWriter.write(factMethProd);
		modzaehler++;
		bestellZeilenId++;
	}

}
