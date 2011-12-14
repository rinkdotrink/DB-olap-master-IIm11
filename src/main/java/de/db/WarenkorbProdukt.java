package de.db;

import java.math.BigInteger;

public class WarenkorbProdukt {

	private BigInteger warenkorbId;
	private BigInteger kundenId;

	public BigInteger getWarenkorbId() {
		return warenkorbId;
	}

	public void setWarenkorbId(BigInteger warenkorbId) {
		this.warenkorbId = warenkorbId;
	}

	public BigInteger getKundenId() {
		return kundenId;
	}

	public void setKundenId(BigInteger kundenId) {
		this.kundenId = kundenId;
	}

}
