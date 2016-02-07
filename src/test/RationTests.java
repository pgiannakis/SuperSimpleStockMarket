package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ TestCommonDividendYield.class, TestGBCE.class,
		TestPERation.class, TestPreferredDividendYield.class,
		TestVolumeWeightedStockPrice.class })
public class RationTests {

}
