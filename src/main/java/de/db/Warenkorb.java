package de.db;

import java.math.BigInteger;

public class Warenkorb {

	private BigInteger id;
	private BigInteger kundenId;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getKundenId() {
		return kundenId;
	}

	public void setKundenId(BigInteger kundenId) {
		this.kundenId = kundenId;
	}

}
