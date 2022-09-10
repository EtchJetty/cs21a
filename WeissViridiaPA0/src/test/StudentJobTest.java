/**
* Test file for Job.
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

import main.Job;
import main.Person;

class StudentJobTest {

	@Test
	void test() {
		Job validator = new Job(new Person("Keke", "Spears"), 2);
		assertEquals("Request to go to floor 2 from Keke Spears.", validator.toString());

	}

}
