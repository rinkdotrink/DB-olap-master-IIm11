package de.db;

public abstract class DataGenerator {

	protected abstract void generateKunden(long anzahl);

	protected abstract void generateProdukte(long anzahl);

	protected abstract void generateWarenkorb(long anzahlKunde,
			long anzahlWarenkoerbeProKunde);

	protected abstract void generateProdukteInWarenkorb(
			long anzahlBestellzeilen, long anzahlProdukteInWarenkorb);

	public void generate(long anzKunden, long anzProdukte,
			long anzWarenkoerbeProKunde, long anzProdukteInWarenkorb) {
		generateKunden(anzKunden);
		generateProdukte(anzProdukte);
		generateWarenkorb(anzKunden, anzWarenkoerbeProKunde);
		generateProdukteInWarenkorb(anzKunden * anzWarenkoerbeProKunde
				* anzProdukteInWarenkorb, anzProdukteInWarenkorb);
	}
}
