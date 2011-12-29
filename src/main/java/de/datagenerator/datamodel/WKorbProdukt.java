package de.datagenerator.datamodel;

public class WKorbProdukt
   implements Product {

   private long bestellzeileId;

   private long wKorbId;

   private long produktId;

   public WKorbProdukt(final long aBestellzeileId, final long aWKorbId,
                       final long aProduktId) {
      this.bestellzeileId = aBestellzeileId;
      this.wKorbId = aWKorbId;
      this.produktId = aProduktId;
   }

   public final boolean equals(final Object aObject) {
      boolean isEqual = false;
      if ((aObject != null) && (aObject.getClass() == this.getClass())) {
         WKorbProdukt warenkorbProdukt = (WKorbProdukt) aObject;
         if (warenkorbProdukt.getBestellzeileId() == bestellzeileId) {
            isEqual = true;
         }
      }

      return isEqual;
   }

   public final int hashCode() {
      return (int) this.bestellzeileId;
   }

   public final long getBestellzeileId() {
      return bestellzeileId;
   }

   public final void setBestellzeileId(final long aBestellzeileId) {
      this.bestellzeileId = aBestellzeileId;
   }

   public final long getWKorbId() {
      return wKorbId;
   }

   public final void setWKorbId(final long aWKorbId) {
      this.wKorbId = aWKorbId;
   }

   public final long getProduktId() {
      return produktId;
   }

   public final void setProduktId(final long aKundenId) {
      this.produktId = aKundenId;
   }

}
