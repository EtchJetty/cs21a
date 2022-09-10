/**
* Test file for Building.
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

import main.Building;
import main.Elevator;

class StudentElevatorTest {

	@Test
	public void test() {

		Elevator validator = new Elevator(new Building(2));
		assertEquals("Elevator with a max of 3 occupants, with 0 passengers.", validator.toString());
		validator.createJob(null, 2);
		assertEquals("Elevator with a max of 3 occupants, with 1 passengers.", validator.toString());
		validator.processJob(validator.getJobs().get(0));
	}

}
