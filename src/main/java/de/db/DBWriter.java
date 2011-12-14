package de.db;

import de.db.datamodel.Kunde;
import de.db.datamodel.Produkt;
import de.db.datamodel.Warenkorb;
import de.db.datamodel.WarenkorbProdukt;

public interface DBWriter {

	public void write(Kunde kunde);

	public void write(Produkt produkt);

	public void write(Warenkorb warenkorb);

	public void write(WarenkorbProdukt warenkorbProdukt);

}
