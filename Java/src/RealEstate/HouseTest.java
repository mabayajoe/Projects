package RealEstate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HouseTest {

	@Test
	void testCalculateAppraisalPrice() {
		House h1 = new House("TheWhiteHouse", 84601, 12.3, 50.0, 4, 2.5, 3, 1);
//		h1.calculateAppraisalPrice();
		Assertions.assertEquals(h1.calculateAppraisalPrice(), 508291);
	}
	
	@Test
	void testCalculateAppraisalPriceFail() {
		House h1 = new House("TheWhiteHouse", 84601, 12.3, 50.0, 4, 2.5, 3, 1);
		Assertions.assertNotEquals(h1.calculateAppraisalPrice(), 600000);
	}

	@Test
	void testGetYardAcres() {
		House h1 = new House("TheWhiteHouse", 84601, 12.3, 50.0, 4, 2.5, 3, 1);
		Assertions.assertEquals(h1.getYardAcres(), 1);
	}

	@Test
	void testSetYardAcres() {
		House h1 = new House("TheWhiteHouse", 84601, 12.3, 50.0, 4, 2.5, 3, 1);
		h1.setYardAcres(4);
		Assertions.assertEquals(h1.getYardAcres(), 4);
	}

}
