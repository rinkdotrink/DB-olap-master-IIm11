package de.datagenerator.datamodel;

public class Produkt
   implements Product {

   private long id;
   private String name;
   private int preisInCent;

   public Produkt(final long aId, final String aName, final int aPreisInCent) {
      this.id = aId;
      this.name = aName;
      this.preisInCent = aPreisInCent;
   }

   public final boolean equals(final Object aObject) {
      boolean isEqual = false;
      if ((aObject != null) && (aObject.getClass() == this.getClass())) {
         Produkt produkt = (Produkt) aObject;
         if ((produkt.getId() == id) && (produkt.getName().equals(name))
            && produkt.getPreisInCent() == preisInCent) {
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

   public final int getPreisInCent() {
      return preisInCent;
   }

   public final void setPreisInCent(final int aPreisInCent) {
      this.preisInCent = aPreisInCent;
   }

}
