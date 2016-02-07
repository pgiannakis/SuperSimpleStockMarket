package data;

import java.util.ArrayList;

public class StockAndTrade {
	private Stock stock;
	private ArrayList<Trade> trade;

	/**
	 * This class represent the association between Stock and Trades 
	 * @param stock
	 * @param trade
	 */
	public StockAndTrade(Stock stock,ArrayList<Trade> trade){
		this.stock=stock;
		this.trade=trade;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public ArrayList<Trade> getTrade() {
		return trade;
	}

	public void setTrade(ArrayList<Trade> trade) {
		this.trade = trade;
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("{ \n " + stock.toString());
		for (int i=0;i<trade.size();i++){
			builder.append("\n " + trade.get(i).toString());
		}
		builder.append(" \n}");
		return builder.toString();
	}
}
