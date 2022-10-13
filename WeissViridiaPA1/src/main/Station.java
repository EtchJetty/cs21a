/** 
  * Station implimentation
  * Known Bugs: None
  * 
  * @author Viridia Weiss   
  * @email gweiss@brandeis.edu
  * October 9th, 2022
  * COSI 21A PA1  
  */

package main;

public class Station {

	/**
	 * queue for riders waiting to go north
	 *
	 */
	public Queue<Rider> northBoundRiders;
	/**
	 * queue for riders waiting to go south
	 */
	public Queue<Rider> southBoundRiders;
	/**
	 * queue for trains waiting to go north
	 */
	public Queue<Train> northBoundTrains;
	/**
	 * queue for trains waiting to go south
	 */
	public Queue<Train> southBoundTrains;
	private String name;

	public static final int QUEUE_CAPACITY = 20;

	/**
	 * constructs an empty Station with a given name.
	 * O(1)
	 * 
	 * @param name
	 */
	public Station(String name) {
		this.name = name;
		this.northBoundRiders = new Queue<Rider>(QUEUE_CAPACITY);
		this.southBoundRiders = new Queue<Rider>(QUEUE_CAPACITY);
		this.northBoundTrains = new Queue<Train>(QUEUE_CAPACITY);
		this.southBoundTrains = new Queue<Train>(QUEUE_CAPACITY);
	}

	/**
	 * adds a Rider to the appropriate Queue,
	 * depending on the Rider’s direction, as long as they should be in this
	 * Station. Return true if this is
	 * possible and false otherwise. O(1)
	 * 
	 * @param r
	 * @return
	 */
	public boolean addRider(Rider r) {
		if (r.getStarting() == this.name) {
			if (r.goingNorth() && this.northBoundRiders.size() > 0) {
				this.northBoundRiders.enqueue(r);
			} else if (!r.goingNorth() && this.southBoundRiders.size() > 0) {
				this.southBoundRiders.enqueue(r);
			}
			return true;
		}
		return false;

	}

	/**
	 * moves a Train into this Station, removes all of
	 * the passengers who are meant to disembark at this Station, and places the
	 * Train in the
	 * appropriate Queue depending on its direction. This method should return a
	 * String that includes
	 * that some passengers were removed at this Station. For instance, one could
	 * return:
	 * Quincy Adams Disembarking Passengers:
	 * FVPRE0BX09L3OMS2VR87 O(n)
	 * 
	 * @param t
	 * @return
	 */
	public String addTrain(Train t) {
		if (t.goingNorth() && this.northBoundTrains.size() > 0) {
			this.northBoundTrains.enqueue(t);
		} else if (!t.goingNorth() && this.southBoundTrains.size() > 0) {
			this.southBoundTrains.enqueue(t);
		}
		return this.name + " Disembarking Passengers:\n" + t.disembarkPassengers();
	}

	/**
	 * This method will prepare a southbound Train of
	 * passengers by performing the following steps:
	 * 1) Dequeuing a train from the southbound train queue.
	 * 2) Adding as many southbound Riders to the Train as possible.
	 * 3) Return the train that has been filled or null if there are no waiting
	 * southbound
	 * Trains. O(n)
	 * 
	 * @return
	 */
	public Train southBoardTrain() {
		if (this.southBoundTrains.size() > 0) {
			Train deqTrain = this.southBoundTrains.front();
			this.southBoundTrains.dequeue();
			while (deqTrain.hasSpaceForPassengers() && southBoundRiders.size() > 0) {
				Rider r = this.southBoundRiders.front();
				this.southBoundRiders.dequeue();
				deqTrain.addPassenger(r);
			}
			return deqTrain;
		}
		return null;
	}

	/**
	 * This method will prepare a northbound Train of
	 * passengers by performing the following steps:
	 * 1) Dequeuing a train from the northbound train queue.
	 * 2) Adding as many northbound Riders to the Train as possible.
	 * 3) Return the train that has been filled or null if there are no waiting
	 * northbound
	 * Trains. O(n)
	 * 
	 * @return
	 */
	public Train northBoardTrain() {
		if (this.northBoundTrains.size() > 0) {
			Train deqTrain = this.northBoundTrains.front();
			this.northBoundTrains.dequeue();
			while (deqTrain.hasSpaceForPassengers() && northBoundRiders.size() > 0) {
				Rider r = this.northBoundRiders.front();
				this.northBoundRiders.dequeue();
				deqTrain.addPassenger(r);
			}
			return deqTrain;
		}
		return null;
	}

	/**
	 * changes the direction of the first waiting
	 * northbound Train and moves it to the southbound queue. You may assume that
	 * the Train will not
	 * have any Riders. O(1)
	 * 
	 */
	public void moveTrainNorthToSouth() {
		if (this.southBoundTrains.size() < QUEUE_CAPACITY && this.northBoundTrains.size() > 0) {
			Train deqTrain = this.northBoundTrains.front();
			deqTrain.swapDirection();
			this.northBoundTrains.dequeue();
			this.southBoundTrains.enqueue(deqTrain);
		}
	}

	/**
	 * changes the direction of the first waiting
	 * southbound Train and moves it to the northbound queue. You may assume that
	 * the Train will not
	 * have any Riders. O(1)
	 * 
	 */
	public void moveTrainSouthToNorth() {
		if (this.northBoundTrains.size() < QUEUE_CAPACITY && this.southBoundTrains.size() > 0) {
			Train deqTrain = this.southBoundTrains.front();
			deqTrain.swapDirection();
			this.southBoundTrains.dequeue();
			this.northBoundTrains.enqueue(deqTrain);
		}
	}

	/**
	 * this should return the name and status of the station. For
	 * instance, one could return:
	 * Station: Alewife
	 * 1 north-bound trains waiting
	 * 0 south-bound trains waiting
	 * 0 north-bound passengers waiting
	 * 1 south-bound passengers waiting O(1)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Station: " + this.name + "\n" + this.northBoundTrains.size() + " north-bound trains waiting\n"
				+ this.southBoundTrains.size() + " south-bound trains waiting\n" + this.northBoundRiders.size()
				+ " north-bound passengers waiting\n" + this.southBoundRiders.size()
				+ " south-bound passengers waiting\n";
	}

	/**
	 * returns the name of this Station O(1)
	 * 
	 * @return
	 */
	public String stationName() {
		return this.name;
	}

	/**
	 * Checks if a Station is equal to some object
	 * based on name. O(1)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Station)) {
			return false;
		}
		Station r = (Station) o;
		return (this.name == r.stationName());

	}
}
