package list;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class CharacterNodeTest {
	@Rule
	public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds

	@Test
	public void testInfo() {
		Node<Character> a = new Node<>('a');
		assertEquals("Expected 'a' but found " + a.getValue(),
					 new Character('a'), a.getValue());
	}

	@Test
	public void testLink() {
		Node<Character> a = new Node<>('a');
		assertEquals("Expected 'a' but found " + a.getValue(),
					new Character('a'), a.getValue());
		Node<Character> b = new Node<>('b');
		a.setNext(b);
		assertEquals("Expected reference to b but found " + a.getNext(),
				 b, a.getNext());
	}

	@Test
  public void testTraversal() {
		Node<Character> head = null;
		for (int i = 97; i < (97+26); i++) {
			Node<Character> n = new Node<>((char) i);
			if (head == null)
				head = n;
			else {
				n.setNext(head);
				head = n;
			}
		}

		Node<Character> n = head;
		for (int i = 122; i >= 97; i--) {
			assertEquals("Expected " + ((char)i) + " but found " + n.getValue(),
					new Character((char)i), n.getValue());
			n = n.getNext();
		}
	}
}
