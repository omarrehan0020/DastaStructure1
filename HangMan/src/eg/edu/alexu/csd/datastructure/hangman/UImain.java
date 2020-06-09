package eg.edu.alexu.csd.datastructure.hangman;

import java.util.Scanner;

public class UImain {

	private static void game () throws Exception {
		System.out.println("Choose level : ");
		System.out.println("1-difficult");
		System.out.println("2-easy");
		Scanner s = new Scanner(System.in) ;
		int x = s.nextInt() ;
		Hangman p = new Hangman() ;
		
		
		switch(x)
		{
		case 1 : p.setMaxWrongGuesses(4); break ;
		case 2 : p.setMaxWrongGuesses(10); break ;
		default : System.out.println("choose valid number : ") ;
		          game() ;
		}
		
		
		char c ='.' ;
		p.selectRandomSecretWord() ;
		p.guess(c) ;
	}
	public static void main(String[] args) throws Exception {
		game() ;
	}

}
