package de.datagenerator.dbwriter;


import java.sql.SQLException;
import java.text.SimpleDateFormat;


import de.datagenerator.LogUtil;
import de.datagenerator.datamodel.Product;
import de.datagenerator.datamodel.WKorb;

public class DBWKorbWriter
   extends DBWriter {

   public DBWKorbWriter() {
      try {
         initDBWriter();
      } catch (Exception e) {
         LogUtil.getLogger().error(e);
      }
   }

   public void write(final Product aProduct) {
      if (aProduct instanceof WKorb) {
         writeWKorb((WKorb) aProduct);
      }
   }

   protected final void prepareStatement()
      throws Exception {
      String stmt =
      // "insert into mydb.warenkorb(idWarenkorb, kunde) values (?, ?)";
         "insert into adbc.warenkorb(WARENKORB_ID, Kunde_KUNDE_ID, Datum) values (?, ?, ?)";
      preparedStmt = getConnection().prepareStatement(stmt);
   }

   private void writeWKorb(final WKorb aWKorb) {
      try {
         setId(aWKorb.getId());
         setKundenId(aWKorb.getKundenId());
         setDatum(aWKorb.getDatum());
         preparedStmt.executeUpdate();
      } catch (Exception e) {
         LogUtil.getLogger().warn(e);
      }
   }

   private void setId(final long aId)
      throws Exception {
      final int idWarenkorbIdx = 1;
      preparedStmt.setString(idWarenkorbIdx, String.valueOf(aId));
   }

   private void setKundenId(final long aKundenId)
      throws Exception {
      final int kundeIdx = 2;
      preparedStmt.setString(kundeIdx, String.valueOf(aKundenId));
   }

   private void setDatum(final java.util.Date aSQLUtilDatum)
      throws SQLException {
      {
         final int datumIdx = 3;
         java.sql.Date sqlDate = getSQLDate(aSQLUtilDatum);
         preparedStmt.setDate(datumIdx, sqlDate);
      }
   }
   
   private java.sql.Date getSQLDate(java.util.Date aSQLUtilDatum){
      SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
      String aSQLUtilStr = fmt.format(aSQLUtilDatum);
      java.sql.Date sqlDate = java.sql.Date.valueOf(new String(aSQLUtilStr));
      return sqlDate;
   }
}
