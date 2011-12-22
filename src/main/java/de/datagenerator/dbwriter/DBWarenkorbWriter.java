package de.datagenerator.dbwriter;

import java.sql.PreparedStatement;

import de.datagenerator.datamodel.FactoryMethodProduct;
import de.datagenerator.datamodel.Warenkorb;

public class DBWarenkorbWriter extends DBWriter {

	private PreparedStatement preparedStatement = null;

	public DBWarenkorbWriter() {
		try {
			initDBWriter();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	protected void createPreparedStatement() throws Exception {
		preparedStatement = connection
				.prepareStatement("insert into mydb.warenkorb(idWarenkorb, kunde) values (?, ?)");
	}

	public void write(FactoryMethodProduct factoryMethodProduct) {
		if (factoryMethodProduct instanceof Warenkorb) {
			writeWarenkorb((Warenkorb) factoryMethodProduct);
		}
	}

	private void writeWarenkorb(Warenkorb factMethProd) {
		try {
			setId(factMethProd);
			setKunde(factMethProd);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void setId(Warenkorb factMethProd) throws Exception {
		preparedStatement.setString(1, String.valueOf(factMethProd.getId()));
	}

	private void setKunde(Warenkorb factMethProd) throws Exception {
		preparedStatement.setString(2, String.valueOf(factMethProd.getKundenId()));
	}
}
