/**
* Test file for Floor.
* Known Bugs: None
*
* @author Viridia Weiss
* gweiss@brandeis.edu 
* Sep 10, 2022
* COSI 21A PA0 
*/

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Floor;

class StudentFloorTest {

	@Test
	void test() {
		Floor validator = new Floor(2);
		assertEquals("Floor 2. Has 0 people on it.", validator.toString());
	}

}
