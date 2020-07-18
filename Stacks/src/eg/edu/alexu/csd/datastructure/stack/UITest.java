package eg.edu.alexu.csd.datastructure.stack;
import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class UITest {
/**
 * test convertion of infix to postfix
 */
	@Test
	void infixToPostfixtest() {
		ExpressionEvaluator m = new 	ExpressionEvaluator();
    	String res = m.infixToPostfix("(1 + 2) * 7");
    	Assert.assertEquals("1 2 + 7 *", res);
    	String res1 = m.infixToPostfix("(a / (b - c + d)) * (e - a) * c ");
    	Assert.assertEquals("a b c - d + / e a - * c *", res1);
    	
    	String res2 = m.infixToPostfix("a / b - c + d * e - a * c");
    	Assert.assertEquals("a b / c - d e * + a c * -", res2);
    	String res3 = m.infixToPostfix("ab + cd ");
    	Assert.assertEquals("ab cd +", res3);
		
	}
	/**
	 * 
	 * test convertion of infix to postfix if there id negative number
	 */
	@Test
	void infixToPostfixtest_negative() {
		ExpressionEvaluator m = new 	ExpressionEvaluator();
    	String res = m.infixToPostfix("-5 +3");
    	Assert.assertEquals("0 5 - 3 +", res);
    	String res1 = m.infixToPostfix("-5 +1 * -23");
    	Assert.assertEquals("0 5 - 1 0 23 - * +", res1);
    	
    	
		
	}
	/**
	 * test if the input is wrong expression
	 */
	@Test
	void wronginfixToPostfixtest() {
		ExpressionEvaluator m = new 	ExpressionEvaluator();
    	 
    	 Assertions.assertThrows(Exception.class, () ->  m.infixToPostfix("(1 + 2) * 7+") );
    	 Assertions.assertThrows(Exception.class, () ->  m.infixToPostfix("(1 + 2) * 7()") );
    	 Assertions.assertThrows(Exception.class, () ->  m.infixToPostfix("+2+3*4") );
    	 Assertions.assertThrows(Exception.class, () ->  m.infixToPostfix("2**4") );
    	 Assertions.assertThrows(Exception.class, () ->  m.infixToPostfix("(((2*4)+( 4(") );
    	 Assertions.assertThrows(Exception.class, () ->  m.infixToPostfix("(2+5)))") );
		
	}
	/**
	 * evalute the exptession with result
	 */
	@Test
	void evalutetest() {
		ExpressionEvaluator m = new 	ExpressionEvaluator();
    	int s = m.evaluate("5 7 +");
    	Assert.assertEquals(12, s);
    	int s1 = m.evaluate("55 70 +");
    	Assert.assertEquals(125, s1);		
	}
	
	/**
	 * make exception if there is divition by zero
	 */
	
	@Test
	void evalutetest_dividebyzero() {
		ExpressionEvaluator m = new 	ExpressionEvaluator();
    	 
    	 Assertions.assertThrows(Exception.class, () -> m.evaluate("5 0 /") );

	}
	
	
	

}
