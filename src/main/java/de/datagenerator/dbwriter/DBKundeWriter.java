package de.datagenerator.dbwriter;

import de.datagenerator.LogUtil;
import de.datagenerator.datamodel.Product;
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

   protected final void prepareStatement()
      throws Exception {
      String stmt =
         "insert into  mydb.kunde(idKunde, name, kundenNummer) values (?, ?, ?)";
      setPreparedStmt(getConnection().prepareStatement(stmt));
   }

   public final void write(final Product aProduct) {
      if (aProduct instanceof Kunde) {
         writeKunde((Kunde) aProduct);
      }
   }

   private void writeKunde(final Kunde aProduct) {
      try {
         setId(aProduct);
         setName(aProduct);
         setKundenNummer(aProduct);
         getPreparedStmt().executeUpdate();
      } catch (Exception e) {
         new LogUtil().getLogger().warn(e);
      }
   }

   private void setId(final Kunde aProduct)
      throws Exception {
      final int idKundeIdx = 1;
      getPreparedStmt().setString(idKundeIdx, String.valueOf(aProduct.getId()));
   }

   private void setName(final Kunde aProduct)
      throws Exception {
      final int nameIdx = 2;
      getPreparedStmt().setString(nameIdx, aProduct.getName());
   }

   private void setKundenNummer(final Kunde aProduct)
      throws Exception {
      final int kundenNummerIdx = 3;
      getPreparedStmt().setString(kundenNummerIdx,
                                  String.valueOf(aProduct.getKundenNr()));
   }

}
