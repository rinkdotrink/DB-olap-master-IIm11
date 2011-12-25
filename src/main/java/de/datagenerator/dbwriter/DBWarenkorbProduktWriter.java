package de.datagenerator.dbwriter;

import de.datagenerator.LogUtil;
import de.datagenerator.datamodel.FactoryMethodProduct;
import de.datagenerator.datamodel.WarenkorbProdukt;

public class DBWarenkorbProduktWriter extends DBWriter {

	public DBWarenkorbProduktWriter() {
		try {
			initDBWriter();
		} catch (Exception e) {
			new LogUtil().getLogger().error(e);
		}
	}
	
	protected void createPreparedStatement() throws Exception {
		preparedStatement = connection
				.prepareStatement("insert into  mydb.warenkorbprodukt(idwarenkorbProdukt, produkt, bestellzeile) values (?, ?, ?)");
	}

	public void write(FactoryMethodProduct factoryMethodProduct) {
		if (factoryMethodProduct instanceof WarenkorbProdukt) {
			writeWarenkorb((WarenkorbProdukt) factoryMethodProduct);
		}
	}

	private void writeWarenkorb(WarenkorbProdukt factMethProd) {
		try {
			setId(factMethProd);
			setProduktKunde(factMethProd);
			setBestellzeile(factMethProd);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			new LogUtil().getLogger().error(e);
		}
	}

	private void setId(WarenkorbProdukt factMethProd) throws Exception {
		preparedStatement.setString(1, String.valueOf(factMethProd.getWarenkorbId()));
	}

	private void setProduktKunde(WarenkorbProdukt factMethProd) throws Exception {
		preparedStatement.setString(2, String.valueOf(factMethProd.getProduktId()));
	}
	
	private void setBestellzeile(WarenkorbProdukt factMethProd) throws Exception {
		preparedStatement.setString(3, String.valueOf(factMethProd.getBestellzeileId()));
	}
}
