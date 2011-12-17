package de.datagenerator.creator;

import de.datagenerator.datamodel.FactoryMethodProduct;

public abstract class Creator {

	public FactoryMethodProduct factMethKunde(long id, String name,
			long kundenNummer) {
		return null;
	}

	public FactoryMethodProduct factMethProdukt(long id, String name,
			Integer preis) {
		return null;
	}

	public FactoryMethodProduct factMethWarenkorb(long id, long kundenId) {
		return null;
	}

	public FactoryMethodProduct factMethWarenkorbProdukt(long bestellzeileId,
			long warenkorbId, long produktId) {
		return null;
	}

}
