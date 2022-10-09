package main;

public class Station {

	public Queue<Rider> northBoundRiders;
	public Queue<Rider> southBoundRiders;
	public Queue<Train> northBoundTrains;
	public Queue<Train> southBoundTrains;
	
	public Station(String name) {
		
	}
	
	public boolean addRider(Rider r) { 
		return false;
	}
	
	public String addTrain(Train t) {
		return null;
	}
	
	public Train southBoardTrain() {
		return null;
	}
	
	public Train northBoardTrain() {
		return null;
	}
	
	public void moveTrainNorthToSouth() {
		
	}
	
	public void moveTrainSouthToNorth() {
		
	}
	
	@Override
	public String toString() {
		return null;
	}
	
	public String stationName() {
		return null;
	}
	
	@Override
	public boolean equals(Object o) {
		return false;
	}
}
