package DAO;

public class CommandDAO {
	
	private String command;
	private String args;

	public CommandDAO() {
		this.command = "";
		this.args = "";
	}
	
	public CommandDAO(String line) {
		if (!line.equals("END")) {
			String[] cmdArray = line.split(" ");
			if (cmdArray.length == 2) {
				this.command = cmdArray[0];
				this.args = cmdArray[1];
			} else {
				this.command = cmdArray[0];
				this.args = cmdArray[1] + " " + cmdArray[2];
			}
		} else {
			this.command = "END";
			this.args = "";
		}
	}
	
	public CommandDAO(String command, String args) {
		this.command = command;
		this.args = args;
	}
	
	public String getCommand() {
		return this.command;
	}
	
	public String getArgs() {
		return this.args;
	}
	
	public void setCommand(String command) {
		this.command = command;
	}
	
	public void setArgs(String args) {
		this.args = args;
	}
}
