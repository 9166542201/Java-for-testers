package com.example.tests;

public class GroupData implements Comparable<GroupData>{
	public String group_name;
	public String group_header;
	public String group_footer;

	@Override
	public String toString() {
		return "GroupData [group_name=" + group_name + ", group_header=" + group_header + ", group_footer="
				+ group_footer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((group_name == null) ? 0 : group_name.hashCode());
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
		if (group_name == null) {
			if (other.group_name != null)
				return false;
		} else if (!group_name.equals(other.group_name))
			return false;
		return true;
	}

	@Override
	public int compareTo(GroupData other) {
		return this.group_name.compareTo(other.group_name);
	}

}