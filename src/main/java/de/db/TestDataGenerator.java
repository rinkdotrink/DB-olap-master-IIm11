package de.db;

public abstract class TestDataGenerator {

	protected abstract void generateKunden(int anzahl);

	protected abstract void generateProdukte(int anzahl);

	protected abstract void generateWarenkorb(int anzahl);

	protected abstract void generateProdukteInWarenkorb(int anzahl);

	public void generate(int anzKunde, int anzProdukte, int anzWarenkoerbe,
			int anzProdukteInWarenkorb) {
		generateKunden(anzKunde);
		generateProdukte(anzProdukte);
		generateWarenkorb(anzWarenkoerbe);
		generateProdukteInWarenkorb(anzProdukteInWarenkorb);
	}
}
