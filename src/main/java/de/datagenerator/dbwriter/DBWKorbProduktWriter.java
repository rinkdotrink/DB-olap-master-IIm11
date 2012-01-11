package de.datagenerator.dbwriter;

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
         "insert into  mydb.warenkorbprodukt(idwarenkorbProdukt, produkt, bestellzeile) values (?, ?, ?)";
      setPreparedStmt(getConnection().prepareStatement(stmt));
   }

   private void writeWKorbProdukt(final WKorbProdukt aWKorbProdukt) {
      try {
         setId(aWKorbProdukt.getWKorbProduktId());
         setProduktId(aWKorbProdukt.getProduktId());
         setBestellzeileId(aWKorbProdukt.getBestellzeileId());
         getPreparedStmt().executeUpdate();
      } catch (Exception e) {
         LogUtil.getLogger().warn(e);
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
}
