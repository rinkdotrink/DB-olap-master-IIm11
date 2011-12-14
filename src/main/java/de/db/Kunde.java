package de.db;

public class Kunde {

	private long id;
	private String name;
	private long kundenNummer;

	public Kunde(long id, String name, long kundenNummer) {
		this.id = id;
		this.name = name;
		this.kundenNummer = kundenNummer;
	}

	public boolean equals(Object object) {
		boolean isEqual = false;
		if (object != null) {
			if (object.getClass() == Kunde.class) {
				Kunde kunde = (Kunde) object;
				if (kunde.getId() == id) {
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

	public long getKundenNummer() {
		return kundenNummer;
	}

	public void setKundenNummer(long kundenNummer) {
		this.kundenNummer = kundenNummer;
	}

}
