package de.datagenerator.dbwriter;

import java.sql.PreparedStatement;

import de.datagenerator.LogUtil;
import de.datagenerator.datamodel.FactoryMethodProduct;
import de.datagenerator.datamodel.Produkt;

public class DBProduktWriter
   extends DBWriter {

   private PreparedStatement preparedStatement = null;

   public DBProduktWriter() {
      try {
         initDBWriter();
      } catch (Exception e) {
         new LogUtil().getLogger().error(e);
      }
   }

   protected final void createPreparedStatement()
      throws Exception {
      preparedStatement =
         getConnection().prepareStatement("insert into  mydb.produkt(idProdukt, name, preis) values (?, ?, ?)");
   }

   public final void write(final FactoryMethodProduct aFactoryMethodProduct) {
      if (aFactoryMethodProduct instanceof Produkt) {
         writeKunde((Produkt) aFactoryMethodProduct);
      }
   }

   private void writeKunde(final Produkt aFactMethProd) {
      try {
         setId(aFactMethProd);
         setName(aFactMethProd);
         setPreis(aFactMethProd);
         preparedStatement.executeUpdate();
      } catch (Exception e) {
         new LogUtil().getLogger().warn(e);
      }
   }

   private void setId(final Produkt aFactMethProd)
      throws Exception {
      int idProduktIdx = 1;
      preparedStatement.setString(idProduktIdx, String.valueOf(aFactMethProd.getId()));
   }

   private void setName(final Produkt aFactMethProd)
      throws Exception {
      int nameIdx = 2; 
      preparedStatement.setString(nameIdx, aFactMethProd.getName());
   }

   private void setPreis(final Produkt aFactMethProd)
      throws Exception {
      int preisIdx = 3;
      preparedStatement.setString(preisIdx, String.valueOf(aFactMethProd.getPreis()));
   }
}
