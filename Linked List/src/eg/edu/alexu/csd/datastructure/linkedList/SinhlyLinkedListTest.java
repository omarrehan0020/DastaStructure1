package eg.edu.alexu.csd.datastructure.linkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import eg.edu.alexu.csd.datastructure.linkedList.SinglyLinkedList.Node;

class SinhlyLinkedListTest {

	@Test
	void addandgetTest() {
		
		SinglyLinkedList list = new SinglyLinkedList() ;
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(0,5);
		
		Assert.assertEquals(5,list.get(0));
		Assert.assertEquals(3,list.get(3));
		
	}
	
	@Test
	void setandgetTest() {
		
		SinglyLinkedList list = new SinglyLinkedList() ;
		list.add(1);
		list.add(2);
		list.add(3);
		list.set(0,5);
		
		Assert.assertEquals(5,list.get(0));
		Assert.assertEquals(3,list.get(2));
	
		
	}
	
	@Test
	void sizeTest() {
		
		SinglyLinkedList list = new SinglyLinkedList() ;
		list.add(1);
		list.add(2);
		list.add(3);
		
		
		Assert.assertEquals(3,list.size());
		
	
		
	}
	
	@Test
	void isemptyTest() {
		
		SinglyLinkedList list = new SinglyLinkedList() ;
		Assert.assertEquals(true,list.isEmpty());
		
		list.add(1);
		list.add(2);
		list.add(3);
		
		
		Assert.assertEquals(false,list.isEmpty());
		
	
		
	}
	
	
	@Test
	void containTest() {
		
		SinglyLinkedList list = new SinglyLinkedList() ;
		Assert.assertEquals(true,list.isEmpty());
		
		list.add(1);
		list.add(2);
		list.add(3);		
		
		Assert.assertEquals(false,list.contains(7));
		Assert.assertEquals(true,list.contains(1));
	
		
	}
	
	@Test
	void sublistTest() {
		
		SinglyLinkedList list = new SinglyLinkedList() ;
	
		
		
		list.add(1);
		list.add(2);
		list.add(3);	
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		
		
		SinglyLinkedList newlist =(SinglyLinkedList) list.sublist(2, 7) ;
		Assert.assertEquals(3,newlist.get(0));
		Assert.assertEquals(8,newlist.get(5));
		Assert.assertEquals(4,newlist.get(1));
		Assert.assertEquals(6,newlist.get(3));
		
	
		
	}
	
	@Test
	void clearTest() {
		
		SinglyLinkedList list = new SinglyLinkedList() ;
	
		
		
		list.add(1);
		list.add(2);
		list.add(3);	
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.clear();
		Assert.assertEquals(0,list.size());
		
	}
	
	@Test
	void invalidTest() {
		
		SinglyLinkedList list = new SinglyLinkedList() ;
	
		
		assertThrows(NullPointerException.class, () -> {list.add(-1,2);});

		
		
	}
	
	

}
