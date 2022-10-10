package main;

public class Queue<T> {

	/**
	 * generic array to store the contents of the queue
	 */
	public T[] q;
	/**
	 * index of the front of the queue, from which you should dequeue.
	 * 
	 */
	public int head;
	/**
	 * index of where <strong>the next element</strong> will be enqueued.
	 * 
	 */
	public int tail;
	/**
	 * number of entries stored in the queue.
	 */
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
