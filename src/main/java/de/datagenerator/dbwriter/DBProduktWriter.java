package de.datagenerator.dbwriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import de.datagenerator.datamodel.FactoryMethodProduct;
import de.datagenerator.datamodel.Produkt;

public class DBProduktWriter extends DBWriter {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public DBProduktWriter() {
		try {
			initDBWriter();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void initDBWriter() throws Exception {
		loadSQLDriver();
		setUpDBConnection();
		createPreparedStatement();
	}

	private void loadSQLDriver() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
	}
	
	private void setUpDBConnection() throws Exception{
		connection = DriverManager
				.getConnection("jdbc:mysql://localhost/feedback?"
						+ "user=root&password=12345");
	}
	
	private void createPreparedStatement() throws Exception {
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
			System.out.println(e);
		}
	}

	private void setId(Produkt factMethProd) throws Exception {
		preparedStatement.setString(1, String.valueOf(factMethProd.getId()));
	}

	private void setName(Produkt factMethProd) throws Exception {
		preparedStatement.setString(2, factMethProd.getName());
	}

	private void setPreis(Produkt factMethProd) throws Exception {
		preparedStatement.setString(3,
				String.valueOf(factMethProd.getPreis()));
	}

	public void close() {
		try {
			closeResultSet();
			closeConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void closeResultSet() throws Exception {
		if (resultSet != null) {
			resultSet.close();
		}
	}

	private void closeConnection() throws Exception {
		if (connection != null) {
			connection.close();
		}
	}

}
