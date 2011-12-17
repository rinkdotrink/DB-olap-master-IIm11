package de.datagenerator.creator;

import de.datagenerator.datamodel.FactoryMethodProduct;
import de.datagenerator.datamodel.Warenkorb;

public class WarenkorbCreator extends Creator {

	@Override
	public FactoryMethodProduct factMethWarenkorb(long id, long kundenId) {
		return new Warenkorb(id, kundenId);
	}

}
