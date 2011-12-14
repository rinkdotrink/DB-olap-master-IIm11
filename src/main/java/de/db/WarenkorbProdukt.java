package de.db;

public class WarenkorbProdukt {

	private long bestellzeileId;
	private long warenkorbId;
	private long produktId;

	public WarenkorbProdukt(long bestellzeileId, long warenkorbId,
			long produktId) {
		this.bestellzeileId = bestellzeileId;
		this.warenkorbId = warenkorbId;
		this.produktId = produktId;
	}

	public boolean equals(Object object) {
		boolean isEqual = false;
		if (object != null) {
			if (object.getClass() == WarenkorbProdukt.class) {
				WarenkorbProdukt warenkorbProdukt = (WarenkorbProdukt) object;
				if (warenkorbProdukt.getBestellzeileId() == bestellzeileId) {
					isEqual = true;
				}
			}
		}

		return isEqual;
	}

	public long getBestellzeileId() {
		return bestellzeileId;
	}

	public void setBestellzeileId(long bestellzeileId) {
		this.bestellzeileId = bestellzeileId;
	}

	public long getWarenkorbId() {
		return warenkorbId;
	}

	public void setWarenkorbId(long warenkorbId) {
		this.warenkorbId = warenkorbId;
	}

	public long getProduktId() {
		return produktId;
	}

	public void setProduktId(long kundenId) {
		this.produktId = kundenId;
	}

}
