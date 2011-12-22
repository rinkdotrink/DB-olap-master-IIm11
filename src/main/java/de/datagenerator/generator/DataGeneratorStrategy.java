package de.datagenerator.generator;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.datagenerator.DBModule;
import de.datagenerator.creator.Creator;
import de.datagenerator.datamodel.FactoryMethodProduct;
import de.datagenerator.dbwriter.DBWriter;

public class DataGeneratorStrategy {

	protected Creator creator;
	protected FactoryMethodProduct factMethProd;
	protected DBWriter dbWriter;
	private DataGeneratorStrategy strategy;	
	private Injector injector = Guice.createInjector(new DBModule());
	
	public void generateTemplateMethod(long anzKunden, long anzProdukte,
			long anzWarenkoerbeProKunde, long anzProdukteInWarenkorb) {
		generateKunden(anzKunden);
		generateProdukte(anzProdukte);
		generateWarenkorb(anzKunden, anzWarenkoerbeProKunde);
		generateProdukteInWarenkorb(anzKunden * anzWarenkoerbeProKunde
				* anzProdukteInWarenkorb, anzProdukteInWarenkorb);
	}
	
	public void generateKunden(long anzahl){
		strategy = injector.getInstance(KundenGenerator.class);
		strategy.generateKunden(anzahl);
	};

	public void generateProdukte(long anzahl){
		strategy = injector.getInstance(ProduktGenerator.class);
		strategy.generateProdukte(anzahl);
	};

	public void generateWarenkorb(long anzahlKunde,
			long anzahlWarenkoerbeProKunde){
		strategy = injector.getInstance(WarenkorbGenerator.class);
		strategy.generateWarenkorb(anzahlKunde, anzahlWarenkoerbeProKunde);
	};

	public void generateProdukteInWarenkorb(
			long anzahlBestellzeilen, long anzahlProdukteInWarenkorb){
		strategy = injector.getInstance(WarenkorbProduktGenerator.class);
		strategy.generateProdukteInWarenkorb(anzahlBestellzeilen,
				anzahlProdukteInWarenkorb);
	};
}
