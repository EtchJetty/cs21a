/**
* Person class that stores basic information.
* Known Bugs: None
*
* @author Viridia Weiss
* gweiss@brandeis.edu 
* Sep 10, 2022
* COSI 21A PA0 
*/

package main;

public class Person {
	/**
	 * An int representing a person's floor.
	 */
	private int location;
	/**
	 * First name.
	 */
	String fname;
	/**
	 * Last name.
	 */
	String lname;

	/**
	 * A Person. Contains some functions and a first and last name, as well as a
	 * location.
	 * 
	 * @param fname first name String
	 * @param lname last name String
	 */
	public Person(String firstName, String lastName) {
		this.fname = firstName;
		this.lname = lastName;
	}

	/**
	 * This method will simply call the appropriate method from the Building
	 * instance to enter the elevator and request a job.
	 * 
	 * @param building the building to be entered
	 * @param floor    the floor requested
	 * @return true
	 */
	public boolean enterBuilding(Building building, int floor) {
		if (floor > building.numFloors) {
			throw new IllegalArgumentException("Invalid floor!");
		}
		return building.enterElevatorRequest(this, floor);
	}

	/**
	 * Returns string referencing location.
	 * 
	 * @return either a number, or the string "in lobby"
	 */
	public String getLocation() {
		if (location == 0) {
			return "In lobby";
		}
		return "At floor " + Integer.toString(location);
	}

	/**
	 * A setter for the person's current location.
	 * 
	 * @param floorInx the floor where a person has chosen to rest
	 */
	public void rest(int floorInx) {
		this.location = floorInx;
	}

	public String toString() {
		return (this.fname + " " + this.lname);
	}
}
