package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import main.AssignmentRationCalculator;
import main.RationCalculator;

import org.junit.Before;
import org.junit.Test;

import data.Stock;
import data.StockAndTrade;
import data.Trade;
import enums.Indicator;
import enums.StockType;

public class TestAssignmentRationCalculator {
	ArrayList<StockAndTrade> stockAndTradeArray;
	AssignmentRationCalculator assignmentRationCalculator;
	@Before
	public void setUp() throws Exception {
		stockAndTradeArray = new ArrayList <StockAndTrade>(){{
		add(new StockAndTrade(new Stock("TEA", StockType.COMMON, 0.0, 0.0, 100.0),
				new ArrayList<Trade>(){{
			add(new Trade(new Date(),2,Indicator.SELL,8.003434783282986));
			add(new Trade(new Date(),8,Indicator.SELL,3.138997799897384));
			add(new Trade(new Date(),1,Indicator.SELL,5.68783480389047));
			add(new Trade(new Date(),5,Indicator.SELL,3.6322959689680103));
			add(new Trade(new Date(),20,Indicator.BUY,5.24320252063261));
			add(new Trade(new Date(),6,Indicator.BUY,7.990952445305443));
			add(new Trade(new Date(),7,Indicator.SELL,3.3371709354554846));
			add(new Trade(new Date(),12,Indicator.BUY,6.898056955896807));
			add(new Trade(new Date(),20,Indicator.SELL,8.393106117875732));
			}}));
		
		add(new StockAndTrade(new Stock("POP", StockType.COMMON, 8.0, 0.0, 100.0),
			new ArrayList<Trade>(){{
				add(new Trade(new Date(),10,Indicator.SELL,	6.898056783282986));
				add(new Trade(new Date(),15,Indicator.SELL,	5.243297799897384));
				add(new Trade(new Date(),6,Indicator.SELL,	5.68783480389047));
				add(new Trade(new Date(),2,Indicator.BUY,	3.6322959689680103));
				add(new Trade(new Date(),9,Indicator.BUY,	5.24320252063261));
				add(new Trade(new Date(),5,Indicator.SELL,	1.284562445305443));
				add(new Trade(new Date(),15,Indicator.SELL,	6.89805354554846));
				add(new Trade(new Date(),9,Indicator.BUY,	6.898056955896807));
				add(new Trade(new Date(),8,Indicator.BUY,	5.6878348117875732));
			}}));
		
		add(new StockAndTrade(new Stock("ALE", StockType.COMMON, 23.0,0.0,60.0),
				new ArrayList<Trade>(){{
					add(new Trade(new Date(),10,Indicator.BUY,	9.24320252063261));
					add(new Trade(new Date(),15,Indicator.BUY,	6.89805354554846));
					add(new Trade(new Date(),6,Indicator.BUY,	5.68789580389047));
					add(new Trade(new Date(),2,Indicator.BUY,	1.284562585305443));
					add(new Trade(new Date(),9,Indicator.BUY,	6.26405369754846));
					add(new Trade(new Date(),5,Indicator.SELL,	1.284562445305443));
					add(new Trade(new Date(),15,Indicator.SELL,	5.5287348163475732));
					add(new Trade(new Date(),9,Indicator.BUY,	6.898056955896807));
					add(new Trade(new Date(),8,Indicator.BUY,	5.6878348117875732));
				}}));
		
		add(new StockAndTrade(new Stock("GIN", StockType.PREFERRED, 8.0, 0.2, 100.0),
				new ArrayList<Trade>(){{
					add(new Trade(new Date(),5,Indicator.BUY,	3.6322959689680103));
					add(new Trade(new Date(),12,Indicator.BUY,	1.284562445305443));
					add(new Trade(new Date(),18,Indicator.SELL,	5.68783480389047));
					add(new Trade(new Date(),9,Indicator.SELL,	6.8980569689680103));
					add(new Trade(new Date(),3,Indicator.SELL,	5.24320252063261));
					add(new Trade(new Date(),4,Indicator.SELL,	3.337170935405443));
					add(new Trade(new Date(),9,Indicator.BUY,	6.89805354554846));
					add(new Trade(new Date(),20,Indicator.SELL,	5.156789423696807));
					add(new Trade(new Date(),7,Indicator.BUY,	5.6878348117875732));
				}}));
		
		add(new StockAndTrade(new Stock("JOE", StockType.COMMON, 13.0, 0.0, 250.0),
				new ArrayList<Trade>(){{
					add(new Trade(new Date(),20,Indicator.SELL,7.987892598723214));
					add(new Trade(new Date(),5,Indicator.SELL,1.259874569874852));
					add(new Trade(new Date(),20,Indicator.SELL,6.265897458123598));
					add(new Trade(new Date(),1,Indicator.SELL,5.987486325417894));
					add(new Trade(new Date(),2,Indicator.BUY,8.326598745812358));
					add(new Trade(new Date(),15,Indicator.BUY,3.5789456897412587));
					add(new Trade(new Date(),11,Indicator.SELL,6.257894569874214));
					add(new Trade(new Date(),9,Indicator.BUY,3.3698745895412358));
					add(new Trade(new Date(),7,Indicator.SELL,4.258796541236578));
				}}));
		}};
		assignmentRationCalculator = new AssignmentRationCalculator(stockAndTradeArray,10);
		
	}
	
	@Test
	public void testIsCommon_True() {
		assertEquals(true,assignmentRationCalculator.isCommon(stockAndTradeArray.get(0).getStock()) );
	}

	@Test
	public void testIsCommon_False() {
		assertEquals(false,assignmentRationCalculator.isCommon(stockAndTradeArray.get(3).getStock()) );
	}
}
