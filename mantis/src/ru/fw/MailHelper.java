package ru.fw;

import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

public class MailHelper {

	private String mailserver;

	public MailHelper(Manager app) {
		this.mailserver = app.getProperty("mailserver.host");
	}

	public Msg getNewMail(String user, String password) {
		Properties props = System.getProperties();
		Session session = Session.getDefaultInstance(props);

		Store store;
		try {
			store = session.getStore("pop3");
			store.connect(mailserver, user, password);
			System.out.println("folder=" + store.getDefaultFolder().getFullName());
			Folder folder = store.getDefaultFolder().getFolder("INBOX");
			folder.open(Folder.READ_WRITE);
			int i = folder.getMessageCount();
			if (i != 1)
				throw new Error("Message count " + i);
			Message message = folder.getMessage(1);
			message.setFlag(Flags.Flag.DELETED, true);
			Msg msg = new Msg((String) message.getContent());
			folder.close(true);
			store.close();
			return msg;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
