package de.datagenerator.dbwriter;

import de.datagenerator.LogUtil;
import de.datagenerator.datamodel.Kunde;
import de.datagenerator.datamodel.Product;

public class DBKundeWriter
   extends DBWriter {

   public DBKundeWriter() {
      try {
         initDBWriter();
      } catch (Exception e) {
         LogUtil.getLogger().error(e);
      }
   }

   public void write(final Product aProduct) {
      if (aProduct instanceof Kunde) {
         writeKunde((Kunde) aProduct);
      }
   }

   protected final void prepareStatement()
      throws Exception {
      String stmt =
         "insert into  adbc.kunde(KUNDE_ID, Name, Kundennummer) values (?, ?, ?)";
      setPreparedStmt(getConnection().prepareStatement(stmt));
   }

   private void writeKunde(final Kunde aProduct) {
      try {
         setId(aProduct.getId());
         setName(aProduct.getName());
         setKundenNr(aProduct.getKundenNr());
         getPreparedStmt().executeUpdate();
      } catch (Exception e) {
         LogUtil.getLogger().error(e);
      }
   }

   private void setId(final long aId)
      throws Exception {
      final int idKundeIdx = 1;
      getPreparedStmt().setString(idKundeIdx, String.valueOf(aId));
   }

   private void setName(final String aName)
      throws Exception {
      final int nameIdx = 2;
      getPreparedStmt().setString(nameIdx, aName);
   }

   private void setKundenNr(final long aKundenNr)
      throws Exception {
      final int kundenNummerIdx = 3;
      getPreparedStmt().setString(kundenNummerIdx, String.valueOf(aKundenNr));
   }

}
