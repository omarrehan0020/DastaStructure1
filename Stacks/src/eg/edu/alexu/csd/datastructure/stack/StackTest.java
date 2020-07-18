package eg.edu.alexu.csd.datastructure.stack;
import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class StackTest {
	/**
	 * puch elements and check the size of the stack
	 */

	@Test
	void pushandCheckSize() {
		Stack o =new Stack();
		Assert.assertEquals(0, o.size());
		o.push(1);
		o.push(1);
		Assert.assertEquals(2, o.size());


	}
	/**
	 * 
	 * check if the stack is empty or not
	 */
	@Test
	void isEmpty() {
		Stack o =new Stack();
		Assert.assertEquals(true, o.isEmpty());
		o.push(1);
		o.push(1);
		Assert.assertEquals(false, o.isEmpty());


	}
	
	/**
	 * 
	 * check pop method
	 */
	@Test
	void poptest() {
		Stack o =new Stack();
		o.push(1);
		o.push(1);
		Assert.assertEquals(2, o.size());
		o.pop();
		Assert.assertEquals(1, o.size());
	}
	
	/**
	 * 
	 * throw exception if the stack is empty and using pop 
	 */
	@Test
	void poptestError() {
		Stack o =new Stack();
		
        Assertions.assertThrows(Exception.class, () -> o.pop() );
	
	}
	/**
	 * 
	 * check the last element in the stack
	 */
	@Test
	void peektest() {
		Stack o =new Stack();
		o.push(1);
		o.push(2);
		Assert.assertEquals(2, o.peek());
		o.pop();
		Assert.assertEquals(1, o.peek());
	}
	

}
