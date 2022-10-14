/** 
  * Node for Linked List implementation
  * Known Bugs: None
  * 
  * @author Viridia Weiss   
  * @email gweiss@brandeis.edu
  * October 9th, 2022
  * COSI 21A PA1  
  */

package main;

public class Node<T> {

	private T data;
	private Node<T> next;
	private Node<T> prev;

	/**
	 * Constructs a doubly linked list node that holds a data field but
	 * does not point to any other nodes. O(1)
	 */
	public Node(T data) {
		this.data = data;
	}

	/**
	 * Sets the data field of this node. O(1)
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Sets the next pointer of this node. O(1)
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}

	/**
	 * Sets the previous pointer of this node. O(1)
	 */
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}

	/**
	 * @return returns the pointer to the next node or null if one does
	 *         not exist. O(1)
	 */
	public Node<T> getNext() {
		return this.next;
	}

	/**
	 * @return returns the pointer to the previous node or null if one does not
	 *         exist. O(1)
	 */
	public Node<T> getPrev() {
		return this.prev;
	}

	/**
	 * @return the data stored in this node. O(1)
	 */
	public T getData() {
		return this.data;
	}

	/**
	 * O(1)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.data.toString();
	}
}
