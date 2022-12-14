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

public class Node {

	private Entry entry;
	private Node next;
	private Node prev;

	/**
	 * Constructs a doubly linked list node that holds a key and value field but
	 * does not point to any other nodes. O(1)
	 */
	public Node(GraphNode key, Integer value) {
		this.entry = new Entry(key, value);
	}

	/**
	 * Sets the key field of this node. O(1)
	 */
	public void setKey(GraphNode key) {
		this.entry.setKey(key);
	}

	/**
	 * Sets the value field of this node. O(1)
	 */
	public void setValue(Integer value) {
		this.entry.setValue(value);
	}

	/**
	 * Sets the next pointer of this node. O(1)
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * Sets the previous pointer of this node. O(1)
	 */
	public void setPrev(Node prev) {
		this.prev = prev;
	}

	/**
	 * @return returns the pointer to the next node or null if one does
	 *         not exist. O(1)
	 */
	public Node getNext() {
		return this.next;
	}

	/**
	 * @return returns the pointer to the previous node or null if one does not
	 *         exist. O(1)
	 */
	public Node getPrev() {
		return this.prev;
	}

	/**
	 * @return the key stored in this node. O(1)
	 */
	public GraphNode getKey() {
		return this.entry.getKey();
	}

	/**
	 * @return the entry stored in this node. O(1)
	 */
	public Entry getEntry() {
		return this.entry;
	}

	/**
	 * @return the value stored in this node. O(1)
	 */
	public Integer getValue() {
		return this.entry.getValue();
	}

	/**
	 * O(1)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.join("", this.entry.getKey().toString(), ": ", this.entry.getValue().toString());
	}
}
