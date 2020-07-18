package eg.edu.alexu.csd.datastructure.stack;



public class Stack implements IStack {
	class Node
	{
		public Node next ;
		public Object element ;
		
		Node(Object elem ,Node n)
		{
			this.element = elem ;
			this.next = n ;
			
			
		}
		
	}
	
	private Node head = null ;
	private Node tail = null ;
	private int size = 0 ;
	

	@Override
	public Object pop() {
		if (this.isEmpty())
			throw null ;
		else
		{
			Object temp = head.element ;
			Node v = head ;
			head = head.next ;
			v.next = null ;
			size-- ;
			return temp ;
		}
	}

	@Override
	public Object peek() {
		if (this.isEmpty())
			throw null ;
		else 
			return this.head.element ;
	}

	@Override
	public void push(Object element) {
		if (this.isEmpty())
		{
			Node newNode = new Node(element ,null);
			head = tail = newNode ;
		}
		Node newNode = new Node(element ,head);
		head = newNode ;
		size++ ;

	}

	@Override
	public boolean isEmpty() {
		return (size==0);
	}

	@Override
	public int size() {
		
		return size;
	}




}
