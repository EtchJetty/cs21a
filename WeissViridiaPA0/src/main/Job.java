package main;

/**
 * This class is used to represent an e;evator trip. This class holds a
 * reference to
 * a Person and a floor number. You can use a null object for the first
 * parameter
 * to represent an empty trip (calling the elevator to the lobby (floor
 * 0)).
 */
public class Job {
    /**
     * A reference to the Person who called the job.
     */
    Person caller;
    /**
     * A location corresponding to a floor.
     */
    int destination;

    /**
     * This class is used
     * mostly to hold information.
     * 
     * @param caller      the person that requested a job (or null if the elevator
     *                    was
     *                    requested to go to the lobby to pick up a person(s))
     * @param destination the floor number that has been requested
     */
    public Job(Person caller, int destination) {
        this.caller = caller;
        this.destination = destination;
    }

    public String toString() {
        return ("Request to go to floor " + this.destination + " from " + this.caller.toString() + ".");
    }

}
