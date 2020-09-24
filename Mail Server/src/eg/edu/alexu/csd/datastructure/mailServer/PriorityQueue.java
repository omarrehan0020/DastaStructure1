package eg.edu.alexu.csd.datastructure.mailServer;

public class PriorityQueue implements IPriorityQueue {
	
	class Node{
		private Object data ;
		private Node next ;
		private int key ;
		
		Node(Object d , int k)
		{
			this.data = d ;
			this.next = null ;
			this.key = k ;
		}
	}


	private int size ;
	Node head ;
	
	PriorityQueue()
	{
		this.size = 0 ;
		this.head = null ;
	}
	
	
	@Override
	public void insert(Object item, int key) {
		Node newNode = new Node(item,key) ;
		Node pointNode = head ;
		if (head == null)
		{
			head = newNode ;
			size++ ;
			return ;
		}
		if (head.key > key)
		{
			newNode.next = head ;
			head = newNode ;
			size++ ;
			return ;
		}
		while (pointNode.next != null && pointNode.next.key < newNode.key)
		{
			pointNode = pointNode.next ;
		}
		newNode.next = pointNode.next ;
		pointNode.next = newNode ;
		size++ ;
		return ;
	}

	@Override
	public Object removeMin() {
		if (size==0)
			 throw new RuntimeException()  ;
		Node temp = head ;
		if (head != null)
			head = head.next ;
		size-- ;
		return temp.data ;
	}

	@Override
	public Object min() {
		return head.data ;
	}

	@Override
	public boolean isEmpty() {
		return (size==0) ;
	}

	@Override
	public int size() {
		return size;
	}
}
