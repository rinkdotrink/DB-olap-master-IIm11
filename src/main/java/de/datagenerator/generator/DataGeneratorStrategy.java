package de.datagenerator.generator;

import de.datagenerator.creator.Creator;
import de.datagenerator.datamodel.FactoryMethodProduct;
import de.datagenerator.dbwriter.DBWriter;

public abstract class DataGeneratorStrategy {

	protected Creator creator;
	protected FactoryMethodProduct factMethProd;
	protected DBWriter dbWriter;
	
	public void generateTemplateMethod(long anzKunden, long anzProdukte,
			long anzWarenkoerbeProKunde, long anzProdukteInWarenkorb) {
		generateKunden(anzKunden);
		generateProdukte(anzProdukte);
		generateWarenkorb(anzKunden, anzWarenkoerbeProKunde);
		generateProdukteInWarenkorb(anzKunden * anzWarenkoerbeProKunde
				* anzProdukteInWarenkorb, anzProdukteInWarenkorb);
	}
	
	protected void generateKunden(long anzahl){};

	protected void generateProdukte(long anzahl){};

	protected void generateWarenkorb(long anzahlKunde,
			long anzahlWarenkoerbeProKunde){};

	protected void generateProdukteInWarenkorb(
			long anzahlBestellzeilen, long anzahlProdukteInWarenkorb){};

}
