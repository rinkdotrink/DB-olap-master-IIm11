package de.db;

import de.db.datamodel.FactoryMethodProduct;
import de.db.datamodel.Produkt;

public class ProduktCreator extends Creator {

	@Override
	public FactoryMethodProduct factMethProdukt(long id, String name, Integer preis) {
		return new Produkt(id, name, preis);
	}

}
