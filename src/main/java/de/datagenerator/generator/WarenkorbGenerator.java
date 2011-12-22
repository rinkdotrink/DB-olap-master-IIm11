package de.datagenerator.generator;

import com.google.inject.Inject;

import de.datagenerator.creator.Creator;
import de.datagenerator.dbwriter.DBWarenkorbWriter;

public class WarenkorbGenerator extends DataGeneratorStrategy {

	@Inject
	public WarenkorbGenerator(Creator creator, DBWarenkorbWriter dbWriter){
		this.creator = creator;
		this.dbWriter = dbWriter;
	}
	
	@Override
	public void generateWarenkorb(long anzahlKunden,
			long anzahlWarenkoerbeProKunde) {
		long kundenId;
		long warenkorbId = 0;
		for (long iKunde = 0; iKunde < anzahlKunden; iKunde++) {
			kundenId = iKunde;
			for (long iWarenkorbProKunde = 0; iWarenkorbProKunde < anzahlWarenkoerbeProKunde; iWarenkorbProKunde++) {
				factMethProd = creator.factMethWarenkorb(warenkorbId, kundenId);
				dbWriter.write(factMethProd);
				warenkorbId++;
			}
		}
		dbWriter.close();
	}

}
