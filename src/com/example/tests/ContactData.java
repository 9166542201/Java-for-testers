package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	public String firstname;
	public String lastname;
	public String address;
	public String home;
	public String mobile;
	public String work;
	public String email;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String address2;
	public String phone2;
	public String new_group;

	/* This method below is not applicable (see my comments in the TestOfContactModification )
	 * @Override public int compareTo(ContactData other) { if
	 * (lastname.compareToIgnoreCase(other.lastname) > 0) return 1; else if
	 * (lastname.compareToIgnoreCase(other.lastname) < 0) return -1; else if
	 * (firstname.compareToIgnoreCase(other.firstname) > 0) return 1; else if
	 * (firstname.compareToIgnoreCase(other.firstname) < 0) return -1; else
	 * return 0; }
	 */
	@Override
	public int compareTo(ContactData other) {
		if (lastname.compareTo(other.lastname) > 0)
			return 1;
		else if (lastname.compareTo(other.lastname) < 0)
			return -1;
		else if (firstname.compareTo(other.firstname) > 0)
			return 1;
		else if (firstname.compareTo(other.firstname) < 0)
			return -1;
		else
			return 0;
	}

	@Override
	public String toString() {
		return "ContactData [firstname=" + firstname + ", lastname=" + lastname + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}
}