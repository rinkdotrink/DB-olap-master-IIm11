package de.db;

public interface DBWriter {

	public void write(Kunde kunde);

	public void write(Produkt produkt);

	public void write(Warenkorb warenkorb);

	public void write(WarenkorbProdukt warenkorbProdukt);

}
