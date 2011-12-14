package de.db.datamodel;

public class Produkt {

	private long id;
	private String name;
	private Integer preis;

	public Produkt(long id, String name, Integer preis) {
		this.id = id;
		this.name = name;
		this.preis = preis;
	}

	public boolean equals(Object object) {
		boolean isEqual = false;
		if (object != null) {
			if (object.getClass() == Produkt.class) {
				Produkt produkt = (Produkt) object;
				if (produkt.getId() == id) {
					isEqual = true;
				}
			}
		}

		return isEqual;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
