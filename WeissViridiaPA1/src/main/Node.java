package main;

public class Node<T> {

	private T data;
	private Node<T> next;
	private Node<T> prev;

	/**
	 * Constructs a doubly linked list node that holds a data field but
	 * does not point to any other nodes.
	 */
	public Node(T data) {
		this.data = data;
	}

	/**
	 * Sets the data field of this node.
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Sets the next pointer of this node.
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}

	/**
	 * Sets the previous pointer of this node.
	 */
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}

	/**
	 * @return returns the pointer to the next node or null if one does
	 *         not exist.
	 */
	public Node<T> getNext() {
		return this.next;
	}

	/**
	 * @return returns the pointer to the previous node or null if one
	 *         does not exist.
	 */
	public Node<T> getPrev() {
		return this.prev;
	}

	/**
	 * @return the data stored in this node.
	 */
	public T getData() {
		return this.data;
	}

	@Override
	public String toString() {
		return this.data.toString();
	}
}
