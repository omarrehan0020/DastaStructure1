package eg.edu.alexu.csd.datastructure.linkedList;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		boolean flag = true ;
		
		
		
		polynomial op = new polynomial() ;
		char o ,p;
		Scanner scan = new Scanner(System.in) ;
		while(flag)
		{
			System.out.println("Please choose an action");
			System.out.println("1- Set a polynomial variable");
			System.out.println("2- Print the value of a polynomial variable");
			System.out.println("3- Add two polynomials");
			System.out.println("4- Subtract two polynomials");
			System.out.println("5- Multiply two polynomials");
			System.out.println("6- Evaluate a polynomial at some point");
			System.out.println("7- Clear a polynomial variable");
			System.out.println("8- Exit");
			int x = scan.nextInt() ;
			
			switch (x) {
			case 1 : 
				System.out.println("1-Enter name of polynomial variable A or B or C");
				o =scan.next().charAt(0) ;
				int[][] terms = op.getPolynomial() ;
				op.setPolynomial(o, terms);
				break ;
			case 2 :
				System.out.println("1-Enter name of polynomial variable A or B or C you need to print");
				 o =scan.next().charAt(0) ;
	             op.print(o) ;
				break ;
			case 3 : 
				System.out.println("1-Enter name of first polynomial variable A or B or C");
				o =scan.next().charAt(0) ;
				System.out.println("1-Enter name of second polynomial variable A or B or C");
				p =scan.next().charAt(0) ;
				op.add(o, p) ;
				String r = op.print('R');
				System.out.println(r);
				break ;
			case 4 : 
				System.out.println("1-Enter name of first polynomial variable A or B or C");
				o =scan.next().charAt(0) ;
				System.out.println("1-Enter name of second polynomial variable A or B or C");
				p =scan.next().charAt(0) ;
				op.subtract(o, p);
				String u = op.print('R');
				System.out.println(u);
				break ;
				
			case 5 : 
			    System.out.println("1-Enter name of first polynomial variable A or B or C");
			    o =scan.next().charAt(0) ;
			    System.out.println("1-Enter name of second polynomial variable A or B or C");
			    p =scan.next().charAt(0) ;
			    op.multiply(o, p) ;
			    String m = op.print('R');
				System.out.println(m);
			    break ;
			case 6 : 
			    System.out.println("1-Enter point you need");
			    float v = scan.nextFloat() ;
			    
			    System.out.println("1-Enter name of polynomial variable A or B or C");
			    o =scan.next().charAt(0) ;
			    float  opr =  op.evaluatePolynomial(o, v) ;
			    System.out.println(opr);
			    break ;
			case 7 :
				System.out.println("1-Enter name of polynomial variable A or B or C");
			    o =scan.next().charAt(0) ;
				op.clearPolynomial(o);
				break ;
			case 8 :
				flag = false ;
				break ;
			default :
				System.out.println("Please, Enter a valid number");
				
				
			
		}
			
		}
		
	}
	

	

}
