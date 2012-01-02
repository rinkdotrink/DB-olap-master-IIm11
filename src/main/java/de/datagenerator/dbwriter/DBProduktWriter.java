package de.datagenerator.dbwriter;

import de.datagenerator.LogUtil;
import de.datagenerator.datamodel.Product;
import de.datagenerator.datamodel.Produkt;

public class DBProduktWriter
   extends DBWriter {

   public DBProduktWriter() {
      try {
         initDBWriter();
      } catch (Exception e) {
         LogUtil.getLogger().error(e);
      }
   }

   public final void write(final Product aProduct) {
      if (aProduct instanceof Produkt) {
         writeProdukt((Produkt) aProduct);
      }
   }

   protected final void prepareStatement()
      throws Exception {
      String stmt =
         "insert into  mydb.produkt(idProdukt, name, preis) values (?, ?, ?)";
      preparedStmt = getConnection().prepareStatement(stmt);
   }

   private void writeProdukt(final Produkt aProduct) {
      try {
         setId(aProduct.getId());
         setName(aProduct.getName());
         setPreis(aProduct.getPreisInCent());
         preparedStmt.executeUpdate();
      } catch (Exception e) {
         LogUtil.getLogger().warn(e);
      }
   }

   private void setId(final long aId)
      throws Exception {
      final int idProduktIdx = 1;
      preparedStmt.setString(idProduktIdx, String.valueOf(aId));
   }

   private void setName(final String aName)
      throws Exception {
      final int nameIdx = 2;
      preparedStmt.setString(nameIdx, aName);
   }

   private void setPreis(final int aPreisInCent)
      throws Exception {
      final int preisIdx = 3;
      preparedStmt.setString(preisIdx, String.valueOf(aPreisInCent));
   }
}
