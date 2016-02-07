package ration;

import java.util.ArrayList;


import data.StockAndTrade;

public class GBCE implements FinancialRatio{
	private ArrayList<StockAndTrade> stockAndTradeArray;
	private int shareIndex;
	
	/**
	 * Calculate GBCE for all shared Index using the geometric mean of price for all stocks 
	 * @param stockAndTradeArray 
	 * @param shareIndex
	 */
	public GBCE(ArrayList<StockAndTrade> stockAndTradeArray, int shareIndex){
		this.stockAndTradeArray=stockAndTradeArray;
		this.shareIndex=shareIndex;
	}
	
	public double calculateFinancialRatio() {
		
		double allShareIndex = 1;
		for (int i=0; i<stockAndTradeArray.size(); i++){
			allShareIndex = allShareIndex * stockAndTradeArray.get(i).getTrade().get(shareIndex).getPrice();
		}
		return (double)Math.pow(allShareIndex, 1.0 / stockAndTradeArray.size());
	}

}
