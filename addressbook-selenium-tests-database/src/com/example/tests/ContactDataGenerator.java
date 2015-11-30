package com.example.tests;

import static com.example.tests.TestBase.generateRandomString;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please specify parameters: <amount of the data> <file> <format>");
			return;
		}
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);

		String format = args[2];
		if (file.exists()) {
			System.out.println("File exists, please remove the " + file + " manually");
			return;
		}
		List<ContactData> contacts = generateRandomContacts(amount);
		if (format.equals("csv"))
			saveContactsToCsvFile(contacts, file);
		else if (format.equals("xml"))
			saveContactsToXmlFile(contacts, file);
		else
			System.out.println("Unknown format" + format);
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
		System.out.println("File " + file + " has been created.");
	}

	@SuppressWarnings("unchecked")
	public static List<ContactData> loadContactsFromXmlFile(File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) {
		try (FileWriter writer = new FileWriter(file)) {
			for (ContactData contact : contacts)
				writer.write(contact.getFirstname() + "," + contact.getLastname() + "," + contact.getEmail() + ",!" + "\n");
			System.out.println("File " + file + " has been created.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] split = line.split(",");
			ContactData contact = new ContactData().setFirstname(split[0]).setLastname(split[1]).setEmail(split[2]);
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<>();
		for (int i = 0; i < amount; i++) {
			ContactData contact = new ContactData()
					.setFirstname(generateRandomString())
					.setLastname(generateRandomString())
					.setEmail(generateRandomString())
					.setAddress(generateRandomString())
					.setHome(generateRandomString());
			list.add(contact);
		}
		return list;
	}

}
