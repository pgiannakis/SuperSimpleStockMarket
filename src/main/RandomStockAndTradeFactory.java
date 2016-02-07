package main;

import java.util.ArrayList;

import data.Stock;
import data.StockAndTrade;
import data.Trade;

public class RandomStockAndTradeFactory extends StockAndTradeFactory{
/**
 * 
 * @param stockArray a given stock
 */
	public RandomStockAndTradeFactory(ArrayList<Stock> stockArray){
		this.stockArray=stockArray;
		stockAndTrade = new ArrayList<StockAndTrade>();
	}
	@Override
	public void factoryMethod() {
		for (int i=0; i<stockArray.size();i++){
			TradeBuilder tradeBuilder = new RandomTradeBuilder();
			ArrayList<Trade> trade = new ArrayList<Trade>();
			
			for (int t=0; t<10;t++){
				trade.add(tradeBuilder.buildTrade());
			}
			stockAndTrade.add(new StockAndTrade(stockArray.get(i),trade));
		}
		
	}

}
