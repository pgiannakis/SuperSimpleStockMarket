package main;

import java.util.ArrayList;
import data.Stock;
import data.StockAndTrade;
import enums.StockType;

public class Client {
	
	public static void main(String[] args) {
		//init Stock
		ArrayList<Stock> stockArray = new ArrayList<Stock>(){{
		add(new Stock("TEA", StockType.COMMON, 0.0, 0.0, 100.0));
		add(new Stock("POP", StockType.COMMON, 8.0, 0.0, 100.0));
		add(new Stock("ALE", StockType.COMMON, 23.0,0.0,60.0));
		add(new Stock("GIN", StockType.PREFERRED, 8.0, (double)2/100, 100.0));
		add(new Stock("JOE", StockType.COMMON, 13.0, 0.0, 250.0));
		}};

		//create Trades and associate with Stock  
		StockAndTradeFactory stockAndTradeFactory = new RandomStockAndTradeFactory(stockArray);
		ArrayList<StockAndTrade> stockAndTradeArray = stockAndTradeFactory.populateStockAandTrade();
		
		//Calculate Financial Rations
		RationCalculator rationCalculator = new AssignmentRationCalculator(stockAndTradeArray,10);
		rationCalculator.calculateRates();
		System.out.println(rationCalculator.toString());			
		
	}
}
