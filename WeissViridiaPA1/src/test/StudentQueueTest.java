package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import main.Queue;

class StudentQueueTest {
	Queue<String> q;

	@Test
	void emptyQueueOutOfBoundsException() {
		q = new Queue<String>(10);
		Throwable exception = assertThrows(NoSuchElementException.class, () -> q.front());
		assertEquals(null, exception.getMessage());
		assertEquals(0, q.numEntries);
		q.enqueue("null");
		assertEquals("null", q.front());
		q.dequeue();
		exception = assertThrows(NoSuchElementException.class, () -> q.front());
	}

	@Test
	void test() {
		q = new Queue<String>(10);
		q.enqueue("null");
		q.enqueue("null");
		q.enqueue("null");
		q.enqueue("null");
		q.enqueue("null");
		q.enqueue("null");
		q.enqueue("null");
		q.enqueue("null");
		q.enqueue("null");
		q.enqueue("null");
		assertThrows(IndexOutOfBoundsException.class, () -> q.enqueue("null"));

	}

}
