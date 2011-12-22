package de.datagenerator.generator;

import com.google.inject.Inject;

import de.datagenerator.creator.Creator;
import de.datagenerator.dbwriter.DBWarenkorbProduktWriter;

public class WarenkorbProduktGenerator extends DataGeneratorStrategy {

	private long produktId = 0;
	private long modzaehler = 0;
	private long warenkorbId = 0;
	private long bestellZeilenId = 0;

	@Inject
	public WarenkorbProduktGenerator(Creator creator, DBWarenkorbProduktWriter dbWriter){
		this.creator = creator;
		this.dbWriter = dbWriter;
	}
	
	@Override
	public void generateProdukteInWarenkorb(long anzahlBestellzeilen,
			long anzahlProdukteInWarenkorb) {
		creator = new Creator();
		if (anzahlBestellzeilen == 1) {
			createWarenkorbProdukt();
		}
		for (long aktBestellzeile = 0; aktBestellzeile < anzahlBestellzeilen / 2; aktBestellzeile++) {
			createWarenkorbProdukt();
			createWarenkorbProdukt();
			warenkorbId++;
		}
		dbWriter.close();
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
