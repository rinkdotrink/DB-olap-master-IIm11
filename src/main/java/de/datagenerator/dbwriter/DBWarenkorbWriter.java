package de.datagenerator.dbwriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import de.datagenerator.datamodel.FactoryMethodProduct;
import de.datagenerator.datamodel.Warenkorb;

public class DBWarenkorbWriter extends DBWriter {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public DBWarenkorbWriter() {
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
