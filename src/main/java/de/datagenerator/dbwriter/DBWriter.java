package de.datagenerator.dbwriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import de.datagenerator.datamodel.FactoryMethodProduct;

public abstract class DBWriter {

	protected Connection connection = null;
	protected ResultSet resultSet = null;
	protected PreparedStatement preparedStatement = null;
	
	public abstract void write(FactoryMethodProduct factMethProd);

	protected void initDBWriter() throws Exception {
		loadSQLDriver();
		setUpDBConnection();
		createPreparedStatement();
	}
	
	protected abstract void createPreparedStatement() throws Exception;
	
	protected void loadSQLDriver() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
	}
	
	protected void setUpDBConnection() throws Exception{
		connection = DriverManager
				.getConnection("jdbc:mysql://localhost/feedback?"
						+ "user=root&password=12345");
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
