package ration;

import data.Stock;

public class PERation implements FinancialRatio {
	private Stock stock;
	private double price;
	/**
	 * calculate price/earnings ratio
	 * @param stock the give stock record object
	 * @param price a price
	 */
	public PERation(Stock stock,double price){
		this.stock=stock;
		this.price=price;
	}
	
	public double calculateFinancialRatio() {
		return price/stock.getLastDividend();
	}

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

}
