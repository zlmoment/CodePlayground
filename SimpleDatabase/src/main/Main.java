package main;

import DAO.InputDAO;
import DAO.OutputDAO;

public class Main {

	public static void main(String[] args) {
		// String inFileName = "input.txt";
		String inFileName = "input2.txt";
		String outFileName = "output.txt";
		InputReader inputReader = new InputReader(inFileName);
		InputDAO inputDAO = inputReader.read();
		Parser parser = new Parser(inputDAO);
		OutputDAO outputDAO = parser.parse();
		OutputWriter outputWriter = new OutputWriter();
		outputWriter.write(outputDAO, outFileName);
		System.out.println("Done!");
	}

}
