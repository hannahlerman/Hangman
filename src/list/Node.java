package list;

public class Node<E> {
	
	private E value;
	private Node<E> next;
	
	public Node(E value){
		this.value = value;
	}
	
	public void setValue(E value){
		this.value = value;
	}
	
	public E getValue(){
		return value;
	}
	
	public void setNext(Node<E> next){
		this.next = next;
	}
	
	public Node<E> getNext(){
		return next;
	}

}
