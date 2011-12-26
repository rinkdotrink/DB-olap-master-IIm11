package de.datagenerator.dbwriter;

import java.sql.PreparedStatement;

import de.datagenerator.LogUtil;
import de.datagenerator.datamodel.FactoryMethodProduct;
import de.datagenerator.datamodel.Warenkorb;

public class DBWarenkorbWriter
   extends DBWriter {

   private PreparedStatement preparedStatement = null;

   public DBWarenkorbWriter() {
      try {
         initDBWriter();
      } catch (Exception e) {
         new LogUtil().getLogger().error(e);
      }
   }

   protected final void createPreparedStatement()
      throws Exception {
      preparedStatement =
         getConnection().prepareStatement("insert into mydb.warenkorb(idWarenkorb, kunde) values (?, ?)");
   }

   public final void write(final FactoryMethodProduct aFactoryMethodProduct) {
      if (aFactoryMethodProduct instanceof Warenkorb) {
         writeWarenkorb((Warenkorb) aFactoryMethodProduct);
      }
   }

   private void writeWarenkorb(final Warenkorb aFactMethProd) {
      try {
         setId(aFactMethProd);
         setKunde(aFactMethProd);
         preparedStatement.executeUpdate();
      } catch (Exception e) {
         new LogUtil().getLogger().error(e);
      }
   }

   private void setId(final Warenkorb aFactMethProd)
      throws Exception {
      int idWarenkorbIdx = 1;
      preparedStatement.setString(idWarenkorbIdx, String.valueOf(aFactMethProd.getId()));
   }

   private void setKunde(final Warenkorb aFactMethProd)
      throws Exception {
      int kundeIdx = 2;
      preparedStatement.setString(kundeIdx,
                                  String.valueOf(aFactMethProd.getKundenId()));
   }
}
