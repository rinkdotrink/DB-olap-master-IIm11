package de.datagenerator.dbwriter;

import de.datagenerator.datamodel.FactoryMethodProduct;
import de.datagenerator.datamodel.Kunde;

public class DBKundeWriter extends DBWriter {

	public DBKundeWriter() {
		try {
			initDBWriter();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected void createPreparedStatement() throws Exception {
		preparedStatement = connection
				.prepareStatement("insert into  mydb.kunde(idKunde, name, kundenNummer) values (?, ?, ?)");
	}

	public void write(FactoryMethodProduct factoryMethodProduct) {
		if (factoryMethodProduct instanceof Kunde) {
			writeKunde((Kunde) factoryMethodProduct);
		}
	}

	private void writeKunde(Kunde factMethProd) {
		try {
			setId(factMethProd);
			setName(factMethProd);
			setKundenNummer(factMethProd);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void setId(Kunde factMethProd) throws Exception {
		preparedStatement.setString(1, String.valueOf(factMethProd.getId()));
	}

	private void setName(Kunde factMethProd) throws Exception {
		preparedStatement.setString(2, factMethProd.getName());
	}

	private void setKundenNummer(Kunde factMethProd) throws Exception {
		preparedStatement.setString(3,
				String.valueOf(factMethProd.getKundenNummer()));
	}

}
