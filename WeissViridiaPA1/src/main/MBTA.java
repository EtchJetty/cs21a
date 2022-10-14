/** 
  * MBTA implimentation
  * Known Bugs: None
  * 
  * @author Viridia Weiss   
  * @email gweiss@brandeis.edu
  * October 9th, 2022
  * COSI 21A PA1  
  */

package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MBTA {

	/**
	 * value of the southbound direction (1).
	 *
	 */
	public static final int SOUTHBOUND = 1;
	/**
	 * value of the northbound direction (0).
	 */
	public static final int NORTHBOUND = 0;

	/**
	 * the number of times you will run Railway’s simulate()
	 * in the method below runSimulation()
	 */
	static final int TIMES = 6;
	/**
	 * the Railway that will be used in the simulation.
	 */
	static Railway r;

	/**
	 * The main method should construct
	 * the Railway with the Stations, Riders, and Trains loaded from the provided
	 * text files and then run
	 * the simulation. O(n^3)
	 *
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		r = new Railway();
		initStations("redLine.txt");
		initTrains("trains.txt");
		initRiders("riders.txt");
		runSimulation();
	}

	/**
	 * – This method runs the simulation using
	 * TIMES and Railway’s simulate(). O(n^3)
	 */
	public static void runSimulation() {
		System.out.println("INITIATED RED LINE\n");
		Node<Station> testNode = r.railway.getFirst();
		String s = "";
		for (int i = 0; i < r.railway.size(); i++) {
			s = s + testNode.getData().toString() + "\n";
			testNode = testNode.getNext();
		}
		System.out.print(s);
		System.out.println("BEGINNING RED LINE SIMULATION\n");
		for (int i = 0; i < TIMES; i++) {
			System.out.println("------ " + (i + 1) + " ------\n");
			System.out.println(r.simulate());

		}
	}

	/**
	 * ) - constructs Trains
	 * from an input file and adds them to the Railway. O(n)
	 * 
	 * @param trainsFile
	 * @throws FileNotFoundException
	 */
	public static void initTrains(String trainsFile) throws FileNotFoundException {
		try (Scanner console = new Scanner(new File(trainsFile))) {
			while (console.hasNext()) {
				r.addTrain(new Train(console.nextLine(), Integer.parseInt(console.nextLine())));
			}
		}

	}

	/**
	 * constructs Riders
	 * from an input file and adds them to the Railway. O(n)
	 * 
	 * @param ridersFile
	 * @throws FileNotFoundException
	 */
	public static void initRiders(String ridersFile) throws FileNotFoundException {
		try (Scanner console = new Scanner(new File(ridersFile))) {
			while (console.hasNext()) {
				r.addRider(new Rider(console.nextLine(), console.nextLine(), console.nextLine()));
			}
		}
	}

	/**
	 * - constructs
	 * Stations from an input file and adds them to the Railway. O(n)
	 * 
	 * @param stationsFile
	 * @throws FileNotFoundException
	 */
	public static void initStations(String stationsFile) throws FileNotFoundException {
		try (Scanner console = new Scanner(new File(stationsFile))) {
			while (console.hasNext()) {
				r.addStation(new Station(console.nextLine()));
			}
		}
	}
}
