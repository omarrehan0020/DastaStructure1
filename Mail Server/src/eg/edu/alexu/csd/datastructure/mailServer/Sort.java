package eg.edu.alexu.csd.datastructure.mailServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.TimeZone;

public class Sort implements ISort {
	private SinglyLinkedList o, o2;
	private static int [] in = new int[1000];
	private static int length=0,length2=0 ;
	
	private SinglyLinkedList index = new SinglyLinkedList() ;
	
	private static int[] Stacksort(String[] numbers) { 
		for (int i=0 ;i<length ;i++)
		{
			in [i] = i ;
		}
		Stack stack = new Stack();
		stack.push(0);
		stack.push(length);
		while (!stack.isEmpty()) {
			int end = (int) stack.pop();
			int start = (int) stack.pop();
			if (end - start < 2) {
				continue;
				} 
			int p = start + ((end - start) / 2); 
			p = partition(numbers, p, start, end); 
			stack.push(p + 1);
			stack.push(end);
			stack.push(start); 
			stack.push(p);
			}
		return in ;
		}

	
	private static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		}
	private static void intswap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		}
	private static int partition(String[] input, int position, int start, int end) {
		int l = start; 
		int h = end - 2; 
		String piv = input[position]; 
		swap(input, position, end - 1);
		intswap(in, position, end - 1);
		while (l < h) 
		{ 
			if (input[l].compareTo(piv) < 0) 
			{ 
				l++;
			}
			else if (input[h].compareTo(piv) >= 0)
			{
				h--; 
			} 
			else
			{ 
				swap(input, l, h); 
				intswap(in, l, h); 
				
			}
		}
		int idx = h; 
		if (input[h].compareTo(piv) < 0)
		{
			idx++;
			} 
		swap(input, end - 1, idx);
		intswap(in, end - 1, idx);
		return idx;
		}

	
	
	private static int[] Stacksort(LocalDateTime[] numbers) { 
		for (int i=0 ;i<length ;i++)
		{
			in [i] = i ;
		}
		Stack stack = new Stack();
		stack.push(0);
		stack.push(length);
		while (!stack.isEmpty()) {
			int end = (int) stack.pop();
			int start = (int) stack.pop();
			if (end - start < 2) {
				continue;
				} 
			int p = start + ((end - start) / 2); 
			p = partition(numbers, p, start, end); 
			stack.push(p + 1);
			stack.push(end);
			stack.push(start); 
			stack.push(p);
			}
		return in ;
		}

	
	private static void swap(LocalDateTime[] arr, int i, int j) {
		LocalDateTime temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		}
	
	private static int partition(LocalDateTime[] input, int position, int start, int end) {
		int l = start; 
		int h = end - 2; 
		LocalDateTime piv = input[position]; 
		swap(input, position, end - 1);
		intswap(in, position, end - 1);
		while (l < h) 
		{ 
			if (input[l].compareTo(piv) < 0) 
			{ 
				l++;
			}
			else if (input[h].compareTo(piv) >= 0)
			{
				h--; 
			} 
			else
			{ 
				swap(input, l, h); 
				intswap(in, l, h); 
				
			}
		}
		int idx = h; 
		if (input[h].compareTo(piv) < 0)
		{
			idx++;
			} 
		swap(input, end - 1, idx);
		intswap(in, end - 1, idx);
		return idx;
		}


	 private SinglyLinkedList indexFileToLinkedList (String s) {
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(s));
				String line = reader.readLine();
				while (line != null) {
					this.index.add(line);
					line = reader.readLine();	
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return this.index ;
		}
	
	
	public void Datesorting(String indexpath) throws ParseException, IOException {
		int i=0,k=0 ;
		//store  index file into single linked list
	    o = this.indexFileToLinkedList(indexpath) ;
	    String[] arr = new String[1000] ;
	    //read linked list element by element and get all dates in an array
		while (i < o.size()) {
			String line =(String) o.get(i++);
			String[] splited = line.split(" ");
			arr[k++] = splited[3] +"T" + splited[4] ;
			length++ ;
		}
		
		LocalDateTime date[] = new LocalDateTime[length] ;
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
		 for(i=0;i<length;i++)
	        {
			  date[i] = LocalDateTime.parse(arr[i]);
	        }
		 
		//store the new sorting in single linked list 
		int[] changedIndex = Stacksort(date) ;
		 SinglyLinkedList newLinkedList = new SinglyLinkedList() ;
		    for (int j=length-1 ;j>=0 ;j--)
		    {
		    	newLinkedList.add(o.get(changedIndex[j]));
		    }
		    
		    o.clear();
		    //clear index file
			FileWriter fwOb = new FileWriter(indexpath); 
	        PrintWriter pwOb = new PrintWriter(fwOb, false);
	        pwOb.flush();
	        pwOb.close();
	        fwOb.close();
	        
	        //store new sorting in index file 
	        File indextxt = new File(indexpath) ;
	       int n=0 ;
	       while (n < newLinkedList.size())
	       {
	    	   try
		        {
	       		String str =(String) newLinkedList.get(n++) ;
			        FileWriter file = new FileWriter(indextxt.getAbsoluteFile(), true);
				    BufferedWriter buffered = new BufferedWriter(file);
				    buffered.write(str);
				    buffered.newLine();
				    buffered.close();
				    file.close();
			     }
			     catch(IOException ex) {
			           ex.printStackTrace();
			      }
	       }
		    
	        

	}

	
	public void Subjectsorting(String indexpath) throws IOException {
		int i=0,k=0 ;
		//store  index file into single linked list
	    o = this.indexFileToLinkedList(indexpath) ;
	    String[] arr = new String[1000] ;
	    //read linked list element by element and get all senders in an array
		while (i < o.size()) {
			String line =(String) o.get(i++);
			String[] splited = line.split(" ");
			arr[k++] = splited[0] ;
			length++ ;
		}
		
		//store the new sorting in single linked list 
		int[] changedIndex = Stacksort(arr) ;
	    SinglyLinkedList newLinkedList = new SinglyLinkedList() ;
	    for (int j=0 ;j<length ;j++)
	    {
	    	newLinkedList.add(o.get(changedIndex[j]));
	    }
	    
	    o.clear();
	  //clear index file
		FileWriter fwOb = new FileWriter(indexpath); 
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
        
        //store new sorting in index file 
        File indextxt = new File(indexpath) ;
       int n=0 ;
       while (n < newLinkedList.size())
       {
    	   try
	        {
       		String str =(String) newLinkedList.get(n++) ;
		        FileWriter file = new FileWriter(indextxt.getAbsoluteFile(), true);
			    BufferedWriter buffered = new BufferedWriter(file);
			    buffered.write(str);
			    buffered.newLine();
			    buffered.close();
			    file.close();
		     }
		     catch(IOException ex) {
		           ex.printStackTrace();
		      }
       }
	    
		

	}
	
	
	public void sendersorting(String indexpath) throws IOException {
		int i=0,k=0 ;
		//store  index file into single linked list
	    o = this.indexFileToLinkedList(indexpath) ;
	    String[] arr = new String[1000] ;
	    //read linked list element by element and get all senders in an array
		while (i < o.size()) {
			String line =(String) o.get(i++);
			String[] splited = line.split(" ");
			arr[k++] = splited[1] ;
			length++ ;
		}
		
		//store the new sorting in single linked list 
		int[] changedIndex = Stacksort(arr) ;
	    SinglyLinkedList newLinkedList = new SinglyLinkedList() ;
	    for (int j=0 ;j<length ;j++)
	    {
	    	newLinkedList.add(o.get(changedIndex[j]));
	    }
	    
	    o.clear();
	    
	  //clear index file
		FileWriter fwOb = new FileWriter(indexpath); 
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
        
        //store new sorting in index file 
        File indextxt = new File(indexpath) ;
       int n=0 ;
       while (n < newLinkedList.size())
       {
    	   try
	        {
       		String str =(String) newLinkedList.get(n++) ;
		        FileWriter file = new FileWriter(indextxt.getAbsoluteFile(), true);
			    BufferedWriter buffered = new BufferedWriter(file);
			    buffered.write(str);
			    buffered.newLine();
			    buffered.close();
			    file.close();
		     }
		     catch(IOException ex) {
		           ex.printStackTrace();
		      }
       }
	    
		

	}
	
	
	private  int binarySearch(String[] A, String x)
	{
		// search space is A[left..right]
		int left = 0, right = length2 - 1;

		// till search space consists of at-least one element
		while (left <= right)
		{
			// we find the mid value in the search space and
			// compares it with key value

			int mid = (left + right) / 2;

			// overflow can happen. Use:
			// int mid = left + (right - left) / 2;
			// int mid = right - (right - left) / 2;

			// key value is found
			if (x.equals(A[mid])) {
				return mid;
			}

			// discard all elements in the right search space
			// including the mid element
			else if (x.compareTo(A[mid]) < 0) {
				right = mid - 1;
			}

			// discard all elements in the left search space
			// including the mid element
			else {
				left = mid + 1;
			}
		}
		
		return -1 ;
	
	
	}
	
	public String SubjectSearch(String indexpath,String search) throws IOException {
		this.Subjectsorting(indexpath);
		int i=0,k=0 ;
		//store  index file into single linked list
	    o2 = this.indexFileToLinkedList(indexpath) ;
	    String[] arr = new String[1000] ;
	    //read linked list element by element and get all subjects in an array
		while (i < o2.size()) {
			String line =(String) o2.get(i++);
			String[] splited = line.split(" ");
			arr[k++] = splited[0] ;
			length2++ ;
		}
		 int det = this.binarySearch(arr, search) ;
		 
		 String line =(String) o2.get(det) ;
		 return line ;
	}
	
	
	
	
	
}
	
	


