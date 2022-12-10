/**
 * Node for Linked List implementation
 * Known Bugs: None
 * 
 * @author Viridia Weiss
 * @email gweiss@brandeis.edu
 *        October 9th, 2022
 *        Modified 12/10/22 for PA3
 *        COSI 21A PA1
 */

public class Node<T, E> {

	private T key;
	private E value;
	private Node<T, E> next;
	private Node<T, E> prev;

	/**
	 * Constructs a doubly linked list node that holds a key and value field but
	 * does not point to any other nodes. O(1)
	 */
	public Node(T key, E value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * Sets the key field of this node. O(1)
	 */
	public void setKey(T key) {
		this.key = key;
	}

	/**
	 * Sets the value field of this node. O(1)
	 */
	public void setValue(E value) {
		this.value = value;
	}

	/**
	 * Sets the next pointer of this node. O(1)
	 */
	public void setNext(Node<T, E> next) {
		this.next = next;
	}

	/**
	 * Sets the previous pointer of this node. O(1)
	 */
	public void setPrev(Node<T, E> prev) {
		this.prev = prev;
	}

	/**
	 * @return returns the pointer to the next node or null if one does
	 *         not exist. O(1)
	 */
	public Node<T, E> getNext() {
		return this.next;
	}

	/**
	 * @return returns the pointer to the previous node or null if one does not
	 *         exist. O(1)
	 */
	public Node<T, E> getPrev() {
		return this.prev;
	}

	/**
	 * @return the key stored in this node. O(1)
	 */
	public T getKey() {
		return this.key;
	}

	/**
	 * @return the value stored in this node. O(1)
	 */
	public E getValue() {
		return this.value;
	}

	/**
	 * O(1)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.join("", this.key.toString(), ": ", this.value.toString());
	}
}
