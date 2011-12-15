package de.db.datamodel;

public class Warenkorb {

	private long id;
	private long kundenId;

	public Warenkorb(long id, long kundenId) {
		this.id = id;
		this.kundenId = kundenId;
	}

	public boolean equals(Object object) {
		boolean isEqual = false;
		if ((object != null) && (object.getClass() == this.getClass())) {
			Warenkorb warenkorb = (Warenkorb) object;
			if (warenkorb.getId() == id) {
				isEqual = true;
			}
		}
		return isEqual;
	}

	public int hashCode() {
		return (int) this.id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getKundenId() {
		return kundenId;
	}

	public void setKundenId(long kundenId) {
		this.kundenId = kundenId;
	}

}
