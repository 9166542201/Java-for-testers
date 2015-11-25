package com.example.fw;

public class Contact {

	private String firsName;
	private String lastName;

	@Override
	public String toString() {
		return "Contact [firsName=" + firsName + ", lastName=" + lastName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firsName == null) ? 0 : firsName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (firsName == null) {
			if (other.firsName != null)
				return false;
		} else if (!firsName.equals(other.firsName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	public Contact setFirstName(String string) {
		firsName = string;
		return this;
	}

	public Contact setLastName(String string) {
		lastName = string;
		return this;
	}

	public String getFirsName() {
		return firsName;
	}

	public String getLastName() {
		return lastName;
	}


}
