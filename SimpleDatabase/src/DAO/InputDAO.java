package DAO;

import java.util.ArrayList;

public class InputDAO {
	
	private ArrayList<CommandDAO> commandList;
	public int numOfCommand;
	public int index;
	
	public InputDAO() {
		commandList = new ArrayList<CommandDAO>();
		numOfCommand = 0;
		index = 0;
	}
	
	public void add(CommandDAO newCommand) {
		commandList.add(newCommand);
		numOfCommand++;
	}
	
	public boolean hasNext() {
		return index < numOfCommand;
	}
	
	public CommandDAO next() {
		if (index < numOfCommand) {
			return commandList.get(index++);
		}
		return null;
	}
}
