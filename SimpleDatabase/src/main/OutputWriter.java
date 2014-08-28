package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import DAO.CommandDAO;
import DAO.OutputDAO;

public class OutputWriter {

	public OutputWriter() {
	}

	public void write(OutputDAO outputDAO, String outputFileName) {
		String fileName = outputFileName;
		try {
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			while (outputDAO.hasNext()) {
				CommandDAO output = outputDAO.next();
				if (output != null) {
					bufferedWriter.write(output.getCommand() + output.getArgs());
				}
			}
			bufferedWriter.flush();
			bufferedWriter.close();
		} catch (IOException ex) {
			System.out.println("Error writing to file '" + fileName + "'");
		}
	}

}
