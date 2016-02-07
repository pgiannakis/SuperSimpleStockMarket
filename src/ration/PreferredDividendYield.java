package ration;

import data.Stock;

public class PreferredDividendYield implements FinancialRatio{	
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
	 * Calculate Preferred Dividend Yield 
	 * @param stock the give stock record object
	 * @param price a price
	 */
	public PreferredDividendYield(Stock stock,double price){
		this.stock = stock;
		this.price = price;
	}
	
	public double calculateFinancialRatio() {
		return this.stock.getFixedDividend()*this.stock.getParValue()/price;
	}

}
