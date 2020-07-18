package eg.edu.alexu.csd.datastructure.stack;
import java.util.Scanner;
/**
 * main for user to test the stack
 * @author future
 *
 */

public class UIStackmain {

	public static void main(String[] args) {
		Stack mystack = new Stack();
		try (Scanner scan = new Scanner(System.in)) {
			int x = 0;
			final int x1 = 1, x2 = 2, x3 = 3, x4 = 4, x5 = 5, x6 = 6;
			Object element;
			while (true) {
				System.out.println("Enter the operation you want");
				System.out.println("1-Push");
				System.out.println("2-Pop");
				System.out.println("3-Peek");
				System.out.println("4-Get size");
				System.out.println("5-Check if empty");
				System.out.println("6-Exit");
				x = scan.nextInt();
				switch (x) {
					case x1:
						System.out.println("enter the value:");
						element = scan.next();
						mystack.push(element);
						break;
					case x2:
					
						if (mystack.isEmpty()) {
							System.out.println("Stack"
									+ " is empty");
						} else {
							element = mystack.pop();
							System.out.println(element);
						}
						break;
					case x3:
						if (mystack.isEmpty()) {
							System.out.println("Stack"
									+ " is empty");
						} else {
							element = mystack.peek();
							System.out.println(element);
						}
						break;
					case x4:
						element = mystack.size();
						System.out.println(element);
						break;
					case x5:
						if (mystack.isEmpty()) {
							System.out.println("Stack"
									+ " is empty");
						} else {
							System.out.println("Stack"
								+ " is not empty");
						}
						break;
					case x6:
						return;
					default: System.out.println("please "
							+ "enter a valid number");
				}
			}
		}
	}
	}



