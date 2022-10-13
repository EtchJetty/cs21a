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

	/**
	 * constructs an empty Station with a given name.
	 * 
	 * @param name
	 */
	public Station(String name) {
		this.name = name;
		this.northBoundRiders = new Queue<Rider>(0);
		this.southBoundRiders = new Queue<Rider>(0);
		this.northBoundTrains = new Queue<Train>(0);
		this.southBoundTrains = new Queue<Train>(0);
	}

	/**
	 * adds a Rider to the appropriate Queue,
	 * depending on the Rider’s direction, as long as they should be in this
	 * Station. Return true if this is
	 * possible and false otherwise.
	 * 
	 * @param r
	 * @return
	 */
	public boolean addRider(Rider r) {
		if (r.getStarting() == this.name) {
			if (r.goingNorth()) {
				this.northBoundRiders.enqueue(r);
			} else {
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
	 * FVPRE0BX09L3OMS2VR87
	 * 
	 * @param t
	 * @return
	 */
	public String addTrain(Train t) {
		if (t.goingNorth()) {
			this.northBoundTrains.enqueue(t);
		} else {
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
	 * Trains.
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
	 * Trains.
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
	 * have any Riders.
	 * 
	 */
	public void moveTrainNorthToSouth() {
		Train deqTrain = this.northBoundTrains.front();
		this.northBoundTrains.dequeue();
		this.southBoundTrains.enqueue(deqTrain);
	}

	/**
	 * changes the direction of the first waiting
	 * southbound Train and moves it to the northbound queue. You may assume that
	 * the Train will not
	 * have any Riders.
	 * 
	 */
	public void moveTrainSouthToNorth() {
		Train deqTrain = this.southBoundTrains.front();
		this.southBoundTrains.dequeue();
		this.northBoundTrains.enqueue(deqTrain);
	}

	/**
	 * this should return the name and status of the station. For
	 * instance, one could return:
	 * Station: Alewife
	 * 1 north-bound trains waiting
	 * 0 south-bound trains waiting
	 * 0 north-bound passengers waiting
	 * 1 south-bound passengers waiting
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
	 * returns the name of this Station
	 * 
	 * @return
	 */
	public String stationName() {
		return null;
	}

	/**
	 * Checks if a Station is equal to some object
	 * based on name.
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		return false;
	}
}
