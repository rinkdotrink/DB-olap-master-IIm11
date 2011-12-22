package de.datagenerator.generator;

import com.google.inject.Inject;

import de.datagenerator.creator.Creator;
import de.datagenerator.dbwriter.DBKundeWriter;

public class KundenGenerator extends DataGeneratorStrategy {	
	
	@Inject
	public KundenGenerator(Creator creator, DBKundeWriter dbWriter){
		this.creator = creator;
		this.dbWriter = dbWriter;
	}
	
	@Override
	public void generateKunden(long anzahl) {
		long id;
		String name;
		long kundenNummer;
		for (long i = 0; i < anzahl; i++) {
			id = i;
			name = "Customer" + id;
			kundenNummer = i;
			factMethProd = creator.factMethKunde(id, name, kundenNummer);
			dbWriter.write(factMethProd);
		}
		dbWriter.close();
	}	
	
}
