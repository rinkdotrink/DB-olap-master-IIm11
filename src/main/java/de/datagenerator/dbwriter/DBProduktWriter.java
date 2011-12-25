package de.datagenerator.dbwriter;

import java.sql.PreparedStatement;

import de.datagenerator.LogUtil;
import de.datagenerator.datamodel.FactoryMethodProduct;
import de.datagenerator.datamodel.Produkt;

public class DBProduktWriter extends DBWriter {

	private PreparedStatement preparedStatement = null;

	public DBProduktWriter() {
		try {
			initDBWriter();
		} catch (Exception e) {
			new LogUtil().getLogger().error(e);
		}
	}

	protected void createPreparedStatement() throws Exception {
		preparedStatement = connection
				.prepareStatement("insert into  mydb.produkt(idProdukt, name, preis) values (?, ?, ?)");
	}

	public void write(FactoryMethodProduct factoryMethodProduct) {
		if (factoryMethodProduct instanceof Produkt) {
			writeKunde((Produkt) factoryMethodProduct);
		}
	}

	private void writeKunde(Produkt factMethProd) {
		try {
			setId(factMethProd);
			setName(factMethProd);
			setPreis(factMethProd);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			new LogUtil().getLogger().error(e);
		}
	}

	private void setId(Produkt factMethProd) throws Exception {
		preparedStatement.setString(1, String.valueOf(factMethProd.getId()));
	}

	private void setName(Produkt factMethProd) throws Exception {
		preparedStatement.setString(2, factMethProd.getName());
	}

	private void setPreis(Produkt factMethProd) throws Exception {
		preparedStatement.setString(3, String.valueOf(factMethProd.getPreis()));
	}
}
