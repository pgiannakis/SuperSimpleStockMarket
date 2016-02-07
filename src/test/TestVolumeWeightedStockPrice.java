package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import ration.VolumeWeightedStockPrice;

import data.Trade;
import enums.Indicator;

public class TestVolumeWeightedStockPrice {
	private VolumeWeightedStockPrice volumeWeightedStockPrice;
	
	@Before
	public void setUp() throws Exception {
		final Date now = new Date();
		ArrayList<Trade> trade = new ArrayList<Trade>(){{
			//Date one day ago
			add(new Trade(new Date(now.getTime() - (24*60 * 60 * 1000)),20,Indicator.SELL,8.003434783282986));
			//Date 16 minutes ago
			add(new Trade(new Date(now.getTime() - (16 * 60 * 1000)),5,Indicator.SELL,3.138997799897384));
			//Date 15 minutes ago
			add(new Trade(new Date(now.getTime() - (15 * 60 * 1000)),20,Indicator.SELL,5.68783480389047));
			//Date 12 minutes ago
			add(new Trade(new Date(now.getTime() - (12 * 60 * 1000)),1,Indicator.SELL,3.6322959689680103));
			//Date 10 minutes ago
			add(new Trade(new Date(now.getTime() - (10 * 60 * 1000)),2,Indicator.BUY,5.24320252063261));
			//Date 7 minutes ago
			add(new Trade(new Date(now.getTime() - (7 * 60 * 1000)),15,Indicator.BUY,7.990952445305443));
			//Date 5 minutes ago
			add(new Trade(new Date(now.getTime() - (5 * 60 * 1000)),11,Indicator.SELL,3.3371709354554846));
			//Date 3 minutes ago
			add(new Trade(new Date(now.getTime() - (3 * 60 * 1000)),9,Indicator.BUY,6.898056955896807));
			//Date 1 minutes ago
			add(new Trade(new Date(now.getTime() - (1 * 60 * 1000)),7,Indicator.SELL,8.393106117875732));
			}};
			
			volumeWeightedStockPrice = new VolumeWeightedStockPrice(trade);

	}
	
	@Test
	public void testCalculateFinancialRatio(){
		assertEquals(6.235120299782094,volumeWeightedStockPrice.calculateFinancialRatio(),0.001);
	}
	
	@Test
	public void isInPast15Min_lessThan15Min_true(){
		Date currentDate = new Date();
		Date before5Min = new Date(currentDate.getTime() - (5 * 60 * 1000));
		assertEquals(true,volumeWeightedStockPrice.isInPast15Min(currentDate, before5Min));
	}
	
	@Test
	public void isInPast15Min_MoreThan15Min_false(){
		Date currentDate = new Date();
		Date before16Min = new Date(currentDate.getTime() - (16 * 60 * 1000));
		assertEquals(false,volumeWeightedStockPrice.isInPast15Min(currentDate, before16Min));
	}
	
	@Test
	public void isInPast15Min_EqualTo15Min_true(){
		Date currentDate = new Date();
		Date before15Min = new Date(currentDate.getTime() - (15 * 60 * 1000));
		assertEquals(true,volumeWeightedStockPrice.isInPast15Min(currentDate, before15Min));
	}

}
