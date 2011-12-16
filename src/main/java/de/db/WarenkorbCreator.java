package de.db;

import de.db.datamodel.FactoryMethodProduct;
import de.db.datamodel.Warenkorb;

public class WarenkorbCreator extends Creator {

	@Override
	public FactoryMethodProduct factMethWarenkorb(long id, long kundenId) {
		return new Warenkorb(id, kundenId);
	}

}
