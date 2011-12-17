package de.datagenerator.generator;

import com.google.inject.Inject;

import de.datagenerator.creator.ProduktCreator;
import de.datagenerator.dbwriter.DBWriter;

public class ProduktGenerator extends DataGeneratorStrategy {
	
	@Inject
	public ProduktGenerator(DBWriter dbWriter){
		this.dbWriter = dbWriter;
	}
	
	@Override
	protected void generateProdukte(long anzahl) {
		long id;
		String name;
		Integer preis;
		creator = new ProduktCreator();
		for (long i = 0; i < anzahl; i++) {
			id = i;
			name = "Product" + id;
			preis = Integer.valueOf(1);
			factMethProd = creator.factMethProdukt(id, name, preis);
			dbWriter.write(factMethProd);
		}
	}

}
