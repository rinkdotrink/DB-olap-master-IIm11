package de.db;

import com.google.inject.Inject;

public class WarenkorbGenerator extends DataGeneratorStrategy {

	@Inject
	public WarenkorbGenerator(DBWriter dbWriter){
		this.dbWriter = dbWriter;
	}
	
	@Override
	protected void generateWarenkorb(long anzahlKunden,
			long anzahlWarenkoerbeProKunde) {
		long kundenId;
		long warenkorbId = 0;
		creator = new WarenkorbCreator();
		for (long iKunde = 0; iKunde < anzahlKunden; iKunde++) {
			kundenId = iKunde;
			for (long iWarenkorbProKunde = 0; iWarenkorbProKunde < anzahlWarenkoerbeProKunde; iWarenkorbProKunde++) {
				factMethProd = creator.factMethWarenkorb(warenkorbId, kundenId);
				dbWriter.write(factMethProd);
				warenkorbId++;
			}
		}
	}

}
