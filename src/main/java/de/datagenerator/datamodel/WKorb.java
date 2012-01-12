package de.datagenerator.datamodel;

import java.util.Date;

public class WKorb
   implements Product {

   private long id;
   private long kundenId;
   private Date datum;

   public WKorb(final long aId, final long aKundenId, final Date aDatum) {
      this.id = aId;
      this.kundenId = aKundenId;
      this.datum = aDatum;
   }

   public final boolean equals(final Object aObject) {
      boolean isEqual = false;
      if ((aObject != null) && (aObject.getClass() == this.getClass())) {
         WKorb warenkorb = (WKorb) aObject;
         if ((warenkorb.getId() == id) && (warenkorb.getKundenId() == kundenId) && (warenkorb.getDatum().equals(datum))) {
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

   public Date getDatum() {
      return datum;
   }

   public void setDatum(Date datum) {
      this.datum = datum;
   }

}
