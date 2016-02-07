/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ration.CommonDividendYield;
import ration.FinancialRatio;
import data.Stock;
import enums.StockType;

public class TestCommonDividendYield {
	Stock stock;
	
	@Before
	public void setUp() throws Exception {
		stock = new Stock("POP", StockType.COMMON, 8.0, 0.0, 100.0);
	}
	
	@Test
	public void testCalculateFinancialRatio() {		
		FinancialRatio financialRatio = new CommonDividendYield(stock,1.0);
		assertEquals(8.0,financialRatio.calculateFinancialRatio(),0.001);
	}
	
	@Test
	public void testCalculateFinancialRatio_DividedByZero(){
		FinancialRatio financialRatio = new CommonDividendYield(stock,0.0);
		assertEquals("divide float by zero should be infinity", true, Double.isInfinite(financialRatio.calculateFinancialRatio()));
		
	}

}
