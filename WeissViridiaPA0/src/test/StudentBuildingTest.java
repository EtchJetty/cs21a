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

class StudentBuildingTest {

	@Test
	public void BuildingTest(){
	
		Building validator = new Building(2);
		assertEquals("Building with 2 floors.", validator.toString());

	}
}
