package de.datagenerator.datamodel;

public class Warenkorb
   implements Product {

   private long id;

   private long kundenId;

   public Warenkorb(final long aId, final long aKundenId) {
      this.id = aId;
      this.kundenId = aKundenId;
   }

   public final boolean equals(final Object aObject) {
      boolean isEqual = false;
      if ((aObject != null) && (aObject.getClass() == this.getClass())) {
         Warenkorb warenkorb = (Warenkorb) aObject;
         if (warenkorb.getId() == id) {
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

   public final long getKundenId() {
      return kundenId;
   }

   public final void setKundenId(final long aKundenId) {
      this.kundenId = aKundenId;
   }

}
