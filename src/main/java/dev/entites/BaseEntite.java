package dev.entites;

public abstract class BaseEntite {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean equals(Object obj) {
		if (obj instanceof BaseEntite) {
			return id.equals(((BaseEntite) obj).getId());
		}
		return false;
	}
}
