package de.db;

import java.math.BigInteger;

public class Kunde {

	private BigInteger id;
	private String name;
	private Integer preis;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPreis() {
		return preis;
	}

	public void setPreis(Integer preis) {
		this.preis = preis;
	}

}
