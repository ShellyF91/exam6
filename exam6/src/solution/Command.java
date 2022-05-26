package solution;

public class Command {
	
	String stockName;
	Operation operation;
	
	public Command(String stockName, Operation operation) {
		this.stockName = stockName;
		this.operation = operation;
	}
	
	public static enum Operation{
		BUY, SELL;
	}
	
	public String getOperation() {
		return operation.toString();
	}
	
	public String getStockName() {
		return stockName.toString();
	}
	
//	public static void main(String[] args) {
//		Command c = new Command("HEADBOOK", Operation.BUY);
//		System.out.println(c.getStockName());
//	}
	
	

}
