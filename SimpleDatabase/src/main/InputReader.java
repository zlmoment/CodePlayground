package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import DAO.CommandDAO;
import DAO.InputDAO;

public class InputReader {

	private String fileName;

	public InputReader() {

	}

	public InputReader(String fileName) {
		this.fileName = fileName;
	}

	public InputDAO read() {
		if (fileName == null) {
			return null;
		}
		InputDAO inputDAO = new InputDAO();
		String line = null;
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				inputDAO.add(new CommandDAO(line));
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
		return inputDAO;
	}
}
