package main;

import java.util.Date;

import data.Trade;

import enums.Indicator;

public abstract class TradeBuilder {
	Trade trade;
	private double price;
	private Indicator indicator;
	private int quantity;
	protected Date date;
	
	/**
	 * build a Trade
	 * @return the Trade
	 */
	public Trade buildTrade(){
		price = retrievePrice();
		indicator = retrieveIndicator();
		quantity = retrieveQuantity();
		trade = new Trade(date,quantity,indicator,price);
		return trade;
	}

	protected abstract double retrievePrice();
	protected abstract Indicator retrieveIndicator();
	protected abstract int retrieveQuantity();
}
