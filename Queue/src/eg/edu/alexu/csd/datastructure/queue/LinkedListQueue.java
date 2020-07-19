package eg.edu.alexu.csd.datastructure.queue;

public class LinkedListQueue {
	private int size = 0 ;
	class Node
	{
		Object element ;
		Node next;
		
		Node()
		{
			element = null ;
			next = null ;
		}
		Node(Object data)
		{
			element = data ;
			next = null ;
		}
	}
	
	private Node head = null ;
	private Node tail = null ;
	
	public void enqueue(Object item) {
		
		Node newNode = new Node(item) ;
		if (this.isEmpty())
		{
			head = newNode ;
		}
		else 
		{
			tail.next = newNode ;
		}
		size++ ;
		tail = newNode ;
		
		

	}

	
	public Object dequeue() {
		
		if (this.isEmpty())
			throw new RuntimeException() ;
		
		Node tempNode = head ;
		Object temp = tempNode.element ;
		head = head.next ;
		tempNode.next = null ;
		size-- ;
		if (size == 0)
		{
			tail = null ;
			head = null ;
		}
		return temp ;
		
		
		
	}

	
	public boolean isEmpty() {
		return (size == 0);
		
	}

	
	public int size() {
		return size ;
		
	}

}
