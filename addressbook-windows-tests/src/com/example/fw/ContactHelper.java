package com.example.fw;

import static com.example.fw.ApplicationManager.getManager;

public class ContactHelper {

	public void createContact(Contact contact) throws Exception {
		getManager().getAutoItHelper()
		.winWaitAndActivate("AddressBook Portable", "", 10)
		.click("Add")
		.winWaitAndActivate("Add Contact", "", 10)
		.send("TDBEdit12", contact.getFirsName())
		.send("TDBEdit11", contact.getLastName())
		.click("Save")
		;
	}

	public Contact getFirstContact() {
		getManager().getAutoItHelper()
		.winWaitAndActivate("AddressBook Portable", "", 10)
		.focus("TListView1")
		.send("{down}{space}")
		.click("Edit")
		.winWaitAndActivate("Update Contact", "", 10)
		;
		String fname = getManager().getAutoItHelper().getText("TDBEdit12");
		String lname = getManager().getAutoItHelper().getText("TDBEdit11");
	
		getManager().getAutoItHelper()
		.click("Cancel")
		.winWaitAndActivate("Update Contact", "", 10)
		;

		return new Contact().setFirstName(fname).setLastName(lname);
	}

}
