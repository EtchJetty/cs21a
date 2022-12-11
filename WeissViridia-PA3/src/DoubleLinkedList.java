/**
 * Double Linked List implementation
 * Known Bugs: None
 * 
 * @author Viridia Weiss
 * @email gweiss@brandeis.edu
 *        October 9th, 2022
 *        COSI 21A PA1
 */

public class DoubleLinkedList {

	private int size;
	private Node first;

	/**
	 * initializes a doubly linked list to have 0 elements. O(1)
	 */
	public DoubleLinkedList() {
		this.size = 0;
	}

	/**
	 * gets the first node in the list or null if one does not exist. O(1)
	 */
	public Node getFirst() {
		return this.first;
	}

	/**
	 * adds an element to the end of this list. O(n)
	 * 
	 */
	public void insert(GraphNode key, int value) {
		if (this.first != null) {
			Node tempNode = this.first;
			while (tempNode.getNext() != null) {
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(new Node(key, value));
			tempNode.getNext().setPrev(tempNode);
		} else {
			this.first = new Node(key, value);
		}
		this.size++;
	}

	/**
	 * deletes the first element from this list that matches the
	 * provided key. If the provided key does not exist in the list, return null.
	 * O(n)
	 */
	public GraphNode delete(GraphNode key) {

		for (Node iterNode = this.first; iterNode != null; iterNode = iterNode.getNext()) {
			if (iterNode.getKey() == key) {
				if (iterNode.getNext() != null) {
					iterNode.getNext().setPrev(iterNode.getPrev());
				}
				if (iterNode.getPrev() != null) {
					iterNode.getPrev().setNext(iterNode.getNext());
				}
				if (iterNode == this.first) {
					this.first = iterNode.getNext();
				}
				this.size--;
				return key;
			}

		}
		return null;
	}

	/**
	 * returns the first element in the list that matches the provided key
	 * or null if one cannot be found. O(n)
	 * 
	 * 
	 */
	public Integer get(GraphNode key) {
		for (Node iterNode = this.first; iterNode != null; iterNode = iterNode.getNext()) {
			if (iterNode.getKey().equals(key)) {
				return iterNode.getValue();
			}

		}
		return null;
	}

	/**
	 * Updates the value of the key-value pair. O(n)
	 * 
	 * 
	 */
	public Integer update(GraphNode key, int value) {
		for (Node iterNode = this.first; iterNode != null; iterNode = iterNode.getNext()) {
			if (iterNode.getKey().equals(key)) {
				iterNode.setValue(value);
				return iterNode.getValue();
			}

		}
		return null;
	}

	/**
	 * @return returns the number of elements in the list. O(1)
	 * 
	 */
	public int size() {
		return this.size;
	}

	/**
	 * returns a String representation of this list’s elements. O(n)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String f = "";
		for (Node iterNode = this.first; iterNode != null; iterNode = iterNode.getNext()) {
			f = String.join("", f, " node data ", iterNode.toString());
		}
		return f;
	}
}
