package de.datagenerator.dbwriter;

import de.datagenerator.LogUtil;
import de.datagenerator.datamodel.FactoryMethodProduct;
import de.datagenerator.datamodel.Kunde;

public class DBKundeWriter
   extends DBWriter {

   public DBKundeWriter() {
      try {
         initDBWriter();
      } catch (Exception e) {
         new LogUtil().getLogger().error(e);
      }
   }

   protected final void createPreparedStatement()
      throws Exception {
      setPreparedStatement(getConnection().prepareStatement("insert into  mydb.kunde(idKunde, name, kundenNummer) values (?, ?, ?)"));
   }

   public final void write(final FactoryMethodProduct aFactoryMethodProduct) {
      if (aFactoryMethodProduct instanceof Kunde) {
         writeKunde((Kunde) aFactoryMethodProduct);
      }
   }

   private void writeKunde(final Kunde aFactMethProd) {
      try {
         setId(aFactMethProd);
         setName(aFactMethProd);
         setKundenNummer(aFactMethProd);
         getPreparedStatement().executeUpdate();
      } catch (Exception e) {
         new LogUtil().getLogger().warn(e);
      }
   }

   private void setId(final Kunde aFactMethProd)
      throws Exception {
      int idKundeIdx = 1;
      getPreparedStatement().setString(idKundeIdx, String.valueOf(aFactMethProd.getId()));
   }

   private void setName(final Kunde aFactMethProd)
      throws Exception {
      int nameIdx = 2;
      getPreparedStatement().setString(nameIdx, aFactMethProd.getName());
   }

   private void setKundenNummer(final Kunde aFactMethProd)
      throws Exception {
      int kundenNummerIdx = 3;
      getPreparedStatement().setString(kundenNummerIdx,
                                       String.valueOf(aFactMethProd.getKundenNummer()));
   }

}
