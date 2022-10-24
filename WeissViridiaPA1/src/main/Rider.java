/** 
  * Rider implimentation
  * Known Bugs: None
  * 
  * @author Viridia Weiss   
  * @email gweiss@brandeis.edu
  * October 9th, 2022
  * COSI 21A PA1  
  */

package main;

public class Rider {

	private String riderID;
	private String destinationStation;
	private String startingStation;
	private boolean direction;

	/**
	 * this should construct a Rider with an ID as well as starting and
	 * ending stations. A Rider must start by travelling south. You may assume that
	 * a Rider will be
	 * travelling at least 1 Station. O(1)
	 * 
	 * @param riderID
	 * @param startingStation
	 * @param destinationStation
	 */
	public Rider(String riderID, String startingStation, String destinationStation) {
		this.riderID = riderID;
		this.startingStation = startingStation;
		this.destinationStation = destinationStation;
		this.direction = false;
	}

	/**
	 * @return returns the name of this Rider’s starting station. O(1)
	 */
	public String getStarting() {
		return this.startingStation;
	}

	/**
	 * @return returns the name of this Rider’s ending station. O(1)
	 */
	public String getDestination() {
		return this.destinationStation;
	}

	/**
	 * @return returns this Rider’s ID. O(1)
	 */
	public String getRiderID() {
		return this.riderID;
	}

	/**
	 * @return returns true if this Rider is northbound. Else, false. O(1)
	 */
	public boolean goingNorth() {
		return this.direction;
	}

	/**
	 * swaps the Rider’s current direction. O(1)
	 */
	public void swapDirection() {
		this.direction = !this.direction;
	}

	/**
	 * returns a String representation of this Rider.
	 * O(1)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.join("", this.riderID, ", ", this.destinationStation);
	}

	/**
	 * checks if this Rider is equal to another Object
	 * based on ID.
	 * O(1)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object s) {
		if (!(s instanceof Rider)) {
			return false;
		}
		Rider o = (Rider) s;
		return (this.riderID.equals(o.getRiderID()));
	}
}
