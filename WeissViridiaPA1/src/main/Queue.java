package main;

import java.util.NoSuchElementException;

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

	/**
	 * constructs an empty queue that can hold a specified
	 * number of elements.
	 * 
	 * @param capacity
	 */
	@SuppressWarnings("unchecked")
	public Queue(int capacity) {
		this.q = (T[]) new Object[capacity];
		this.numEntries = 0;
		this.head = 0;
		this.tail = 0;
	}

	/**
	 * adds an element at the tail of the queue.
	 */
	public void enqueue(T element) {
		if (this.numEntries == this.q.length) {
			throw new IndexOutOfBoundsException();
		} else {
			this.q[this.tail] = element;
			this.numEntries++;
			this.tail++;
			this.tail = this.tail % this.q.length;
		}
	}

	/**
	 * removes the element at the head of the queue. If there is no
	 * such element, <strong>you must throw a<strong>
	 * <code>NoSuchElementException</code>.
	 */
	public void dequeue() {
		if (this.tail == this.head) {
			throw new NoSuchElementException();
		} else {
			this.q[this.head] = null;
			this.head++;
			this.numEntries--;
			this.head = this.head % this.q.length;
		}

	}

	/**
	 * returns the element at the head of the queue. If there is no
	 * such element, <strong>you must throw a<strong>
	 * <code>NoSuchElementException</code>.
	 */
	public T front() {
		return null;
	}

	/**
	 * return the number of elements in the queue.
	 */
	public int size() {
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 * return a String representation of the queue’s elements.
	 */
	@Override
	public String toString() {
		return null;
	}
}
