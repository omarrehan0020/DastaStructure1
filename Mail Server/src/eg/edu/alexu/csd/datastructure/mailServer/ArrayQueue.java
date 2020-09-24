package eg.edu.alexu.csd.datastructure.mailServer;

public class ArrayQueue {

	private Object[] arr ;
	private int size ;
	private int f ,r ;
	private int N ;
	
	ArrayQueue (int max)
	{
		if (max <= 0)
			max = 1000 ;
		arr = new Object[max] ;
		size =0 ;
		f=0 ;
		r=0 ;
		N = max ;
	}
	ArrayQueue ()
	{
		arr = new Object[1000] ;
		size = 0 ;
		f=0 ;
		r=0 ;
		N= 1000 ;
	}
	
	
	
	
	public void enqueue(Object item) {
		if (size == N)
			throw new RuntimeException () ;
		
		else 
		{
			arr[r] = item ;
			r = (r+1) % N ;
			size++ ;
		}
		

	}

	
	public Object dequeue() {
		
		if (size == 0)
			throw new RuntimeException () ;
		else
		{
			Object temp = arr[f] ;
			arr[f] = null ;
			f = (f+1) % N ;
			size-- ;
			return temp ;
		}
		
	}

	
	public boolean isEmpty() {
		return (size == 0);
		
	}

	
	public int size() {
		return size ;
		
	}

}
