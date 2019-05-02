package cz.uhk.dordb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static List<User> users = new ArrayList<User>();

	public static void main(String[] args) {

		// printMaker(Maker.getData());
		readUsers();
		printUsers();
	}

	private static void printMaker(List<Maker> makers) {

		for (int i = 0; i < makers.size(); i++) {
			Maker maker = makers.get(i);
			System.out.println(
					"INSERT INTO \"A_COMPUTER_BRAND\" (COMPUTER_BRAND_ID, COMPUTER_BRAND_MAKER, COMPUER_MODEL) "
							+ "VALUES ('" + i + "', '" + maker.getBrand() + "', '" + maker.getModel() + "');");
		}
	}

	private static void printUsers() {
		try {
			FileWriter fw = new FileWriter("Users_output");

			for (int i = 0; i < users.size(); i++) {
				User u = users.get(i);
				String line = ("INSERT INTO \"A_USER\" (USER_ID, USER_FIRST_NAME, USER_LAST_NAME, USER_ROLE, USER_PASSWORD, USER_LOGIN, USER_EMAIL_ADDRESS) "
						+ "VALUES ('" + i + "', '" + u.getFirstName() + "', '" + u.getLastName() + "', '" + u.getRole()
						+ "', '" + u.getPassword() + "', '" + u.getLogin() + "', '" + u.getEmail() + "');");
				fw.write(line + "\n");
			}
			
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void readUsers() {
		try (BufferedReader br = new BufferedReader(new FileReader("MOCK_DATA.csv"))) {
			br.readLine();
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				User u = new User();
				u.setFirstName(values[0]);
				u.setLastName(values[1]);
				u.setEmail(values[2]);
				u.setPassword(values[3]);
				if (values[1].length() < 4) {
					u.setLogin(values[1].substring(0, values[1].length()) + values[0].substring(0, 2));
				} else {
					u.setLogin(values[1].substring(0, 4) + values[0].substring(0, 2));
				}

				users.add(u);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
