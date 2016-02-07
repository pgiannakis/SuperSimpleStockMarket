package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import main.RandomStockAndTradeFactory;
import main.StockAndTradeFactory;

import org.junit.Before;
import org.junit.Test;

import data.Stock;
import data.StockAndTrade;
import data.Trade;
import enums.Indicator;
import enums.StockType;

public class TestRandomStockAndTradeFactory {
	ArrayList<Stock> stockArray;
	
	@Before
	public void setUp() throws Exception {
		stockArray = new ArrayList<Stock>(){{
			add(new Stock("TEA", StockType.COMMON, 0.0, 0.0, 100.0));
			add(new Stock("POP", StockType.COMMON, 8.0, 0.0, 100.0));
			add(new Stock("ALE", StockType.COMMON, 23.0,0.0,60.0));
			add(new Stock("GIN", StockType.PREFERRED, 8.0, (double)2/100, 100.0));
			add(new Stock("JOE", StockType.COMMON, 13.0, 0.0, 250.0));
			}};
	}
	
	@Test
	public void test() {
		StockAndTradeFactory randomStockAndTradeFactory = new RandomStockAndTradeFactory(stockArray);		
		assertNotNull(randomStockAndTradeFactory.populateStockAandTrade());
		
	}

}
