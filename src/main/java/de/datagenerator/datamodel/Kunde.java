package de.datagenerator.datamodel;

public class Kunde
   implements Product {

   private long id;
   private String name;
   private long kundenNr;

   public Kunde(final long aId, final String aName, final long aKundenNr) {
      this.id = aId;
      this.name = aName;
      this.kundenNr = aKundenNr;
   }

   public final boolean equals(final Object aObject) {
      boolean isEqual = false;
      if ((aObject != null) && (aObject.getClass() == this.getClass())) {
         Kunde kunde = (Kunde) aObject;
         if ((kunde.getId() == id) && (kunde.getKundenNr() == kundenNr)
            && (kunde.name.equals(name))) {
            isEqual = true;
         }
      }
      return isEqual;
   }

   public final int hashCode() {
      return (int) this.id;
   }

   public final long getId() {
      return id;
   }

   public final void setId(final long aId) {
      this.id = aId;
   }

   public final String getName() {
      return name;
   }

   public final void setName(final String aName) {
      this.name = aName;
   }

   public final long getKundenNr() {
      return kundenNr;
   }

   public final void setKundenNr(final long aKundenNr) {
      this.kundenNr = aKundenNr;
   }

}
