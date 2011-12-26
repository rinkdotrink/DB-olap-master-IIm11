package de.datagenerator.dbwriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import de.datagenerator.LogUtil;
import de.datagenerator.datamodel.FactoryMethodProduct;

public abstract class DBWriter {

   private Connection connection = null;

   private ResultSet resultSet = null;

   private PreparedStatement preparedStatement = null;

   public abstract void write(FactoryMethodProduct aFactMethProd);

   protected final void initDBWriter()
      throws Exception {
      loadSQLDriver();
      setUpDBConnection();
      createPreparedStatement();
   }

   protected abstract void createPreparedStatement()
      throws Exception;

   protected final void loadSQLDriver()
      throws Exception {
      Class.forName("com.mysql.jdbc.Driver");
   }

   protected final void setUpDBConnection()
      throws Exception {
      connection =
         DriverManager.getConnection("jdbc:mysql://localhost/feedback?"
            + "user=root&password=12345");
   }

   public final void close() {
      try {
         closeResultSet();
         closeConnection();
      } catch (Exception e) {
         new LogUtil().getLogger().error(e);
      }
   }

   private void closeResultSet()
      throws Exception {
      if (resultSet != null) {
         resultSet.close();
      }
   }

   private void closeConnection()
      throws Exception {
      if (connection != null) {
         connection.close();
      }
   }

   protected final Connection getConnection() {
      return connection;
   }

   protected final PreparedStatement getPreparedStatement() {
      return preparedStatement;
   }

   protected final void setPreparedStatement(final PreparedStatement aPreparedStatement) {
      this.preparedStatement = aPreparedStatement;
   }

}
