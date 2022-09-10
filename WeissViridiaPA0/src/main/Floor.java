package main;

import java.util.ArrayList;

public class Floor {
	/**
	 * List of people who disembarked at this floor.
	 */
	ArrayList<Person> lastGroup;
	/**
	 * Order of the floor within the greater array.
	 */
	int floorInx;

	/**
	 * A floor. Knows its name, location, and who
	 * 
	 * @param floorInx int index
	 */
	public Floor(int floorInx) {
		this.lastGroup = new ArrayList<Person>();
		this.floorInx = floorInx;
	}

	public boolean enterFloor(Person person) {
		lastGroup.add(person);
		person.rest(this.floorInx);
		return true;
	}

	public String toString() {
		return ("Floor " + this.floorInx + ". Has " + this.lastGroup.size() + " people on it.");
	}
}
