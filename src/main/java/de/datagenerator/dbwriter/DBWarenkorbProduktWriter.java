package de.datagenerator.dbwriter;

import de.datagenerator.LogUtil;
import de.datagenerator.datamodel.FactoryMethodProduct;
import de.datagenerator.datamodel.WarenkorbProdukt;

public class DBWarenkorbProduktWriter
   extends DBWriter {

   public DBWarenkorbProduktWriter() {
      try {
         initDBWriter();
      } catch (Exception e) {
         new LogUtil().getLogger().error(e);
      }
   }

   protected final void createPreparedStatement()
      throws Exception {
      setPreparedStatement(getConnection().prepareStatement("insert into  mydb.warenkorbprodukt(idwarenkorbProdukt, produkt, bestellzeile) values (?, ?, ?)"));
   }

   public final void write(final FactoryMethodProduct aFactoryMethodProduct) {
      if (aFactoryMethodProduct instanceof WarenkorbProdukt) {
         writeWarenkorb((WarenkorbProdukt) aFactoryMethodProduct);
      }
   }

   private void writeWarenkorb(final WarenkorbProdukt aFactMethProd) {
      try {
         setId(aFactMethProd);
         setProduktKunde(aFactMethProd);
         setBestellzeile(aFactMethProd);
         getPreparedStatement().executeUpdate();
      } catch (Exception e) {
         new LogUtil().getLogger().warn(e);
      }
   }

   private void setId(final WarenkorbProdukt aFactMethProd)
      throws Exception {
      int idWarenkorbProduktIdx = 1;
      getPreparedStatement().setString(idWarenkorbProduktIdx,
                                       String.valueOf(aFactMethProd.getWarenkorbId()));
   }

   private void setProduktKunde(final WarenkorbProdukt aFactMethProd)
      throws Exception {
      int produktIdx = 2;
      getPreparedStatement().setString(produktIdx,
                                       String.valueOf(aFactMethProd.getProduktId()));
   }

   private void setBestellzeile(final WarenkorbProdukt aFactMethProd)
      throws Exception {
      int bestellzeileIdx = 3;
      getPreparedStatement().setString(bestellzeileIdx,
                                       String.valueOf(aFactMethProd.getBestellzeileId()));
   }
}
