package de.db;

import com.google.inject.Inject;

import de.db.datamodel.Kunde;
import de.db.datamodel.Produkt;
import de.db.datamodel.Warenkorb;
import de.db.datamodel.WarenkorbProdukt;

public class DataGeneratorImpl extends DataGenerator {

	private DBWriter dbWriter;

	@Inject
	public DataGeneratorImpl(DBWriter dbWriter) {
		this.dbWriter = dbWriter;
	}

	@Override
	protected void generateKunden(long anzahl) {
		long id;
		String name;
		long kundenNummer;
		Kunde kunde;
		for (long i = 0; i < anzahl; i++) {
			id = i;
			name = new String("Customer" + id);
			kundenNummer = i;
			kunde = new Kunde(id, name, kundenNummer);
			dbWriter.write(kunde);
		}
	}

	@Override
	protected void generateProdukte(long anzahl) {
		long id;
		String name;
		Integer preis;
		Produkt produkt;
		for (long i = 0; i < anzahl; i++) {
			id = i;
			name = new String("Product" + id);
			preis = new Integer(1);
			produkt = new Produkt(id, name, preis);
			dbWriter.write(produkt);
		}
	}

	@Override
	protected void generateWarenkorb(long anzahlKunden,
			long anzahlWarenkoerbeProKunde) {
		long kundenId;
		long warenkorbId = 0;
		Warenkorb warenkorb;
		for (long iKunde = 0; iKunde < anzahlKunden; iKunde++) {
			kundenId = iKunde;
			for (long iWarenkorbProKunde = 0; iWarenkorbProKunde < anzahlWarenkoerbeProKunde; iWarenkorbProKunde++) {
				warenkorb = new Warenkorb(warenkorbId, kundenId);
				dbWriter.write(warenkorb);
				warenkorbId++;
			}
		}

	}

	@Override
	protected void generateProdukteInWarenkorb(long anzahlBestellzeilen,
			long anzahlProdukteInWarenkorb) {

		long produktId;
		long modzaehler = 0;
		long warenkorbId = 0;
		long bestellZeilenId = 0;
		WarenkorbProdukt warenkorbProdukt;
		for (long aktBestellzeile = 0; aktBestellzeile < anzahlBestellzeilen / 2; aktBestellzeile++) {
			produktId = modzaehler % 5;
			warenkorbProdukt = new WarenkorbProdukt(bestellZeilenId,
					warenkorbId, produktId);
			dbWriter.write(warenkorbProdukt);
			modzaehler++;
			bestellZeilenId++;

			produktId = modzaehler % 5;
			warenkorbProdukt = new WarenkorbProdukt(bestellZeilenId,
					warenkorbId, produktId);
			dbWriter.write(warenkorbProdukt);
			modzaehler++;
			warenkorbId++;
			bestellZeilenId++;
		}
	}

}
