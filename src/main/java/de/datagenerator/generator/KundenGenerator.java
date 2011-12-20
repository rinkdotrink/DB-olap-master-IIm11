package de.datagenerator.generator;

import com.google.inject.Inject;

import de.datagenerator.creator.KundeCreator;
import de.datagenerator.dbwriter.DBKundeWriter;
import de.datagenerator.dbwriter.DBWriter;

public class KundenGenerator extends DataGeneratorStrategy {	
	
	@Inject
	public KundenGenerator(DBWriter dbWriter){
		this.dbWriter = new DBKundeWriter();
	}

	@Override
	protected void generateKunden(long anzahl) {
		long id;
		String name;
		long kundenNummer;
		creator = new KundeCreator();
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
