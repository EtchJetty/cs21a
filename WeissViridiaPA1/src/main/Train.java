/** 
  * Train implimentation
  * Known Bugs: None
  * 
  * @author Viridia Weiss   
  * @email gweiss@brandeis.edu
  * October 9th, 2022
  * COSI 21A PA1  
  */

package main;

public class Train {

	/**
	 * the # of passengers that the train
	 * can hold, the default is 10 passengers
	 *
	 */
	public static final int TOTAL_PASSENGERS = 10;
	/**
	 * the Train’s passengers.
	 *
	 * 
	 */
	public Rider[] passengers;
	/**
	 * tracks the number of passengers currently in the Train.
	 */
	public int passengerIndex;
	private String currentStation;
	private boolean direction;
	// public String disembarkString;

	/**
	 * constructs an
	 * empty Train at a given Station going either south (1) or north (0). O(1)
	 * 
	 * @param currentStation
	 * @param direction
	 */
	public Train(String currentStation, int direction) {
		this.currentStation = currentStation;
		this.direction = (direction == 0); // true is north
		this.passengers = new Rider[TOTAL_PASSENGERS];
	}

	/**
	 * returns true if this Train is northbound. Else, return
	 * false. O(1)
	 * 
	 * @return
	 */
	public boolean goingNorth() {
		return this.direction;
	}

	/**
	 * swaps the Train’s direction. O(1)
	 * 
	 */
	public void swapDirection() {
		this.direction = !(this.direction);
	}

	/**
	 * returns a String of the current passengers
	 * on the Train. For instance, one could
	 * return:
	 * 
	 * <p>
	 * <code> 7SG7IE6K7J7TZLHCHTZW, Porter</code>
	 * </p>
	 * <p>
	 * <code>0W3E3HYLZ67MQCA6ACQ8, Porter</code>
	 * </p>
	 * <p>
	 * <code>3A56AC65CK7D12UCE55Y, Porter</code>
	 * </p>
	 * O(n)
	 * 
	 * @return
	 */
	public String currentPassengers() {
		String s = "";
		for (int i = 0; i < passengers.length; i++) {
			if (passengers[i] != null) {
				s = String.join("", s, passengers[i].toString(), "\n");
			}
		}
		return s;
	}

	/**
	 * adds a passenger to the Train as long
	 * as (i) the Rider is at the correct Station to enter the Train, (ii) the Train
	 * is going in the appropriate
	 * direction, and (iii) there is space on the Train. Return true if the addition
	 * was completed. Else,
	 * return false. O(1)
	 * 
	 * @param r
	 * @return
	 */
	public boolean addPassenger(Rider r) {
		if ((this.currentStation.equals(r.getStarting())) && (this.goingNorth() == r.goingNorth())
				&& (this.hasSpaceForPassengers())) {
			this.passengers[this.passengerIndex] = r;
			this.passengerIndex++;
			return true;
		}
		return false;
	}

	/**
	 * returns true if the Train has space
	 * for additional passengers. O(1)
	 * 
	 * @return
	 */
	public boolean hasSpaceForPassengers() {
		return (this.passengerIndex < TOTAL_PASSENGERS);
	}

	/**
	 * This should remove all of the
	 * passengers who should be exiting the Train at the Train’s current station. It
	 * should also return a
	 * String of the removed passengers. For instance, one could return:
	 * <p>
	 * <code> 7SG7IE6K7J7TZLHCHTZW, Porter</code>
	 * </p>
	 * <p>
	 * <code>0W3E3HYLZ67MQCA6ACQ8, Porter</code>
	 * </p>
	 * <p>
	 * <code>3A56AC65CK7D12UCE55Y, Porter</code>
	 * </p>
	 * If there are no passengers to remove, return an empty String. O(n)
	 * 
	 * @return
	 */
	public String disembarkPassengers() {

		String disembarkString = "";
		int tempMax = this.passengerIndex;
		Rider[] passengersTemp = new Rider[10];
		for (int i = 0, tempInx = 0; i < tempMax; i++) {
			if (this.passengers[i].getDestination().equals(this.currentStation)) {

				disembarkString = String.join("", disembarkString, this.passengers[i].getRiderID(), "\n");
				this.passengers[i] = null;
				this.passengerIndex--;
			} else {
				passengersTemp[tempInx] = this.passengers[i];
				tempInx++;
			}
		}

		this.passengers = passengersTemp;
		return disembarkString;
	}

	/**
	 * Updates the name of this Train’s current
	 * station to be the name of another station. O(1)
	 * 
	 * @param s
	 */
	public void updateStation(String s) {
		this.currentStation = s;
	}

	/**
	 * returns the name of the Train’s current Station.
	 * O(1)
	 * 
	 * @return
	 */
	public String getStation() {
		return this.currentStation;
	}

	/**
	 * returns a String representation of this Train.
	 * O(n)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String directionString = this.goingNorth() ? "North" : "South";

		return String.join("", "Direction: ", directionString, "bound\nPassengers:\n", this.currentPassengers(),
				"Current station: ", this.currentStation);
	}
}
