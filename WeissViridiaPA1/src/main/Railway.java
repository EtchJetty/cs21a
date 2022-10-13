package main;

public class Railway {

	/**
	 * a list of the Railway’s Stations.
	 */
	public DoubleLinkedList<Station> railway;
	/**
	 * the names of the Stations on the Railway. This
	 * will contain a maximum of 18 entries corresponding to the 18 stations listed
	 * in redLine.txt.
	 *
	 */
	public String[] stationNames;
	private static final int MAX_STATIONS = 18;

	/**
	 * constructs an empty Railway. O(1)
	 */
	public Railway() {
		this.railway = new DoubleLinkedList<Station>();
		this.stationNames = new String[MAX_STATIONS];
	}

	/**
	 * adds a Station to the Railway. O(n)
	 * 
	 * @param s
	 */
	public void addStation(Station s) {
		this.railway.insert(s);
		this.stationNames[this.railway.size()] = s.stationName();
	}

	/**
	 * – (i) sets a Rider’s direction based on the order of
	 * the Stations in the Railway and (ii) adds the Rider to the appropriate
	 * Station in the Railway.
	 * 
	 * @param r
	 */
	public void addRider(Rider r) {

	}

	/**
	 * adds a Train to the appropriate Station in this
	 * Railway.
	 * 
	 * @param t
	 */
	public void addTrain(Train t) {

	}

	/**
	 * sets a Rider’s direction based on
	 * the Rider’s starting and ending Stations.
	 * 
	 * @param r
	 */
	public void setRiderDirection(Rider r) {

	}

	/**
	 * This method will execute one simulation of the Railway.
	 * You should log the events that occur in the process of your simulation such
	 * as the status of each
	 * Station, where Trains and Riders are, and when Riders exit a Train. This log
	 * should be returned
	 * by this method for use in the main class MBTA.java.
	 * 
	 * During this method, you should traverse the Stations in the Railway north to
	 * south and perform
	 * the following steps at each Station in this order:
	 * 1. Board a (southbound/northbound) train with as many passengers as possible
	 * unless the
	 * Station is (Braintree/Alewife).
	 * 2. Move the boarded trains to their next Stations.
	 * 3. Disembark any passengers who are meant to get off at the Stations that the
	 * trains were
	 * moved to.
	 * 4. If the current Station is (Braintree/Alewife) then you should move a
	 * (southbound train to
	 * go north/northbound train to go south).
	 * 
	 * Note: you should never have a train switch direction and move from that
	 * Station in a single call
	 * to this method.
	 * 
	 * @return
	 */
	public String simulate() {
		return null;
	}

	/**
	 * – returns the Stations list’s String representation.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return null;
	}
}
