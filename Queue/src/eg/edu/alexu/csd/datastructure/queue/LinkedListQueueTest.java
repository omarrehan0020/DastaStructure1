package eg.edu.alexu.csd.datastructure.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class LinkedListQueueTest {

	@Test
	void enQueuetest() {
		LinkedListQueue ar = new LinkedListQueue() ;
		ar.enqueue(1);
		ar.enqueue(2);
		ar.enqueue(3);
		ar.enqueue(4);
		Assert.assertEquals(4, ar.size());
	}
	@Test
	void deQueuetest() {
		LinkedListQueue ar = new LinkedListQueue() ;
		ar.enqueue(1);
		ar.enqueue(2);
		ar.enqueue(3);
		ar.enqueue(4);
		 
		Assert.assertEquals(1, ar.dequeue());
		Assert.assertEquals(2, ar.dequeue());
	}
	
	
	
	@Test
	void deQueuetestException() {
		LinkedListQueue ar = new LinkedListQueue() ;
		ar.enqueue(1);
		ar.enqueue(2);
		ar.enqueue(3);
		ar.enqueue(4);
		ar.enqueue(5);
		ar.dequeue();
		ar.dequeue();
		ar.dequeue();
		ar.dequeue();
		ar.dequeue();
		Assertions.assertThrows(Exception.class, () -> ar.dequeue() );
	}
	@Test
	void isEmptyTest() {
		LinkedListQueue ar = new LinkedListQueue() ;
		ar.enqueue(1);
		ar.enqueue(2);
		ar.enqueue(3);
		ar.enqueue(4);
		ar.enqueue(5);
		ar.dequeue();
		ar.dequeue();
		ar.dequeue();
		ar.dequeue();
		ar.dequeue();
		
		Assert.assertEquals(true, ar.isEmpty());
	}

}
