package de.datagenerator.dbwriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import de.datagenerator.LogUtil;
import de.datagenerator.datamodel.Product;

public abstract class DBWriter {

   public abstract void write(Product aProduct);

   protected PreparedStatement preparedStmt = null;

   private Connection connection = null;

   private ResultSet resultSet = null;

   public void close() {
      try {
         closeResultSet();
         closeConnection();
      } catch (Exception e) {
         LogUtil.getLogger().error(e);
      }
   }

   public final void initDBWriter()
      throws Exception {
      loadSQLDriver();
      setUpDBConnection();
      prepareStatement();
   }

   protected abstract void prepareStatement()
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

   protected final Connection getConnection() {
      return connection;
   }

   protected final PreparedStatement getPreparedStmt() {
      return preparedStmt;
   }

   protected final void setPreparedStmt(final PreparedStatement aPreparedStmt) {
      this.preparedStmt = aPreparedStmt;
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

}
