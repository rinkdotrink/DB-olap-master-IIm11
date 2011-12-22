package de.datagenerator.generator;

import com.google.inject.Inject;

import de.datagenerator.creator.Creator;
import de.datagenerator.dbwriter.DBProduktWriter;

public class ProduktGenerator extends DataGeneratorStrategy {

	@Inject
	public ProduktGenerator(Creator creator, DBProduktWriter dbWriter){
		this.creator = creator;
		this.dbWriter = dbWriter;
	}
	
	@Override
	public void generateProdukte(long anzahl) {
		long id;
		String name;
		Integer preis;
		for (long i = 0; i < anzahl; i++) {
			id = i;
			name = "Product" + id;
			preis = Integer.valueOf(1);
			factMethProd = creator.factMethProdukt(id, name, preis);
			dbWriter.write(factMethProd);
		}
		dbWriter.close();
	}
	
}
