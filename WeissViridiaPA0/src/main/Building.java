package main;

import java.util.ArrayList;

public class Building {
	/**
	 * An array of floors.
	 */
	ArrayList<Floor> floors;
	/**
	 * An elevator. One per Building.
	 */
	Elevator elevator;
	/**
	 * An array of floors.
	 */
	int numFloors;

	/**
	 * A building. Contains a list of floors and an
	 * elevator.
	 * 
	 * @param mountainString name of the mountain
	 * @throws FileNotFoundException for the file read by the elevator
	 */
	public Building(int numFloors) {
		this.numFloors = numFloors;
		this.elevator = new Elevator(this);
		this.floors = new ArrayList<Floor>();
	}

	/**
	 * This method will process the request made by a person to enter the building.
	 * Then, it should pass on the request to an elevator instance. Make sure that
	 * the
	 * elevator visits the lobby (floor 0) and then the floor requested by the
	 * person.
	 * 
	 * @param person the person that has requested access to the building
	 * @param floor   the number of the desired floor
	 * @return will be true
	 */
	public boolean enterElevatorRequest(Person person, int floor) {
		try {
			floors.get(floor);
		} catch (Exception e) {
			for (int i = floors.size(); i < floor; i++) {
				floors.add(floors.size(), new Floor(i));
			}
			floors.add(0, new Floor(floor));
		}
		return elevator.createJob(person, floor);
	}

	/**
	 * This will call a method in the elevator
	 * instance that should process all current jobs.
	 */
	public void startElevator() {
		elevator.processAllJobs();
	}

	/**
	 * This method should simply access the given floor object and call a method to
	 * save a reference to the person in the given floor.
	 * 
	 * @param person the person to access the floor
	 * @param floor   the floor number to be entered
	 * @return true
	 */
	public boolean enterFloor(Person person, int floor) {
		return floors.get(floor).enterFloor(person);
	}

	public String toString() {
		return ("Building with " + this.numFloors + " floors.");
	}
}
