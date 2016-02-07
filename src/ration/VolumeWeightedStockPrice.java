package ration;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;


import data.Trade;

public class VolumeWeightedStockPrice implements FinancialRatio{
	private ArrayList<Trade> trade;
	/**
	 * Calculate Volume WeightedStock Price based on trades in past 15 minutes
	 * @param trade list of trades
	 */
	public VolumeWeightedStockPrice (ArrayList<Trade> trade){
		this.trade=trade;
	}
	
	public double calculateFinancialRatio() {
		double volumeWeigthedStockPrice = 0.0;
		int totalQuantity = 0;
		Date currentDate = new Date();
		for (int i=trade.size()-1; i >= 0; i--){
			if (isInPast15Min(currentDate,trade.get(i).getTimestamp())){
				totalQuantity += trade.get(i).getQuantity();
				volumeWeigthedStockPrice += trade.get(i).getPrice() * trade.get(i).getQuantity();
			}else{
				break;
			}
		}
		return volumeWeigthedStockPrice/totalQuantity;
	}
	
	public ArrayList<Trade> getTrade() {
		return trade;
	}
	public void setTrade(ArrayList<Trade> trade) {
		this.trade = trade;
	}
	/**
	 * 
	 * @param currentDate the current date
	 * @param tradeDate the date of a trade
	 * @return <code>true</code> if the time different is less than 15 minutes <code>false</code> if the time different is greater than 15 minutes
	 */
	public boolean isInPast15Min(Date currentDate,Date tradeDate){
		long diff = currentDate.getTime() - tradeDate.getTime();
		long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);
		
		if (minutes>15){
			return false;
		}else{
			return true;
		}
		 
	}

}
