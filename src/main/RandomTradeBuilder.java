package main;

import java.util.Date;
import java.util.Random;

import enums.Indicator;

public class RandomTradeBuilder extends TradeBuilder{
/**
 * Creating a trade randomly 
 */
	RandomTradeBuilder(){
		date = new Date();	
	}
	
	@Override
	protected double retrievePrice() {
		int rangeMin = 1;
		int rangeMax = 10;
		Random r = new Random();
		double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
		return randomValue;
	}

	@Override
	protected Indicator retrieveIndicator() {
		Indicator[] indicator = Indicator.values();
		Random generator = new Random();
		return indicator[generator.nextInt(indicator.length)];
	}

	@Override
	protected int retrieveQuantity() {
		int maxQuantity=20;
		int minQuantity=1;
		return minQuantity + (int)(Math.random() * maxQuantity);
	}

}
