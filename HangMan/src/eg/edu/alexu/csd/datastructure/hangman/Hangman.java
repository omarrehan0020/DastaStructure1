package eg.edu.alexu.csd.datastructure.hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;



public class Hangman implements IHangman {
	
	 private  int i=0 ;
	 private static String [] arr  ;
	 private BufferedReader br;
	 private static String [] word ;
	 private Random rand ;
	 private static String secret = "" ;
	 private static char[] ss ;
	 private static Scanner scan;
	 private int wrong  ;
	 private static int correct = 0 ;
	

	private String[] convertText () throws IOException {
		File file = new File ("dictionary.txt") ;
		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			arr = new String [109585];
			while ((line  = br.readLine()) != null) {
			arr[i] = line ;
			i++ ;
			
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	
		return arr ;
	}

	@Override
	public void setDictionary(String[] words) {
		word = words ;
	}

	@Override
	public String selectRandomSecretWord() {
		Hangman oo = new Hangman() ;
		try {
			oo.setDictionary(oo.convertText());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 rand = new Random() ;
		int n = rand.nextInt(word.length) ;
		secret = word[n] ;
		ss = new char[secret.length()] ;
		for (int i=0 ;i<secret.length() ;i++)
		{
			ss[i] = '-' ;
		}
		System.out.println(ss) ;
		return secret ;
	}

	
	@Override
	public String guess(Character c) throws Exception {
		
		if (c == null)
			throw null ;
		
		boolean q = true ;
		char [] x = secret.toCharArray() ;
		while (correct < secret.length() && wrong > 0 ) {
			 scan = new Scanner(System.in) ;
			c = scan.next().charAt(0) ;
			for(int i=0 ;i<secret.length() ;i++)
			{
				if (x[i] == c)
				{
					x[i] = ' ' ;
					ss[i] = c ;
					correct++ ;
					q = false ;
					System.out.println(ss) ;
				
				}
			}
			if (q)
			{
				System.out.println(ss) ;
				wrong-- ;
			}
			q = true ;
		}
		
		
		if (wrong==0)
			System.out.println("you lost");
		if (correct == secret.length())
			System.out.println("you won");
		
		String secret = new String(ss);
		return secret ;
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		 wrong = max ;

	}

	
}
