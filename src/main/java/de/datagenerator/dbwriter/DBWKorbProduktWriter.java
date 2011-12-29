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
         new LogUtil().getLogger().error(e);
      }
   }

   protected final void prepareStatement()
      throws Exception {
      String stmt =
         "insert into  mydb.warenkorbprodukt(idwarenkorbProdukt, produkt, bestellzeile) values (?, ?, ?)";
      setPreparedStmt(getConnection().prepareStatement(stmt));
   }

   public final void write(final Product aProduct) {
      if (aProduct instanceof WKorbProdukt) {
         writeWarenkorb((WKorbProdukt) aProduct);
      }
   }

   private void writeWarenkorb(final WKorbProdukt aProduct) {
      try {
         setId(aProduct);
         setProduktKunde(aProduct);
         setBestellzeile(aProduct);
         getPreparedStmt().executeUpdate();
      } catch (Exception e) {
         new LogUtil().getLogger().warn(e);
      }
   }

   private void setId(final WKorbProdukt aProduct)
      throws Exception {
      final int idWarenkorbProduktIdx = 1;
      getPreparedStmt().setString(idWarenkorbProduktIdx,
                                  String.valueOf(aProduct.getWKorbId()));
   }

   private void setProduktKunde(final WKorbProdukt aProduct)
      throws Exception {
      final int produktIdx = 2;
      getPreparedStmt().setString(produktIdx,
                                  String.valueOf(aProduct.getProduktId()));
   }

   private void setBestellzeile(final WKorbProdukt aProduct)
      throws Exception {
      final int bestellzeileIdx = 3;
      getPreparedStmt().setString(bestellzeileIdx,
                                  String.valueOf(aProduct.getBestellzeileId()));
   }
}
