package eg.edu.alexu.csd.datastructure.linkedList;

public class SinglyLinkedList implements ILinkedList {
	
	public class Node {
		Object data ;
		Node next ;
		
		public Node (Object d)
		{
			this.data = d ;
			this.next = null ;
		}
	}
	
	private Node head = null ;
	private int size=0 ;
	

	@Override
	public void add(int index, Object element) {
		
		Node newNode = new Node (element) ;
		Node pointNode = head ;
		
		if(index > size || index < 0 )
			throw null ;
		
		if (index == 0)
		{
			newNode.next = head ;
			head = newNode ;
			size++ ;
			return ;
		}
		
		for (int i=0 ;i<index-1 ;i++)
		{
			pointNode = pointNode.next ;
		}
		
		newNode.next = pointNode.next ;
		pointNode.next = newNode ;
		size++ ;
		return ;
		
		

	}

	@Override
	public void add(Object element) {
		
		Node newNode = new Node(element) ;
		Node pointNode = head ;
		
		if (size == 0 )
		{
			head = newNode ;
			size++ ;
			return ;
		}
		while (pointNode.next != null)
		{
			pointNode = pointNode.next ;
		}
		pointNode.next = newNode ;
		size++ ;
		return ;
		

	}

	@Override
	public Object get(int index) {
		
		if(index > size-1 || index < 0)
			throw null ;
		
		Node pointNode = head ;
		
		for (int i=0 ;i<index ;i++)
		{
			pointNode = pointNode.next ;
		}
		
		return pointNode.data ;
		
		
	}

	@Override
	public void set(int index, Object element) {
		
		if(index > size-1 || index < 0)
			throw null ;
		
		
		Node current = head ;
		
		for (int i=0 ;i<index ;i++) 
		{
			current = current.next ;
		}
		
		current.data = element ;
	}

	@Override
	public void clear() {
		
		head = null ;
		size =0 ;

	}

	@Override
	public boolean isEmpty() {
		return (size==0) ;
	}
	
	@Override
	public int size() {
		return size ;
	}


	@Override
	public void remove(int index) {
		
		Node prev = null ;
		Node current = head ;
		
		
		if (index > size-1 || index < 0)
			throw null ;
		
		if (index == 0)
		{
			head = head.next ;
			size-- ;
			return ;
		}
		
		for(int i=0 ;i<index ;i++)
		{
			prev = current ;
			current = current.next ;
		}
		
		prev.next = current.next ;
		size-- ;
		return ;
		

	}

	
	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		
		if (fromIndex > toIndex || fromIndex < 0 || toIndex > size-1)
			throw null ;
		
		SinglyLinkedList newList = new SinglyLinkedList() ;
		Node pointNode = head ;
		
		for (int i=0 ;i<fromIndex ;i++)
		{
			pointNode = pointNode.next ;
		}
		
		
		while (fromIndex <= toIndex)
		{
			newList.add(pointNode.data);
			pointNode = pointNode.next ;
			fromIndex++ ;
		}
		
		return newList ;
		
		
		
		
	}

	@Override
	public boolean contains(Object o) {
		if (head==null)
			return false ;
		
		Node pointNode = head ;
		
		while (pointNode != null)
		{
			if (pointNode.data == o)
				return true ;
			
			pointNode = pointNode.next ;
		}
		return false ;
	}
	
	public void displayList(SinglyLinkedList o) {
		
		Node pointNode = head ;
		while (pointNode != null )
		{
			System.out.println(pointNode.data);
			pointNode = pointNode.next ;
		}
		
		System.out.println(this.size());
		System.out.println(this.isEmpty());
	}

}
