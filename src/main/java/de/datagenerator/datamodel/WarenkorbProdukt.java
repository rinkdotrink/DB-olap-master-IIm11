package de.datagenerator.datamodel;

public class WarenkorbProdukt
   implements FactoryMethodProduct {

   private long bestellzeileId;

   private long warenkorbId;

   private long produktId;

   public WarenkorbProdukt(final long aBestellzeileId, final long aWarenkorbId,
                           final long aProduktId) {
      this.bestellzeileId = aBestellzeileId;
      this.warenkorbId = aWarenkorbId;
      this.produktId = aProduktId;
   }

   public final boolean equals(final Object aObject) {
      boolean isEqual = false;
      if ((aObject != null) && (aObject.getClass() == this.getClass())) {
         WarenkorbProdukt warenkorbProdukt = (WarenkorbProdukt) aObject;
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

   public final long getWarenkorbId() {
      return warenkorbId;
   }

   public final void setWarenkorbId(final long aWarenkorbId) {
      this.warenkorbId = aWarenkorbId;
   }

   public final long getProduktId() {
      return produktId;
   }

   public final void setProduktId(final long aKundenId) {
      this.produktId = aKundenId;
   }

}
