package com.example.tests;

public class GroupData implements Comparable<GroupData> {

	private String id;
	private String name;
	private String header;
	private String footer;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getHeader() {
		return header;
	}

	public String getFooter() {
		return footer;
	}

	public GroupData setId(String id) {
		this.id = id;
		return this;
	}
	public GroupData setName(String name) {
		this.name = name;
		return this;
	}

	public GroupData setHeader(String header) {
		this.header = header;
		return this;
	}

	public GroupData setFooter(String footer) {
		this.footer = footer;
		return this;
	}

	@Override
	public String toString() {
		return "GroupData [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		GroupData other = (GroupData) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(GroupData other) {
		return this.name.compareTo(other.name);
	}

}