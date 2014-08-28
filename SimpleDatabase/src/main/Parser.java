package main;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import DAO.CommandDAO;
import DAO.InputDAO;
import DAO.OutputDAO;

public class Parser {

	private InputDAO inputDAO;
	private OutputDAO outputDAO;
	private LinkedHashMap<String, String> map;

	public Parser() {
		outputDAO = new OutputDAO();
		map = new LinkedHashMap<String, String>();
	}

	public Parser(InputDAO inputDAO) {
		this.inputDAO = inputDAO;
		outputDAO = new OutputDAO();
		map = new LinkedHashMap<String, String>();
	}

	public OutputDAO parse() {
		if (inputDAO == null) {
			return null;
		}
		while (inputDAO.hasNext()) {
			CommandDAO command = inputDAO.next();
			String commandStr = command.getCommand();
			if (commandStr.equals("SET")) {
				String[] values = command.getArgs().split(" ");
				map.put(values[0], values[1]);
				outputDAO.add(new CommandDAO("","\n"));
			} else if (commandStr.equals("GET")) {
				if (!map.containsKey(command.getArgs())) {
					outputDAO.add(new CommandDAO("NULL", "\n"));
				} else {
					outputDAO.add(new CommandDAO(map.get(command.getArgs()), "\n"));
				}
			} else if (commandStr.equals("UNSET")) {
				if (map.containsKey(command.getArgs())) {
					map.remove(command.getArgs());
					outputDAO.add(new CommandDAO("","\n"));
				}
			} else if (commandStr.equals("NUMEQUALTO")) {
				int num = 0;
				for (Entry<String, String> entry : map.entrySet()) {
			        if (command.getArgs().equals(entry.getValue())) {
			        	num++;
			        }
			    }
				outputDAO.add(new CommandDAO(String.valueOf(num), "\n"));
			} else if (commandStr.equals("END")) {
				outputDAO.add(new CommandDAO("",""));
			}
		}
		return outputDAO;
	}

}
