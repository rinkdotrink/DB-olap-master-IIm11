package de.db;

import com.google.inject.Inject;

public class KundenGenerator extends DataGeneratorStrategy {	
	
	@Inject
	public KundenGenerator(DBWriter dbWriter){
		this.dbWriter = dbWriter;
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
	}
}
