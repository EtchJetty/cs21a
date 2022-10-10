package main;

public class DoubleLinkedList<T> {

	private int size;
	private Node<T> first;

	/**
	 * initializes a doubly linked list to have 0 elements.
	 */
	public DoubleLinkedList() {
		this.size = 0;
	}

	/**
	 * gets the first node in the list or null if one does not exist.
	 */
	public Node<T> getFirst() {
		return this.first;
	}

	/**
	 * adds an element to the end of this list.
	 * 
	 */
	public void insert(T element) {
		if (this.first != null) {
			Node<T> tempNode = this.first;
			while (tempNode.getNext() != null) {
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(new Node<T>(element));
			tempNode.getNext().setPrev(tempNode);
		} else {
			this.first = new Node<T>(element);
		}
		this.size++;
	}

	/**
	 * deletes the first element from this list that matches the
	 * provided key. If the provided key does not exist in the list, return null.
	 */
	public T delete(T key) {
		if (this.first != null) {

			Node<T> tempNode = this.first;
			while (tempNode.getNext().getData() != key) {

				tempNode = tempNode.getNext();

				if (tempNode.getNext() == null) {
					if (tempNode.getData() == key) {
						tempNode.getPrev().setNext(null);
						this.size--;
						return key;
					}
					return null;
				}
			}
			tempNode.getPrev().setNext(tempNode.getNext());
			tempNode.getNext().setPrev(tempNode.getPrev());
			this.size--;
			return key;

		} else {
			return null;
		}
	}

	/**
	 * returns the first element in the list that matches the provided key
	 * or null if one cannot be found.
	 * 
	 * 
	 */
	public T get(T key) {
		return null;
	}

	/**
	 * @return returns the number of elements in the list.
	 * 
	 */
	public int size() {
		return this.size;
	}

	@Override
	public String toString() {
		return null;
	}
}
