package DAO;

import java.util.ArrayList;

public class OutputDAO {
	
	private ArrayList<CommandDAO> outputList;
	public int numOfOutput;
	public int index;
	
	public OutputDAO() {
		outputList = new ArrayList<CommandDAO>();
		numOfOutput = 0;
		index = 0;
	}
	
	public void add(CommandDAO newOutput) {
		outputList.add(newOutput);
		numOfOutput++;
	}
	
	public boolean hasNext() {
		return index < numOfOutput;
	}
	
	public CommandDAO next() {
		if (index < numOfOutput) {
			return outputList.get(index++);
		}
		return null;
	}
}
