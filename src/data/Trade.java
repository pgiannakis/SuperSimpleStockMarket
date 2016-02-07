package data;

import java.util.Date;

import enums.Indicator;

public class Trade {
	private Date timestamp;
	private int quantity;
	private Indicator indicator;
	private double price;
	
	/**
	 * 
	 * @param timestamp
	 * @param quantity
	 * @param indicator
	 * @param price
	 */
	public Trade (Date timestamp,int quantity, Indicator indicator,double price){
		this.setTimestamp(timestamp);
		this.setQuantity(quantity);
		this.setIndicator(indicator);
		this.setPrice(price);
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Indicator getIndicator() {
		return indicator;
	}

	public void setIndicator(Indicator indicator) {
		this.indicator = indicator;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString(){
		return "TRADE [ Date = "+ timestamp.toString()+" Quantity = " + quantity + " Indicator = " + indicator + " Price = " + price + "]";
	}

}
