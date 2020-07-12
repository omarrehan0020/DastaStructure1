package eg.edu.alexu.csd.datastructure.linkedList;
import java.lang.Math;

import java.util.Scanner;

public class polynomial {
	int[][] terms ;
	SinglyLinkedList varA = new SinglyLinkedList();
	SinglyLinkedList varB = new SinglyLinkedList();
	SinglyLinkedList varC = new SinglyLinkedList();
	SinglyLinkedList varR = new SinglyLinkedList();
	SinglyLinkedList list1 = new SinglyLinkedList() ;
	SinglyLinkedList list2 = new SinglyLinkedList() ;
	
	

	public int[][] getPolynomial()
	{
		int o = 1 ;
		Scanner scan = new Scanner(System.in) ;
		System.out.println("Enter number of terms : ");
		int n = scan.nextInt() ;
	    terms = new int[n][2];
		for (int i=0 ;i<n ;i++)
		{
			System.out.println("coefficient " + o + " : ");
			terms[i][0] = scan.nextInt() ;
			System.out.println("exponent " + o++ + " : ");
			terms[i][1] = scan.nextInt() ;
		}
		for (int i=0 ;i<terms.length ;i++)
		{
			for (int j=0 ;j<terms.length-i-1 ;j++)
			{
				if (terms[j][1] == terms[j+1][1])
				{
					terms[j][0] += terms[j+1][0];
					 terms[j+1][0] = 0 ;
					 terms[j+1][1] = 0 ;
					
				}
				if (terms[j][1] < terms[j+1][1])
				{
					int[][] temp = new int[1][2] ;
					
					temp[0][0] = terms[j][0] ;
					temp[0][1] = terms[j][1] ;
					
					terms[j][0] = terms[j+1][0] ;
					terms[j][1] =  terms[j+1][1] ;
					
					terms[j+1][0] = temp[0][0] ;
					terms[j+1][1] =  temp[0][1] ;	
				}
			}
			
		}
		return terms ;
	}
	
	private SinglyLinkedList setPoly(SinglyLinkedList var , int[][] terms)
	{
		if (! var.isEmpty())
			var.clear();
		
		for (int i=0 ;i<terms.length ;i++)
		{
			int[][] arr = new int[1][2] ;
			arr[0][0] = terms[i][0] ;
			arr[0][1] = terms[i][1] ;
			var.add(i,arr);
		}
		return var ;
	}
	

	public void setPolynomial(char poly, int[][] terms) {
		
		if (poly =='A')
		{
         this.setPoly(varA, terms);
		}else if (poly == 'B')
		{
			 this.setPoly(varB, terms);
		}else if (poly == 'C')
		{
		 this.setPoly(varC, terms);
		}
		else 
			throw new RuntimeException() ;
		
		
	}
private void setPolynomial2(char poly, int[][] terms) {
		
		if (poly =='A')
		{
         this.setPoly(varA, terms);
		}else if (poly == 'B')
		{
			 this.setPoly(varB, terms);
		}else if (poly == 'C')
		{
		 this.setPoly(varC, terms);
		}else if (poly == 'R')
		{
			this.setPoly(varR, terms);
		}
		else 
			throw new RuntimeException() ;
		
		
	}
	
	
	public String print(char poly) {

		String poly1 ="" ;
		
		if (poly =='A')
		{
			if (varA.isEmpty())
				throw null ;
			
			int i=0 ;
			boolean flag = false ,found = false ;
			while(i < varA.size())
			{
				int[][] oop = (int[][]) varA.get(i) ;
				
				if (oop[0][0] == 0)
				{
					poly1 += "" ;
					i++ ;
			        continue ;
				}
				if (oop[0][0] > 0 && flag )
				{
					poly1 +=" " + "+" + " " ;
				}else if(oop[0][0] < 0 && flag)
				{
					poly1 +=" " + "-" + " " ;
					oop[0][0] = -oop[0][0] ;
					found = true ;
				}
				if (oop[0][0] == 1)
				{
					if (oop[0][1] == 0 )
						poly1 += 1 ;
					else if (oop[0][1] == 1)
						poly1 += "x" ;
					else
					    poly1 +="x^" + oop[0][1]  ;
					
					i++ ; flag = true ;
				}else if (oop[0][0] != 0 && oop[0][0] != 1)
				{
					if (oop[0][1] == 0)
						poly1 += oop[0][0] ;
					else if(oop[0][1] == 1)
						poly1 += oop[0][0] +"x" ;
					else
					    poly1 += oop[0][0] +"x^" +oop[0][1] ;
					i++ ; flag = true ;
					
				}
				
				if (found)
				{
					oop[0][0] = -oop[0][0] ;
					found = false ;
				}
			}
			
		}
		
		else if (poly =='B')
		{
			if (varB.isEmpty())
				throw null ;
			
			int i=0 ;
			boolean flag = false ,found = false ;
			while(i < varB.size())
			{
				int[][] oop = (int[][]) varB.get(i) ;
				
				if (oop[0][0] == 0)
				{
					poly1 += "" ;
					i++ ;
			        continue ;
				}
				if (oop[0][0] > 0 && flag )
				{
					poly1 +=" " + "+" + " " ;
				}else if(oop[0][0] < 0 && flag)
				{
					poly1 +=" " + "-" + " " ;
					oop[0][0] = -oop[0][0] ;
					found = true ;
				}
				if (oop[0][0] == 1)
				{
					if (oop[0][1] == 0 )
						poly1 += 1 ;
					else if (oop[0][1] == 1)
						poly1 += "x" ;
					else
					    poly1 +="x^" + oop[0][1]  ;
					
					i++ ; flag = true ;
				}else if (oop[0][0] != 0 && oop[0][0] != 1)
				{
					if (oop[0][1] == 0)
						poly1 += oop[0][0] ;
					else if(oop[0][1] == 1)
						poly1 += oop[0][0] +"x" ;
					else
					    poly1 += oop[0][0] +"x^" +oop[0][1] ;
					i++ ; flag = true ;
					
				}
				if (found)
				{
					oop[0][0] = -oop[0][0] ;
					found = false ;
				}
			}
		}
		
		else if (poly =='C')
		{
			if (varC.isEmpty())
				throw null ;
			
			int i=0 ;
			boolean flag = false,found = false ;
			while(i < varC.size())
			{
				int[][] oop = (int[][]) varC.get(i) ;
				
				if (oop[0][0] == 0)
				{
					poly1 += "" ;
					i++ ;
			        continue ;
				}
				if (oop[0][0] > 0 && flag )
				{
					poly1 +=" " + "+" + " " ;
				}else if(oop[0][0] < 0 && flag)
				{
					poly1 +=" " + "-" + " " ;
					oop[0][0] = -oop[0][0] ;
					found = true ;
				}
				if (oop[0][0] == 1)
				{
					if (oop[0][1] == 0 )
						poly1 += 1 ;
					else if (oop[0][1] == 1)
						poly1 += "x" ;
					else
					    poly1 +="x^" + oop[0][1]  ;
					
					i++ ; flag = true ;
				}else if (oop[0][0] != 0 && oop[0][0] != 1)
				{
					if (oop[0][1] == 0)
						poly1 += oop[0][0] ;
					else if(oop[0][1] == 1)
						poly1 += oop[0][0] +"x" ;
					else
					    poly1 += oop[0][0] +"x^" +oop[0][1] ;
					i++ ; flag = true ;
					
				}
				if (found)
				{
					oop[0][0] = -oop[0][0] ;
					found = false ;
				}
			}
		}
		
		else if(poly =='R')
		{
			
			if (varR.isEmpty())
				throw null ;
			
			int i=0 ;
			boolean flag = false,found = false ;
			while(i < varR.size())
			{
				int[][] oop = (int[][]) varR.get(i) ;
				
				if (oop[0][0] == 0)
				{
					poly1 += "" ;
					i++ ;
			        continue ;
				}
				if (oop[0][0] > 0 && flag )
				{
					poly1 +=" " + "+" + " " ;
				}else if(oop[0][0] < 0 && flag)
				{
					poly1 +=" " + "-" + " " ;
					oop[0][0] = -oop[0][0] ;
					found = true ;
				}
				if (oop[0][0] == 1)
				{
					if (oop[0][1] == 0 )
						poly1 += 1 ;
					else if (oop[0][1] == 1)
						poly1 += "x" ;
					else
					    poly1 +="x^" + oop[0][1]  ;
					
					i++ ; flag = true ;
				}else if (oop[0][0] != 0 && oop[0][0] != 1)
				{
					if (oop[0][1] == 0)
						poly1 += oop[0][0] ;
					else if(oop[0][1] == 1)
						poly1 += oop[0][0] +"x" ;
					else
					    poly1 += oop[0][0] +"x^" +oop[0][1] ;
					i++ ; flag = true ;
					
				}
				if (found)
				{
					oop[0][0] = -oop[0][0] ;
					found = false ;
				}
				
			}
		}
		else 
		{
			throw new RuntimeException() ;
		}
		
		return poly1 ;
			
			
	}
	
	
	public void clearPolynomial(char poly) {
		if (poly=='A')
			varA.clear();
		else if (poly =='B')
			varB.clear();
		else if (poly =='C')
			varC.clear();
		else if (poly =='R')
			varR.clear();
		else 
			throw new RuntimeException() ;
	}
	
	
	public float evaluatePolynomial(char poly, float value) {
		float r = 0 ;
		if (poly =='A')
		{
			if (varA.isEmpty())
				throw null ;
			
			int i=0 ;
			
			while(i < varA.size())
			{
				int[][] oop = (int[][]) varA.get(i) ;
				r += oop[0][0] * Math.pow(value, oop[0][1]) ;

				i++ ;
			}
		}
		
		
		else if (poly =='B')
		{
			if (varB.isEmpty())
				throw null ;
			
			int i=0 ;
			
			while(i < varB.size())
			{
				int[][] oop = (int[][]) varB.get(i) ;
				r += oop[0][0] * Math.pow(value, oop[0][1]) ;
				i++ ;
			}
		}
		
		else if (poly =='C')
		{
			if (varC.isEmpty())
				throw null ;
			
			int i=0 ;
			
			while(i < varC.size())
			{
				int[][] oop = (int[][]) varC.get(i) ;
				r += oop[0][0] * Math.pow(value, oop[0][1]) ;
				i++ ;
			}
		}
		
		else if(poly =='R')
		{
			
			if (varR.isEmpty())
				throw null ;
			
			int i=0 ;
			
			while(i < varR.size())
			{
				int[][] oop = (int[][]) varR.get(i) ;
				r += oop[0][0] * Math.pow(value, oop[0][1]) ;
				i++ ;
			}
		}
		else 
		{
			throw new RuntimeException() ;
		}
		return r ;
	}
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////
	private void getpolynomial(char poly1, char poly2)
	{
		//clear the lists
				if (! list1.isEmpty())
					list1.clear();
				if (! list2.isEmpty())
					list2.clear();
				
				//to get first polynomial
				if (poly1=='A')
					list1 = varA ;
				else if (poly1 =='B')
					list1 = varB ;
				else if (poly1 =='C')
					list1 = varC ;
				else 
					throw new RuntimeException() ;
				
				//to get second polynomial
				
				if (poly2=='A')
					list2 = varA ;
				else if (poly2 =='B')
					list2 = varB ;
				else if (poly2 =='C')
					list2 = varC ;
				else 
					throw new RuntimeException() ;
	}
	
	public int[][] add(char poly1, char poly2){
		
		if (! varR.isEmpty())
			varR.clear();
		
		this.getpolynomial(poly1, poly2);
		
		int i=0 ;
		int j=0 ;
	
		int size1 = list1.size() ;
		int size2 = list2.size() ;
		
		int[][] arr1 = new int[1][2] ;
		int[][] arr2 = new int[1][2] ;
		
		while (i < size1 && j < size2)
		{
			int[][] res = new int[1][2] ;
			 arr1 = (int[][]) list1.get(i) ;
			 arr2 = (int[][]) list2.get(j) ;
			 if (arr1[0][1] == arr2[0][1])
			 {
					res[0][0] = arr1[0][0] +arr2[0][0] ;
					res[0][1] = arr1[0][1]  ;
					varR.add(res);
					i++; j++ ;
			 }else if (arr1[0][1] > arr2[0][1])
			 {
				 res[0][0] = arr1[0][0]  ;
				 res[0][1] = arr1[0][1]  ;
				 varR.add(res);
				 i++ ;
			 }else
			 {
				 res[0][0] = arr2[0][0]  ;
				 res[0][1] = arr2[0][1]  ;
				 varR.add(res);
				 j++;
			 }
			 
			 
				  
		}
		
		while (i < size1)
		{
			int[][] res = new int[1][2] ;
			 arr1 = (int[][]) list1.get(i) ;
			 res[0][0] = arr1[0][0]  ;
			 res[0][1] = arr1[0][1]  ;
			 i++ ;
			 varR.add(res);
		}
		while (j < size2)
		{
			int[][] res = new int[1][2] ;
			 arr2 = (int[][]) list2.get(j) ;
			 res[0][0] = arr2[0][0]  ;
			 res[0][1] = arr2[0][1]  ;
			 j++ ;
			 varR.add(res);
		}
		
		int[][] r = new int[varR.size()][2] ;
		
		for (int k=0 ;k<varR.size() ;k++)
		{
			int[][] res = new int[1][2] ;
			res =(int[][]) varR.get(k) ;
			r[k][0] = res[0][0] ;
			r[k][1] = res[0][1] ;
			
		}	
		return  r;	
		
	}
	
	
	public int[][] subtract(char poly1, char poly2){
		if (! varR.isEmpty())
			varR.clear();
		
		this.getpolynomial(poly1, poly2);
		
		int i=0 ;
		int j=0 ;
	
		int size1 = list1.size() ;
		int size2 = list2.size() ;
		
		int[][] arr1 = new int[1][2] ;
		int[][] arr2 = new int[1][2] ;
		
		while (i < size1 && j < size2)
		{
			int[][] res = new int[1][2] ;
			 arr1 = (int[][]) list1.get(i) ;
			 arr2 = (int[][]) list2.get(j) ;
			 if (arr1[0][1] == arr2[0][1])
			 {
					res[0][0] = arr1[0][0] - arr2[0][0] ;
					res[0][1] = arr1[0][1]  ;
					varR.add(res);
					i++; j++ ;
			 }else if (arr1[0][1] > arr2[0][1])
			 {
				 res[0][0] = arr1[0][0]  ;
				 res[0][1] = arr1[0][1]  ;
				 varR.add(res);
				 i++ ;
			 }else
			 {
				 res[0][0] = arr2[0][0]  ;
				 res[0][1] = arr2[0][1]  ;
				 varR.add(res);
			 }
			 
			 
				  
		}
		
		while (i < size1)
		{
			int[][] res = new int[1][2] ;
			 arr1 = (int[][]) list1.get(i) ;
			 res[0][0] = arr1[0][0]  ;
			 res[0][1] = arr1[0][1]  ;
			 i++ ;
			 varR.add(res);
		}
		while (j < size2)
		{
			int[][] res = new int[1][2] ;
			 arr2 = (int[][]) list2.get(j) ;
			 res[0][0] = arr2[0][0]  ;
			 res[0][1] = arr2[0][1]  ;
			 j++ ;
			 varR.add(res);
		}
		
		int[][] r = new int[varR.size()][2] ;
		
		for (int k=0 ;k<varR.size() ;k++)
		{
			int[][] res = new int[1][2] ;
			res =(int[][]) varR.get(k) ;
			r[k][0] = res[0][0] ;
			r[k][1] = res[0][1] ;
			
		}	
		return  r;	
		
	}
	
	public int[][] multiply(char poly1, char poly2){
		
		if (! varR.isEmpty())
			varR.clear();
		
		this.getpolynomial(poly1, poly2);
		
		int k=0 ;
		int size1 = list1.size() ;
		int size2 = list2.size() ;
		int[][] term = new int[size1*size2][2] ;
		
		for (int i=0 ;i<size1 ;i++)
		{
			int[][] arr1 = new int[1][2] ;
			arr1 = (int[][]) list1.get(i) ;
			for (int j=0 ;j<size2 ;j++)
			{
				int[][] arr2 = new int[1][2] ;
				arr2 = (int[][]) list2.get(j) ;
				
				int[][] res = new int[1][2] ;
				
				res[0][0] = arr1[0][0] * arr2[0][0] ;
				res[0][1] = arr1[0][1] + arr2[0][1] ;
				
				term[k][0] = res[0][0] ;
				term[k][1] = res[0][1] ;
				k++ ;
				
			}
		}
		for (int i=0 ;i<term.length ;i++)
		{
			for (int j=0 ;j<term.length-i-1 ;j++)
			{
				if (term[j][1] == term[j+1][1])
				{
					term[j][0] += term[j+1][0];
					 term[j+1][0] = 0 ;
					 term[j+1][1] = 0 ;
					
				}
				if (term[j][1] < term[j+1][1])
				{
					int[][] temp = new int[1][2] ;
					
					temp[0][0] = term[j][0] ;
					temp[0][1] = term[j][1] ;
					
					term[j][0] = term[j+1][0] ;
					term[j][1] =  term[j+1][1] ;
					
					term[j+1][0] = temp[0][0] ;
					term[j+1][1] =  temp[0][1] ;	
				}
			}
			
		}
		
		this.setPolynomial2('R', term);
		return term ;
		
		
	}
		
	
	

}
