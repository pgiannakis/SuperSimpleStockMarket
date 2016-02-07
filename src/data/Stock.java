package data;

import enums.StockType;

public class Stock {
	private String stockSymbol;
	private StockType stockType;
	private double lastDividend;
	private double fixedDividend;
	private double parValue;
	
	public String getStockSymbol() {
		return stockSymbol;
	}
	
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	
	public StockType getStockType() {
		return stockType;
	}

	public void setStockType(StockType stockType) {
		this.stockType = stockType;
	}

	public double getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(double lastDividend) {
		this.lastDividend = lastDividend;
	}

	public double getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public double getParValue() {
		return parValue;
	}

	public void setParValue(double parValue) {
		this.parValue = parValue;
	}
	/**
	 * 
	 * @param stockSymbol
	 * @param stockType
	 * @param lastDividend
	 * @param fixedDividend
	 * @param parValue
	 */
	public Stock (String stockSymbol, StockType stockType, double lastDividend, double fixedDividend, double parValue){
		this.stockSymbol=stockSymbol;
		this.stockType=stockType;
		this.lastDividend=lastDividend;
		this.fixedDividend=fixedDividend;
		this.parValue=parValue;
	}
	
	public String toString() {
		return "Stock [symbol=" + stockSymbol + ", type=" + stockType + ", lastDividend="
				+ lastDividend + ", fixedDividend=" + fixedDividend
				+ ", parValue=" + parValue + "]";
	}
	
}
