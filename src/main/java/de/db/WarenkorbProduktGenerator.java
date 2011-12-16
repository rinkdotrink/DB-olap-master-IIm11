package de.db;

import com.google.inject.Inject;

import de.db.datamodel.WarenkorbProdukt;

public class WarenkorbProduktGenerator extends DataGeneratorStrategy{
	
	@Inject
	public WarenkorbProduktGenerator(DBWriter dbWriter){
		this.dbWriter = dbWriter;
	}
	
	@Override
	protected void generateProdukteInWarenkorb(long anzahlBestellzeilen,
			long anzahlProdukteInWarenkorb) {

		long produktId = 0;
		long modzaehler = 0;
		long warenkorbId = 0;
		long bestellZeilenId = 0;
		creator = new WarenkorbProduktCreator();
		if (anzahlBestellzeilen == 1) {
			createWarenkorbProdukt(produktId, modzaehler, warenkorbId,
					bestellZeilenId);
		}
		for (long aktBestellzeile = 0; aktBestellzeile < anzahlBestellzeilen / 2; aktBestellzeile++) {
			produktId = modzaehler % 5;
			factMethProd = creator.factMethWarenkorbProdukt(bestellZeilenId,
					warenkorbId, produktId);
			dbWriter.write(factMethProd);
			modzaehler++;
			bestellZeilenId++;
			produktId = modzaehler % 5;
			factMethProd = new WarenkorbProdukt(bestellZeilenId, warenkorbId,
					produktId);
			dbWriter.write(factMethProd);
			modzaehler++;
			warenkorbId++;
			bestellZeilenId++;
		}
	}

	private void createWarenkorbProdukt(long produktId, long modzaehler,
			long warenkorbId, long bestellZeilenId) {

		creator = new WarenkorbProduktCreator();
		produktId = modzaehler % 5;
		factMethProd = creator.factMethWarenkorbProdukt(bestellZeilenId,
				warenkorbId, produktId);
		dbWriter.write(factMethProd);
		modzaehler++;
		bestellZeilenId++;
	}


}
