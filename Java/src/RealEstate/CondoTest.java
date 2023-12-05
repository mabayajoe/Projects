package RealEstate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CondoTest {

	@Test
	void testCalculateAppraisalPrice() {
		Condo c1 = new Condo("TheWhiteHouse", 84601, 12.3, 50.0, 4, 2.5, 3, 1);
//		c1.calculateAppraisalPrice();
		Assertions.assertEquals(c1.calculateAppraisalPrice(), 39264);
	}
	
	@Test
	void testCalculateAppraisalPriceFail() {
		Condo c1 = new Condo("TheWhiteHouse", 84601, 12.3, 50.0, 4, 2.5, 3, 1);
//		c1.calculateAppraisalPrice();
		Assertions.assertNotEquals(c1.calculateAppraisalPrice(), 600000);
	}

	@Test
	void testGetFloorLvl() {
		Condo c1 = new Condo("TheWhiteHouse", 84601, 12.3, 50.0, 4, 2.5, 3, 1);
		Assertions.assertEquals(c1.getFloorLvl(), 1);
	}

	@Test
	void testSetFloorLvl() {
		Condo c1 = new Condo("TheWhiteHouse", 84601, 12.3, 50.0, 4, 2.5, 3, 1);
		c1.setFloorLvl(2);
		Assertions.assertEquals(c1.getFloorLvl(), 2);
	}

}
