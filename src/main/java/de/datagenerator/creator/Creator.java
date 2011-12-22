package de.datagenerator.creator;

import de.datagenerator.datamodel.FactoryMethodProduct;
import de.datagenerator.datamodel.Kunde;
import de.datagenerator.datamodel.Produkt;
import de.datagenerator.datamodel.Warenkorb;
import de.datagenerator.datamodel.WarenkorbProdukt;

public class Creator {

	public FactoryMethodProduct factMethKunde(long id, String name,
			long kundenNummer) {
		return new Kunde(id, name, kundenNummer);
	}

	public FactoryMethodProduct factMethProdukt(long id, String name,
			Integer preis) {
		return new Produkt(id, name, preis);
	}

	public FactoryMethodProduct factMethWarenkorb(long id, long kundenId) {
		return new Warenkorb(id, kundenId);
	}

	public FactoryMethodProduct factMethWarenkorbProdukt(long bestellzeileId,
			long warenkorbId, long produktId) {
		return new WarenkorbProdukt(bestellzeileId, warenkorbId, produktId);
	}

}
