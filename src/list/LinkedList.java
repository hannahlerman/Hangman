package list;

public class LinkedList<E> {

	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	/**
	 * 
	 * @return the number of elements in this list
	 */
	public int size() {
		if (head == null) {
			return size;
		}
		Node<E> current = head;
		while(current.getNext() != null){
			size++;
			current = current.getNext();
			
		}
		return size;
	}
	
	/**
	 * 
	 * @param e the element search for
	 * @return true iff the list contains an element of whose value equals that of e
	 */
	public boolean contains(E e) {
		Node<E> current = head;
		while (current != null) {
			if (current.getValue() == e) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}
	
	/**
	 * Appends the element e to the end of the list.
	 * 
	 * @param e the value to append
	 */
	public void append(E e) {
		if(tail == null && head == null) {
			Node<E> newNode = new Node<E>(e);
			head = newNode;
			tail = newNode;
		}
		 Node<E> newnode = new Node<E>(e);
		 tail.setNext(newnode);
		 tail = newnode;
	}
	
	
	@Override
	public String toString() {
		// TODO
		return null;
	}
}
