package de.datagenerator.creator;

import de.datagenerator.datamodel.FactoryMethodProduct;
import de.datagenerator.datamodel.Produkt;

public class ProduktCreator extends Creator {

	@Override
	public FactoryMethodProduct factMethProdukt(long id, String name, Integer preis) {
		return new Produkt(id, name, preis);
	}

}
