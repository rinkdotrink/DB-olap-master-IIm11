package de.datagenerator.dbwriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import de.datagenerator.LogUtil;
import de.datagenerator.datamodel.Product;

public abstract class DBWriter implements IDBWriter {

   public abstract void write(Product aProduct);
   protected PreparedStatement preparedStmt = null;
   protected long commitDelayer = 100000;
   private Connection connection = null;
   private ResultSet resultSet = null;
   

   public void close() {
      try {
         getConnection().commit();
         closeResultSet();
         closeConnection();
      } catch (Exception e) {
         LogUtil.getLogger().error(e);
      }
   }

   protected final void initDBWriter()
      throws Exception {
      loadSQLDriver();
      setUpDBConnection();
      prepareStatement();
      getConnection().setAutoCommit(false);
      
      
   // Disable foreign keys check
      Statement stmt = getConnection().createStatement();
      stmt.execute("SET FOREIGN_KEY_CHECKS=0");
      stmt.execute("SET UNIQUE_CHECKS=0");
      stmt.execute("SET SQL_LOG_OFF=1");
      stmt.execute("SET innodb_table_locks=1");
      stmt.execute("SET SQL_NOTES=0");
      stmt.execute("SET SQL_LOG_BIN=0");
      stmt.execute("SET AUTOCOMMIT=0");
      
      //ResultSet res = stmt.executeQuery("SHOW GLOBAL VARIABLES LIKE '%size%';");
      //System.out.println(res.toString());
      //while(res.next()){
      //   System.out.println(res.getString(1) + " "+ res.getString(2)); 
      //   
      //}
      //System.out.println();
//      stmt.execute("SET  @@global.innodb_buffer_pool_size=512MB");
      
      
      
      stmt.close();
      
      
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
         DriverManager.getConnection("jdbc:mysql://localhost/adbc?"
            + "user=root&password=root");
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
