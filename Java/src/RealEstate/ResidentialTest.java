package RealEstate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ResidentialTest {

	@Test
	void testCalculateAppraisalPrice() {
		House h1 = new House("TheWhiteHouse", 84601, 12.3, 50.0, 4, 2.5, 3, 1);
		Assertions.assertEquals(h1.calculateAppraisalPrice(), 508291);
	}

	@Test
	void testGetBeds() {
		House h1 = new House("TheWhiteHouse", 84601, 12.3, 50.0, 4, 2.5, 3, 1);
		Assertions.assertEquals(h1.getBeds(), 3);
	}

	@Test
	void testGetBaths() {
		House h1 = new House("TheWhiteHouse", 84601, 12.3, 50.0, 4, 2.5, 3, 1);
		Assertions.assertEquals(h1.getBaths(), 1.5);
	}

	@Test
	void testGetSize() {
		House h1 = new House("TheWhiteHouse", 84601, 12.3, 50.0, 4, 2.5, 3, 1);
		Assertions.assertEquals(h1.getYardAcres(), 1);
	}

	@Test
	void testSetBeds() {
		House h1 = new House("TheWhiteHouse", 84601, 12.3, 50.0, 4, 2.5, 3, 1);
		h1.setBeds(6);
		Assertions.assertEquals(h1.getBeds(), 6);
	}

	@Test
	void testSetBaths() {
		House h1 = new House("TheWhiteHouse", 84601, 12.3, 50.0, 4, 2.5, 3, 1);
		h1.setBaths(2.5);
		Assertions.assertEquals(h1.getBaths(), 2.5);
	}

	@Test
	void testSetSize() {
		House h1 = new House("TheWhiteHouse", 84601, 12.3, 50.0, 4, 2.5, 3, 1);
		h1.setYardAcres(4);
		Assertions.assertEquals(h1.getYardAcres(), 4);
	}

}
