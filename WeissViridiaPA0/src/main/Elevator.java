/**
* Elevator object. Contains most of the processing code.
* Known Bugs: None
*
* @author Viridia Weiss
* gweiss@brandeis.edu 
* Sep 10, 2022
* COSI 21A PA0 
*/

package main;

import java.util.ArrayList;

public class Elevator {
	/**
	 * A list of Jobs (as an array), where each Job
	 * represents a person and the floor to which they desire to go.
	 */
	private ArrayList<Job> jobs = new ArrayList<Job>();

	/**
	 * The number corresponding to the current location the elevator is at.
	 */
	int location;
	/**
	 * A reference to a building instance that a Person is in.
	 */
	Building building;
	/**
	 * This specifies the number of people that can be brought to their floors by an
	 * Elevator
	 * instance at any given time.
	 * <p>
	 * DO NOT REMOVE THIS FIELD
	 * </p>
	 * <p>
	 * You may edit it. But keep it public.
	 * </p>
	 */
	public static int maxOccupants = 3;

	public Elevator(Building building) {
		this.building = building;
		this.location = 0;
	}

	/** Getter and setter. */
	public ArrayList<Job> getJobs() {
		return jobs;
	}

	/** Getter and setter. */
	public void setJobs(ArrayList<Job> jobs) {
		this.jobs = jobs;
	}

	/**
	 * This method should simply add, in the right place, a new job to be completed
	 * by the elevator.
	 * 
	 * @param person the person that requested the elevator
	 * @param floor  the desired floor number
	 * @return will be true
	 */
	public boolean createJob(Person person, int floor) {
		return getJobs().add(new Job(person, floor));
	}

	/**
	 * This method should remove
	 * jobs one by one (in the right order) and process them individually.
	 * 
	 */
	public void processAllJobs() {
		// cleanUpJobs();
		createJob(null, 0);
		for (int i = 0; i < getJobs().size(); i++) {
			processJob(getJobs().get(i));
			getJobs().remove(getJobs().get(i));
			--i;
		}
	}

	/**
	 * This method should
	 * process a job, and move the elevator floor by floor (while printing updates)
	 * in
	 * order to reach the desired floor. Then, the exit method should be called,
	 * simulating the exit of a person (if necessary).
	 * 
	 * @param job the job to be processed
	 * @return boolean
	 */
	public boolean processJob(Job job) {
		if (job.caller == null) {
			System.out.printf("Elevator at floor %d\n",
					this.location);
			for (int iy = this.location - 1; iy > 0; iy--) {
				System.out.printf("Elevator at floor %d\n",
						iy);

			}
			System.out.printf("Elevator at Lobby\n");
			this.location = 0;
			return true;
		} else if (job.destination <= this.location) {
			for (int i = this.location; i >= job.destination; i--) {

				if (i == job.destination) {
					System.out.printf("Elevator at floor %d\n",
							this.location);
					// System.out.printf("%s is getting off here, at floor %d\n", job.caller.fname,
					// job.destination);
					return exit(job.caller, job.destination);
				} else if (this.location == 0) {
					System.out.printf("Elevator at Lobby\n",
							this.location);
				} else {
					System.out.printf("Elevator at floor %d\n",
							this.location);
				}
				this.location--;
			}
		} else {
			for (int i = this.location; i <= job.destination; i++) {
				if (i == job.destination) {
					System.out.printf("Elevator at floor %d\n",
							this.location);
					// System.out.printf("%s is getting off here, at floor %d\n", job.caller.fname,
					// job.destination);
					return exit(job.caller, job.destination);
				} else if (this.location == 0) {
					System.out.printf("Elevator at Lobby\n",
							this.location);
				} else {
					System.out.printf("Elevator at floor %d\n",
							this.location);
				}
				this.location++;

			}
		}
		return false;
	}

	/**
	 * This
	 * method should call a method on the Building for a person to enter a given
	 * floor
	 * (hold a reference to the person in the given floor).
	 * 
	 * @param person the person exiting at a given floor
	 * @param floor  the floor at which the person is exiting
	 * @return a bool from person.building.enterFloor()
	 */
	public boolean exit(Person person, int floor) {
		return this.building.enterFloor(person, floor);
	}

	public String toString() {
		return ("Elevator with a max of " + maxOccupants + " occupants, with " + jobs.size() + " passengers.");
	}

}