package main;

import java.util.ArrayList;

import data.Stock;
import data.StockAndTrade;

public abstract class StockAndTradeFactory {
	protected ArrayList<Stock> stockArray;
	protected ArrayList<StockAndTrade> stockAndTrade;
	
	/**
	 * 
	 * @return an array list with stock and trades
	 */
	public ArrayList<StockAndTrade> populateStockAandTrade(){
		factoryMethod();
		return stockAndTrade;
	}
	
	protected abstract void factoryMethod();
	
}
