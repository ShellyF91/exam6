package solution;

import java.util.HashMap;
import java.util.Map;
public class StocksDB {
	private final static Map<String, Stock> stocks = new HashMap<>(); 
	
	
	public static void addStocks() {
		stocks.put(StockName.DOODLE.name(), new Stock(StockName.DOODLE.name(), 3.72, 3.6));
		stocks.put(StockName.BARVAZON.name(), new Stock(StockName.BARVAZON.name(), 1.25, 1));
		stocks.put(StockName.DOODLE.name(), new Stock(StockName.HEADBOOK.name(), 9.52, 9.33));
	}
		
	public static Stock getStockByName(String name) throws IllegalArgumentException{
		Stock stock = stocks.get(name.toUpperCase());
		if(stock==null)
			throw new IllegalArgumentException("Stock is not found in DB");
		return stock;
	}
	
//	public static void main(String[] args) {
//		addStocks();
//		System.out.println(StocksDB.getStockByName("doodle"));
//	}
}
