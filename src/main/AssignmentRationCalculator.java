package main;

import java.util.ArrayList;

import ration.CommonDividendYield;
import ration.FinancialRatio;
import ration.GBCE;
import ration.PERation;
import ration.PreferredDividendYield;
import ration.VolumeWeightedStockPrice;

import data.Stock;
import data.StockAndTrade;

import enums.StockType;


public class AssignmentRationCalculator implements RationCalculator{
	private ArrayList<StockAndTrade> stockAndTrade;
	private double dividendYield;
	private double peRation;
	private double volumeWeightedStockPrice;
	private double gbce;
	private StringBuilder stringBuilder;
	private static int sharedIndex=5;	
	private double price;
	
	/**
	 * Calculate all rates for the assignment 
	 * @param stockAndTrade object with all stocks and trades
	 * @param price a given price
	 */
	public AssignmentRationCalculator(ArrayList<StockAndTrade> stockAndTrade, double price){
		this.stockAndTrade=stockAndTrade;
		this.price=price;
		stringBuilder = new StringBuilder();
	}
	
	public void calculateRates(){
		FinancialRatio financialRatio;
		
		for (int i = 0; i<stockAndTrade.size(); i++){
			
			stringBuilder.append(stockAndTrade.get(i).toString());
			Stock currentStock = stockAndTrade.get(i).getStock();
			stringBuilder.append( "\n Price " + price);
			
			if (isCommon(currentStock)){
				financialRatio =new CommonDividendYield(currentStock,price);
				dividendYield = financialRatio.calculateFinancialRatio();
				stringBuilder.append( "\n Dividend Yield " + dividendYield);
			}else if (currentStock.getStockType() == StockType.PREFERRED ){
				financialRatio =new PreferredDividendYield(currentStock,price);
				dividendYield = financialRatio.calculateFinancialRatio();
				stringBuilder.append( "\n Preferred Dividend Yield " + dividendYield);
			}
			
			financialRatio = new PERation(currentStock,10);
			peRation = financialRatio.calculateFinancialRatio();
			stringBuilder.append( "\n P/E Ration " + peRation);
			
			financialRatio = new VolumeWeightedStockPrice(stockAndTrade.get(i).getTrade());
			volumeWeightedStockPrice = financialRatio.calculateFinancialRatio();
			stringBuilder.append( "\n Volume Weighted Stock Price " + volumeWeightedStockPrice);
			stringBuilder.append("\n================================================\n");
		}
		
		financialRatio=new GBCE(stockAndTrade,sharedIndex);
		gbce = financialRatio.calculateFinancialRatio();
		stringBuilder.append( "\n GBCE for shared index "+ sharedIndex + " is "+ gbce);
	}
	/**
	 * 
	 * @param stock a stock record object 
	 * @return <code>true</code> if the stock has type <code>false</code> if the stock has type Preferred
	 */
	public boolean isCommon(Stock stock){
		if (stock.getStockType()==StockType.COMMON){
			return true;
		}else{
			return false;
		}
	}
	
	public String toString(){
		return stringBuilder.toString();
	}

}
