package eg.edu.alexu.csd.datastructure.stack;

public class ExpressionEvaluator implements IExpressionEvaluator {
	/**
	 * 
	 * @param a character input
	 * @param b character input
	 * to know which char has high prec
	 * @return true a has high pre or not
	 */
	
	public boolean HasHigherPre (char a ,char b) {
		if ((a=='/' || a=='*') && (b=='+' || b=='-') ) {
			return true ;
		}else {
			return false ;
		}
		
	}
	/**
	 * 
	 * @param expression
	 * @return expression after exchange negative with dummy zero
	 * this method used to chan negative number in to 0 - this number in ()
	 */
	
	public String dummy (String  expression) {
		char q=0 ;
		expression += ' ' ;
		String result ="" ;
		for (int i=0 ;i<(expression.length());i++)
		{
			char c = expression.charAt(i);
			
			if ((q=='('||q=='+'||q=='*'||q=='/'||q==0) && c =='-')
			{
				result += '(';
				
				result += '0';
				result += ' ';
				result += c ;
				result += ' ';
				result += expression.charAt(++i);
				if (++i<expression.length()) {
					c = expression.charAt(i);

					while (Character.isDigit(c) && i+1<expression.length()) {
						
						result += c ;
						c = expression.charAt(++i);
						
					}
					
				}
				
				
				result += ')';
				result += ' ';
				
				
			
			}else {
				
				result += c ;
			}
			if (c != ' ')
				q = c ;
		}
		return result ;
	}

	/**
	* Takes a symbolic/numeric infix expression as input and converts it to
	* postfix notation. There is no assumption on spaces between terms
	* or the length of the term (e.g., two digits symbolic or numeric term)
	* @param infix expression
	* @return postfix expression
	*/
	@Override
	public String infixToPostfix(String expression) {
		Stack o = new Stack();
		String res = "" ;
		char z = 0;
		char q = 0;
		int count1 = 0 ;
		int count2 = 0 ;
		String exp = this.dummy(expression);

		
		for(int i=0 ;i<exp.length();i++)
		{
			char c = exp.charAt(i);
			if (c == ' ')
			{
				q=' ';
				continue ;
			}else if((c =='/' || c =='*' || c =='+' || c =='-' ) && res =="" ){
				throw new RuntimeException("Invalid input");	
			}
			

			else if ( (c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9') )
			{
				if (( (z >='a' && z<='z') || (z>='A' && z<='Z') || (z>='0' && z<='9'))   && ( (c >='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9'))  && q ==' '  )
				{
					throw new RuntimeException("Invalid input");
				}
				
				res += c ;
				q=0 ;
			}
			
			else if(c =='/' || c =='*' || c =='+' ||c =='-' )
			{					
				if ((z=='/' || z=='*'||z=='+'||z=='-')  && (c=='/' || c=='*'||c=='+'||c=='-'))
				{
					throw new RuntimeException("Invalid input");
				}
				q=0 ;
				res += ' ' ;
				if(o.isEmpty())
					o.push(c);
				else {
					
					if (this.HasHigherPre(c, (char) o.peek()))
						o.push(c);
					else {
						while (! o.isEmpty() && (char) o.peek() != '(') {
							res += o.pop();
							res += ' ' ;

						}
						o.push(c);
					}
				}
				
			}
			
			
			else if (c == '(')
			{
				count1++;
				o.push(c);
			}
			
			
			else if (c == ')' ) 
				
            { 
				if (z=='(')
					throw new RuntimeException("Invalid input");

				if(count1 == 0)
				{
					throw new RuntimeException("Invalid input");
	
				}
               count1--;
               char x = (char) o.pop();
               while (x != '(')
               {
            	   res+=' ';
            	   res += x;
            	   x= (char) o.pop();
               }
            
		}
			else {
				throw new RuntimeException("Invalid input");
			}
			 z = c ;			 
		}
		
		while (! o.isEmpty())
		{
			res += ' ' ;

			res += o.pop();
			
		}
		if( count1 != count2 || z=='/' ||z=='*'||z=='+'||z=='-' )
		{
			res ="";
			throw new RuntimeException("Invalid input");

		}
		return res ;
			}

	/**.
	* Evaluate a postfix numeric expression
	* @param expression postfix expression
	* @return the expression evaluated value
	*/
	@Override
	public int evaluate(String expression) {
		Stack o = new Stack();
		if (expression==null){
            throw new NullPointerException();
            
        }else if (expression.length()==0)
        	return 0 ;
		
		for (int i=0 ;i <expression.length();i++)
			
		{
			char c = expression.charAt(i);
			 if(c == ' ') 
		            continue; 
			 else if(Character.isDigit(c)) 
	            { 
	                float n = 0; 
	                  
	                while(Character.isDigit(c)) 
	                { 
	                    n = (float)n*10 + (float)(c-'0'); 
	                    i++; 
	                    c = expression.charAt(i); 
	                } 
	                i--; 
	  
	                o.push(n); 
	            }  
			 else 
	            { 
	                float val1 = (float) o.pop(); 
	                float val2 =  (float)o.pop(); 
	                  
	                switch(c) 
	                { 
	                    case '+': 
	                    o.push(val2+val1); 
	                    break; 
	                      
	                    case '-': 
	                    o.push(val2-val1); 
	                    break; 
	                      
	                    case '/': 
	                    	if (val1 == 0)
	                    		throw new RuntimeException("divition by zero is invalid");
	                    		else 
	                    			o.push(val2/val1); 
	                    break; 
	                      
	                    case '*': 
	                    o.push(val2*val1); 
	                    break; 
	                    default :
	            				throw new RuntimeException ();
	                    
	                   
	              } 
	            } 
			 
		}
		float x = (float)o.pop();
        return  (int) x;     
		
	}
	
	

	
}
