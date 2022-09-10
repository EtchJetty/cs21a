package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This class should contain a main method, where you simulate the
 * building. You should instantiate a building, and several person instances.
 * Then you should simulate two different groups of people, arriving at
 * different times, and requesting to use the drone. One of the groups should be
 * larger than the capacity of what the drone can handle in one batch. Print the
 * state of the building/drone/people’s locations in order to show what is going
 * on in the building as the drone operates. This is so the user can tell what
 * is going on.
 */
public class Simulation {
	/**
	 * Number of floors.
	 */
	private static final int NUM_FLOORS = 7;

	/**
	 * Generates a building and fills it with people, then does it again.
	 * 
	 * @param args none
	 * @throws FileNotFoundException building generates floors based on a file
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Building krillington = new Building(NUM_FLOORS);
		Person person1 = new Person("jimmy", "schmid");
		Person person2 = new Person("Chuck", "Critikal");
		Person person3 = new Person("Nona", "Pierce");
		person1.enterBuilding(krillington, 3);
		person2.enterBuilding(krillington, 3);
		person3.enterBuilding(krillington, 3);
		krillington.startElevator();
		Person person4 = new Person("Blither", "Snmoter");
		person4.enterBuilding(krillington, 7);
		krillington.startElevator();
		Person person5 = new Person("Smoop", "Snbeegler");
		Person person6 = new Person("Spleoreras", "Fglgort");
		person5.enterBuilding(krillington, 2);
		person6.enterBuilding(krillington, 1);
		krillington.startElevator();

		// makePeople();
		// ArrayList<Person> guests = loopPeople(5);
		// generateAll(guests, krillington);
		// krillington.startElevator();

		// ArrayList<Person> guests2 = loopPeople(1);
		// generateAll(guests2, krillington);
		// krillington.startElevator();

		// ArrayList<Person> guests3 = loopPeople(3);
		// generateAll(guests3, krillington);
		// krillington.startElevator();

		// ArrayList<Person> guests4 = loopPeople(23); // this is where the list of
		// names tops out!
		// generateAll(guests4, krillington);
		// krillington.startElevator();
	}

	/**
	 * ArrayList of Strings used for first names.
	 */
	private static ArrayList<String> fnameList;
	/**
	 * ArrayList of Strings used for last names.
	 */
	private static ArrayList<String> lnameList;
	/**
	 * Random instance.
	 */
	private static Random rand = new Random();

	/**
	 * Reads first and last name info from a file and writes them to fnameList and
	 * lnameList. Run this once before running loopPeople.
	 * 
	 * @throws FileNotFoundException reads a file
	 */
	private static void makePeople() throws FileNotFoundException {
		fnameList = new ArrayList<String>();
		lnameList = new ArrayList<String>();
		Scanner namefile = new Scanner(new File("names.txt"));
		while (namefile.hasNextLine()) {
			fnameList.add(namefile.next());
			lnameList.add(namefile.next());
		}
		namefile.close();
	}

	/**
	 * Function that randomly generates lNum number of guests with unique first and
	 * last names.
	 * 
	 * @param lNum how many people to create
	 * @return an ArrayList of people
	 */
	private static ArrayList<Person> loopPeople(int lNum) {
		ArrayList<Person> guests = new ArrayList<Person>();

		for (int i = 0; i < lNum; i++) {
			String fname = fnameList.get(rand.nextInt(fnameList.size()));
			String lname = lnameList.get(rand.nextInt(lnameList.size()));
			guests.add(new Person(fname, lname));
			fnameList.remove(fname); // to ensure uniqueness
			fnameList.remove(lname);
		}

		return guests;
	}

	/**
	 * Function that randomly generates a desired floor for each guest in guests,
	 * and
	 * assigns that job to the elevator.
	 * 
	 * @param guests      arraylist of Person objects
	 * @param krillington Building object
	 */
	private static void generateAll(ArrayList<Person> guests, Building krillington) {
		for (int i = 0; i < guests.size(); i++) {
			guests.get(i).enterBuilding(krillington, rand.nextInt(NUM_FLOORS) + 1);
		}
		// System.out.printf("----------\nSuccessfully initialized %d guests.\n",
		// guests.size());
	}
}
