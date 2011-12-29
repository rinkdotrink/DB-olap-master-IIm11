package de.datagenerator.dbwriter;

import java.sql.PreparedStatement;

import de.datagenerator.LogUtil;
import de.datagenerator.datamodel.Product;
import de.datagenerator.datamodel.Produkt;

public class DBProduktWriter
   extends DBWriter {

   private PreparedStatement prepStmt = null;

   public DBProduktWriter() {
      try {
         initDBWriter();
      } catch (Exception e) {
         new LogUtil().getLogger().error(e);
      }
   }

   protected final void prepareStatement()
      throws Exception {
      String stmt =
         "insert into  mydb.produkt(idProdukt, name, preis) values (?, ?, ?)";
      prepStmt = getConnection().prepareStatement(stmt);
   }

   public final void write(final Product aProduct) {
      if (aProduct instanceof Produkt) {
         writeKunde((Produkt) aProduct);
      }
   }

   private void writeKunde(final Produkt aProduct) {
      try {
         setId(aProduct);
         setName(aProduct);
         setPreis(aProduct);
         prepStmt.executeUpdate();
      } catch (Exception e) {
         new LogUtil().getLogger().warn(e);
      }
   }

   private void setId(final Produkt aProduct)
      throws Exception {
      final int idProduktIdx = 1;
      prepStmt.setString(idProduktIdx, String.valueOf(aProduct.getId()));
   }

   private void setName(final Produkt aProduct)
      throws Exception {
      final int nameIdx = 2;
      prepStmt.setString(nameIdx, aProduct.getName());
   }

   private void setPreis(final Produkt aProduct)
      throws Exception {
      final int preisIdx = 3;
      prepStmt.setString(preisIdx, String.valueOf(aProduct.getPreis()));
   }
}
