package de.db;

import de.db.datamodel.FactoryMethodProduct;
import de.db.datamodel.WarenkorbProdukt;

public class WarenkorbProduktCreator extends Creator {

	@Override
	public FactoryMethodProduct factMethWarenkorbProdukt(long bestellzeileId,
			long warenkorbId, long produktId) {
		return new WarenkorbProdukt(bestellzeileId, warenkorbId, produktId);
	}

}
