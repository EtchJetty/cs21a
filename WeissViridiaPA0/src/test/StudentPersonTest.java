/**
* Test file for Person.
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

import main.Person;

class StudentPersonTest {

	@Test
	void test() {
		final Person validator = new Person("Keke", "Spears");
		assertEquals("Keke Spears", validator.toString());

	}

}
