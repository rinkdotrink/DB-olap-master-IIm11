package de.datagenerator.creator;

import de.datagenerator.datamodel.FactoryMethodProduct;
import de.datagenerator.datamodel.Kunde;

public class KundeCreator extends Creator {

	@Override
	public FactoryMethodProduct factMethKunde(long id, String name, long kundenNummer) {
		return new Kunde(id, name, kundenNummer);
	}

}
