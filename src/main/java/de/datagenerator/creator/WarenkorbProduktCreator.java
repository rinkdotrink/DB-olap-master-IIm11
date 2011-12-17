package de.datagenerator.creator;

import de.datagenerator.datamodel.FactoryMethodProduct;
import de.datagenerator.datamodel.WarenkorbProdukt;

public class WarenkorbProduktCreator extends Creator {

	@Override
	public FactoryMethodProduct factMethWarenkorbProdukt(long bestellzeileId,
			long warenkorbId, long produktId) {
		return new WarenkorbProdukt(bestellzeileId, warenkorbId, produktId);
	}

}
