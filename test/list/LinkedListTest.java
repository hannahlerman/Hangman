package list;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class LinkedListTest {
	@Rule
	public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds

	@Test
	public void testEmpty() {
		LinkedList<Integer> ll = new LinkedList<>();
		assertEquals(0, ll.size());
	}

	@Test
	public void testNotEmpty() {
		LinkedList<Integer> ll = new LinkedList<>();
		ll.append(1);
		assertEquals(1, ll.size());
	}
	
	@Test
	public void testTwo() {
		LinkedList<Integer> ll = new LinkedList<>();
		ll.append(1);
		ll.append(1);
		assertEquals(2, ll.size());
	}
	
	@Test
	public void testContains() {
		LinkedList<Integer> ll = new LinkedList<>();
		ll.append(0);
		ll.append(1);
		ll.append(2);
		assertTrue(ll.contains(2));
		assertTrue(ll.contains(1));
	}
	
	@Test
	public void testNotContains() {
		LinkedList<Integer> ll = new LinkedList<>();
		ll.append(0);
		ll.append(1);
		ll.append(2);
		assertFalse(ll.contains(3));
	}
}
