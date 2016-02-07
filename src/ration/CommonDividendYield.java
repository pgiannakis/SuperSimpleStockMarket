package ration;

import data.Stock;

public class CommonDividendYield implements FinancialRatio {
	private Stock stock;
	private double price;
	
	public Stock getStock() {
		return stock;
	}
	
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * Calculate the Common Dividend Yield 
	 * @param stock the give stock record object
	 * @param price a price
	 */
	public CommonDividendYield(Stock stock,double price){
		this.stock = stock;
		this.price = price;
	}
	
	/**
	 * using the formula last dividend/price
	 * @return the ratio
	 */
	public double calculateFinancialRatio() {
		return this.stock.getLastDividend()/price;
	}
	

}
