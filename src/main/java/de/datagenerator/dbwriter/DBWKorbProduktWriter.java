package de.datagenerator.dbwriter;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import de.datagenerator.LogUtil;
import de.datagenerator.datamodel.Product;
import de.datagenerator.datamodel.WKorbProdukt;

public class DBWKorbProduktWriter
   extends DBWriter {

   public DBWKorbProduktWriter() {
      try {
         initDBWriter();
      } catch (Exception e) {
         LogUtil.getLogger().error(e);
      }
   }

   public void write(final Product aProduct) {
      if (aProduct instanceof WKorbProdukt) {
         writeWKorbProdukt((WKorbProdukt) aProduct);
      }
   }

   protected final void prepareStatement()
      throws Exception {
      String stmt =
         "insert into  adbc.warenkorb_has_produkt(Warenkorb_WARENKORB_ID, Produkt_PRODUKT_ID, WARENKORB_HAS_PRODUKT_ID, Datum) values (?, ?, ?, ?)";
      setPreparedStmt(getConnection().prepareStatement(stmt));
   }

   private void writeWKorbProdukt(final WKorbProdukt aWKorbProdukt) {
      try {
         setId(aWKorbProdukt.getWKorbProduktId());
         setProduktId(aWKorbProdukt.getProduktId());
         setBestellzeileId(aWKorbProdukt.getBestellzeileId());
         setDatum(aWKorbProdukt.getDatum());
         getPreparedStmt().executeUpdate();         
      } catch (Exception e) {
         LogUtil.getLogger().error(e);
      }
   }

   private void setId(final long aId)
      throws Exception {
      final int idWarenkorbProduktIdx = 1;
      getPreparedStmt().setString(idWarenkorbProduktIdx, String.valueOf(aId));
   }

   private void setProduktId(final long aProduktId)
      throws Exception {
      final int produktIdx = 2;
      getPreparedStmt().setString(produktIdx, String.valueOf(aProduktId));
   }

   private void setBestellzeileId(final long aBestellzeileId)
      throws Exception {
      final int bestellzeileIdx = 3;
      getPreparedStmt().setString(bestellzeileIdx,
                                  String.valueOf(aBestellzeileId));
   }

   private void setDatum(final java.util.Date aSQLUtilDatum)
      throws SQLException {
      {
         final int datumIdx = 4;
         java.sql.Date sqlDate = getSQLDate(aSQLUtilDatum);
         preparedStmt.setDate(datumIdx, sqlDate);
      }
   }

   private java.sql.Date getSQLDate(java.util.Date aSQLUtilDatum) {
      SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
      String aSQLUtilStr = fmt.format(aSQLUtilDatum);
      java.sql.Date sqlDate = java.sql.Date.valueOf(new String(aSQLUtilStr));
      return sqlDate;
   }

}
