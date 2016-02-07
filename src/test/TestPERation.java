package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ration.FinancialRatio;
import ration.PERation;

import data.Stock;
import enums.StockType;

public class TestPERation {
	Stock stock;
	Stock stockDividendZero;
	
	@Before
	public void setUp() throws Exception {
		stock = new Stock("GIN", StockType.PREFERRED, 0.5, 0.2, 100.0);
		stockDividendZero = new Stock("GIN", StockType.PREFERRED, 0.0, 0.2, 100.0);
	}
	
	@Test
	public void testCalculateFinancialRatio() {		
		FinancialRatio financialRatio = new PERation(stock,1.0);
		assertEquals(2.0,financialRatio.calculateFinancialRatio(),0.001);
	}
	
	@Test
	public void testCalculateFinancialRatio_DividedByZero(){
		FinancialRatio financialRatio = new PERation(stockDividendZero,10.0);
		assertEquals("divide float by zero should be infinity", true, Double.isInfinite(financialRatio.calculateFinancialRatio()));
		
	}

}
