package com.example.tests;

public class ContactData implements Comparable<ContactData> {

	private String id;

	private String firstname;
	private String lastname;
	private String address;
	private String home;
	private String mobile;
	private String work;
	private String email;
	private String email2;
	private String bday;
	private String bmonth;
	private String byear;
	private String address2;
	private String phone2;

	private String new_group = null;

	public String getId() {
		return id;
	}

	public ContactData setId(String id) {
		this.id = id;
		return this;
	}

	@Override
	public int compareTo(ContactData other) {
		return this.id.compareTo(other.id);
	}

	@Override
	public String toString() {
		return "ContactData [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address
				+ ", home=" + home + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ContactData other = (ContactData) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getFirstname() {
		return firstname;
	}

	public ContactData setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public String getLastname() {
		return lastname;
	}

	public ContactData setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public ContactData setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public ContactData setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getHome() {
		return home;
	}

	public ContactData setHome(String home) {
		this.home = home;
		return this;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getBday() {
		return bday;
	}

	public void setBday(String bday) {
		this.bday = bday;
	}

	public String getBmonth() {
		return bmonth;
	}

	public void setBmonth(String bmonth) {
		this.bmonth = bmonth;
	}

	public String getByear() {
		return byear;
	}

	public void setByear(String byear) {
		this.byear = byear;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getNew_group() {
		return new_group;
	}

	public void setNew_group(String new_group) {
		this.new_group = new_group;
	}

}