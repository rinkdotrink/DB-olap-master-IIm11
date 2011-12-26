package de.datagenerator.datamodel;

public class Kunde
   implements FactoryMethodProduct {

   private long id;

   private String name;

   private long kundenNummer;

   public Kunde(final long aId, final String aName, final long aKundenNummer) {
      this.id = aId;
      this.name = aName;
      this.kundenNummer = aKundenNummer;
   }

   public final boolean equals(final Object aObject) {
      boolean isEqual = false;
      if ((aObject != null) && (aObject.getClass() == this.getClass())) {
         Kunde kunde = (Kunde) aObject;
         if (kunde.getId() == id) {
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

   public final long getKundenNummer() {
      return kundenNummer;
   }

   public final void setKundenNummer(final long aKundenNummer) {
      this.kundenNummer = aKundenNummer;
   }

}
