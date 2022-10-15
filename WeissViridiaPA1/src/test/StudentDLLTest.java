package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.DoubleLinkedList;

class StudentDLLTest {
	DoubleLinkedList<String> dll;

	@Test
	void test() {
		dll = new DoubleLinkedList<String>();
		assertEquals(null, dll.getFirst());
		dll.insert("Item1");
		assertEquals("Item1", dll.get("Item1"));
		assertEquals("Item1", dll.delete("Item1"));
		assertEquals(null, dll.delete("Item1"));
		assertEquals(0, dll.size());
		dll.insert("Item1");
		dll.insert("Item2");
		assertEquals(2, dll.size());
		assertNotEquals(dll.get("Item1"), dll.get("Item2"));
		assertEquals(null, dll.delete("null"));
	}

}
