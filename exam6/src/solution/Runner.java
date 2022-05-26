package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Runner {
	
	private static final int NUM_THREADS = 10;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		InvestingApp investingApp = new InvestingApp();
		ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
		List<Future<Double>> futures = new ArrayList<>();
		StocksDB stocksDB = new StocksDB();
		stocksDB.addStocks();
		for(int i = 0; i < 10; i++) {
			futures.add(executorService.submit( () ->{
				Command command = investingApp.getCommandFromList();
				// changing the sell/buy price of the stock 
				if(command.getOperation() == "BUY") {
					stocksDB.getStockByName(command.getStockName()).updateBuyPrice();
					return stocksDB.getStockByName(command.getStockName()).getBuyPrice();
				}
				else {
					stocksDB.getStockByName(command.getStockName()).updateSellPrice();
					return  (-1)*(stocksDB.getStockByName(command.getStockName()).getSellPrice());
				}
			}));
		}
		
		for(Future<Double> future : futures) {
			investingApp.updateTotalFunds(future.get());
		}
		
		System.out.println(investingApp.getTotalFunds());
		
		executorService.shutdown();
		executorService.awaitTermination(10, TimeUnit.SECONDS);

	}

}
