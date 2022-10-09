package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Rider;

class StudentRiderTest {

	Rider r;
	
	@Test
	void initTest() {
		r = new Rider("abc123", "Alewife", "Braintree");
		
		assertEquals("abc123", r.getRiderID());
		assertEquals("Alewife", r.getStarting());
		assertEquals("Braintree", r.getDestination());
		assertFalse(r.goingNorth());

	}
	
	@Test
	void testEquals() {
		r = new Rider("abc123", "Alewife", "Braintree");
		Rider r1 = new Rider("abc123", "a", "b");
		assertEquals(r1, r);
	}
	
	

}
