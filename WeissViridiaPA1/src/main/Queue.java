package main;

public class Queue<T> {

	public T[] q;
	public int head;
	public int tail;
	public int numEntries;
	
	@SuppressWarnings("unchecked")
	public Queue(int capacity) {
		this.q = (T[]) new Object[capacity];
	}
	
	public void enqueue(T element) {
		
	}
	
	public void dequeue() { 
		
	}
	
	public T front() {
		return null;
	}
	
	public int size() {
		return -1;
	}
	
	@Override
	public String toString() {
		return null;
	}
}
