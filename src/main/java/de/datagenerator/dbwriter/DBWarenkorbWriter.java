package de.datagenerator.dbwriter;

import java.sql.PreparedStatement;

import de.datagenerator.LogUtil;
import de.datagenerator.datamodel.Product;
import de.datagenerator.datamodel.Warenkorb;

public class DBWarenkorbWriter
   extends DBWriter {

   private PreparedStatement preparedStmt = null;

   public DBWarenkorbWriter() {
      try {
         initDBWriter();
      } catch (Exception e) {
         new LogUtil().getLogger().error(e);
      }
   }

   protected final void prepareStatement()
      throws Exception {
      String stmt =
         "insert into mydb.warenkorb(idWarenkorb, kunde) values (?, ?)";
      preparedStmt = getConnection().prepareStatement(stmt);
   }

   public final void write(final Product aProduct) {
      if (aProduct instanceof Warenkorb) {
         writeWarenkorb((Warenkorb) aProduct);
      }
   }

   private void writeWarenkorb(final Warenkorb aProduct) {
      try {
         setId(aProduct);
         setKunde(aProduct);
         preparedStmt.executeUpdate();
      } catch (Exception e) {
         new LogUtil().getLogger().warn(e);
      }
   }

   private void setId(final Warenkorb aProduct)
      throws Exception {
      final int idWarenkorbIdx = 1;
      preparedStmt.setString(idWarenkorbIdx, String.valueOf(aProduct.getId()));
   }

   private void setKunde(final Warenkorb aProduct)
      throws Exception {
      final int kundeIdx = 2;
      preparedStmt.setString(kundeIdx, String.valueOf(aProduct.getKundenId()));
   }
}
