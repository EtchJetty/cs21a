package test;

import main.Station;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Rider;
import main.Train;

class StudentStationTest {
	Station s;
	
	@Test
	void initTest() {
		s = new Station("s");
		assertEquals(null, s.northBoardTrain());
		assertEquals(null, s.southBoardTrain());
		assertEquals("s", s.stationName());
		assertEquals(0, s.northBoundRiders.size());
		assertEquals(0, s.southBoundRiders.size());
	}
	
	@Test
	void addWaitingRiders() {
		s = new Station("s");
		
		Rider r = new Rider("abc", "s", "d");
		
		s.addRider(r);
		
		r = new Rider("abc", "s", "d");
		r.swapDirection();
		s.addRider(r);
		
		assertEquals(1, s.northBoundRiders.size());
		assertEquals(1, s.southBoundRiders.size());
		
		s.addRider(r);
		s.addRider(r);
		s.addRider(r);
		
		assertEquals(4, s.northBoundRiders.size());
	}
	
	@Test
	void addTrains() {
		s = new Station("s");
		
		Train t = new Train("s", 1);
		s.addTrain(t);
		
		t = new Train("s", 0);
		s.addTrain(t);
		
		assertEquals(1, s.northBoundTrains.size());
		assertEquals(1, s.southBoundTrains.size());
		assertEquals(0, s.northBoundRiders.size());
		assertEquals(0, s.southBoundRiders.size());
		
		s.addTrain(t);
		s.addTrain(t);
		s.addTrain(t);
		
		assertEquals(4, s.northBoundTrains.size());
		assertEquals(1, s.southBoundTrains.size());
	}
	
	@Test
	void testEquals() {
		s = new Station("s");
		
		Station t = new Station("t");
		assertFalse(t.equals(s));
		
		t = new Station("s");
		assertEquals(t, s);
	}
	
	@Test
	void moveTrains() {
		s = new Station("s");
		
		//1 = south-bound trains
		Train t = new Train("s", 1);
		s.addTrain(t);
		s.addTrain(t);
		//0 = north-bound trains
		t = new Train("s", 0);
		s.addTrain(t);
		s.addTrain(t);
		
		assertEquals(2, s.northBoundTrains.size());
		assertEquals(2, s.southBoundTrains.size());
		
		s.moveTrainNorthToSouth();
		
		assertEquals(1, s.northBoundTrains.size());
		assertEquals(3, s.southBoundTrains.size());
		
		s.moveTrainSouthToNorth();
		s.moveTrainSouthToNorth();
		s.moveTrainSouthToNorth();
		
		assertEquals(4, s.northBoundTrains.size());
		assertEquals(0, s.southBoundTrains.size());		
	}
	
	

}
