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

public class GroupDataGenerator {

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
		List<GroupData> groups = generateRandomGroups(amount);
		if (format.equals("csv"))
			saveGroupsToCsvFile(groups, file);
		else if (format.equals("xml"))
			saveGroupsToXmlFile(groups, file);
		else
			System.out.println("Unknown format" + format);
	}

	private static void saveGroupsToXmlFile(List<GroupData> groups, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("group", GroupData.class);
		String xml = xstream.toXML(groups);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
		System.out.println("File " + file + " has been created.");
	}

	@SuppressWarnings("unchecked")
	public static List<GroupData> loadGroupsFromXmlFile(File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("group", GroupData.class);
		return (List<GroupData>) xstream.fromXML(file);
	}

	private static void saveGroupsToCsvFile(List<GroupData> groups, File file) {
		try (FileWriter writer = new FileWriter(file)) {
			for (GroupData group : groups)
				writer.write(group.getName() + "," + group.getHeader() + "," + group.getFooter() + ",!" + "\n");
			System.out.println("File " + file + " has been created.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<GroupData> loadGroupsFromCsvFile(File file) throws IOException {
		List<GroupData> list = new ArrayList<GroupData>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] split = line.split(",");
			GroupData group = new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2]);
			list.add(group);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();

		return list;
	}

	public static List<GroupData> generateRandomGroups(int amount) {
		List<GroupData> list = new ArrayList<GroupData>();
		for (int i = 0; i < amount; i++) {
			GroupData group = new GroupData().withName(generateRandomString()).withHeader(generateRandomString())
					.withFooter(generateRandomString());
			list.add(group);
		}
		return list;
	}

}
