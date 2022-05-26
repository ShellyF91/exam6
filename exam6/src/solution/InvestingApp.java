package solution;

import java.util.ArrayList;
import java.util.List;

import solution.Command.Operation;

public class InvestingApp {
	
	private List<Command> commands;
	private double totalFunds; 
	public int counter;

	public InvestingApp(){
		commands = new ArrayList<>();
		addToList();
		counter = -1; 
		totalFunds = 0; 
	}

	private void addToList() {
		commands.add(new Command("BARVAZON", Operation.BUY));
		commands.add(new Command("BARVAZON", Operation.SELL));
		commands.add(new Command("BARVAZON", Operation.BUY));
		commands.add(new Command("BARVAZON", Operation.BUY));
		commands.add(new Command("BARVAZON", Operation.SELL));
		commands.add(new Command("DOODLE", Operation.BUY));
		commands.add(new Command("HEADBOOK", Operation.BUY));
		commands.add(new Command("DOODLE", Operation.BUY));
		commands.add(new Command("HEADBOOK", Operation.SELL));
		commands.add(new Command("HEADBOOK", Operation.SELL));
		
		commands.add(new Command("THREADBOOK", Operation.BUY));
	}
	
	public Command getCommandFromList() {
		counter++;
		return commands.get(counter);
	}
	
	public void updateTotalFunds(double sum) {
		totalFunds += sum; 
	}
	
	public double getTotalFunds() {
		return totalFunds;
	}

	
	
	
	

}
