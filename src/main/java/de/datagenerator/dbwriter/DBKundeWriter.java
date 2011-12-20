package de.datagenerator.dbwriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import de.datagenerator.datamodel.FactoryMethodProduct;
import de.datagenerator.datamodel.Kunde;

public class DBKundeWriter extends DBWriter {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public DBKundeWriter() {
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
