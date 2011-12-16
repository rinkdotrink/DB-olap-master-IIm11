package de.db;

import de.db.datamodel.FactoryMethodProduct;
import de.db.datamodel.Kunde;

public class KundeCreator extends Creator {

	@Override
	public FactoryMethodProduct factMethKunde(long id, String name, long kundenNummer) {
		return new Kunde(id, name, kundenNummer);
	}

}
