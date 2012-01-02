package de.datagenerator.dbwriter;

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

   public final void write(final Product aProduct) {
      if (aProduct instanceof WKorb) {
         writeWKorb((WKorb) aProduct);
      }
   }

   protected final void prepareStatement()
      throws Exception {
      String stmt =
         "insert into mydb.warenkorb(idWarenkorb, kunde) values (?, ?)";
      preparedStmt = getConnection().prepareStatement(stmt);
   }

   private void writeWKorb(final WKorb aWKorb) {
      try {
         setId(aWKorb.getId());
         setKundenId(aWKorb.getKundenId());
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
}
