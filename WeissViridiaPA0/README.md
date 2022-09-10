# Elevator

In the Simulation, a Building is generated. Then, a group of people is generated. Each member is randomly given a preferred floor, and all registered with the Elevator belonging to that Building. Once they're all registered, the Elevator activates. 

When ProcessJobs is called, it adds a job to go to the 0th (Lobby) floor at the end.

Jobs are removed from the elevator's ArrayList of jobs once they've been printed and processed. Part of that, still in the Elevator class, involves calling an exit function, which lets a Person exit into their preferred floor in the Building.

The Floor class's enterFloor() function is then called on for the specific floor that the Person is disembarking. This person is recorded into the Floor's ArrayList, and the Person's location is updated through person.rest(). 

If the elevator recieves another request to process an entirely new group, that'll usually happen only once the entire first group is attended, unless the elevator just isn't started until after the second group. 