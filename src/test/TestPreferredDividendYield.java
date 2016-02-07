package test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import ration.CommonDividendYield;
import ration.FinancialRatio;
import ration.PreferredDividendYield;

import data.Stock;
import enums.StockType;

public class TestPreferredDividendYield {
	Stock stock;
	
	@Before
	public void setUp() throws Exception {
		stock = new Stock("GIN", StockType.PREFERRED, 8.0, (double)2/100, 100.0);
	}

	@Test
	public void testCalculateFinancialRatio() {		
		FinancialRatio financialRatio = new PreferredDividendYield(stock,1.0);
		assertEquals(2.0,financialRatio.calculateFinancialRatio(),0.001);
	}
	
	@Test
	public void testCalculateFinancialRatio_DividedByZero(){
		FinancialRatio financialRatio = new CommonDividendYield(stock,0.0);
		assertEquals("divide float by zero should be infinity", true, Double.isInfinite(financialRatio.calculateFinancialRatio()));
		
	}

}
