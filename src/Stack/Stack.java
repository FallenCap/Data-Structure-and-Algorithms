package Stack;

import java.util.*;

public class Stack {
	public static Scanner sc = new Scanner(System.in);
	
	private Node top;
	private int height = 0;
	
	//Method for push function.
	public void push (int data) {
		Node newNode = new Node();
		newNode.data = data;
		if(height == 0) {
			top = newNode;
		}
		else {
			newNode.next = top;
			top = newNode;
		}
		height++;
		
	}
	
	//Method for pop function.
	public Node pop() {
		if(height == 0) {
			return null;
		}
		Node temp = top;
		top = top.next;
		temp.next = null;
		height--;
		return temp;
	}
	
	//Method for print the stack.
	public void printStack() {
		Node temp = top;
		System.out.println("\nStack:");
		do {
			System.out.println("{" + temp.data + "}");
			temp = temp.next;
		} while(temp != null);
	}
	
	//Method to show the top element.
	public void getTop() {
		System.out.println("\nTop: " +  top.data);
	}
	
	//Method to show the height of the stack.
	public void getHeight() {
		System.out.println("\nHeight: " + height);
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		
		boolean check = true;
		while(check) {
			System.out.println("1. Push." + 
					"\n2. Pop." + 
					"\n3. Show the top." +
					"\n4. Show the height.");

			System.out.println("\nEnter your choice:");
			int choice = sc.nextInt();
			switch(choice) {
			case 1: {
				System.out.print("\nHow many times you want to push: ");
				int n = sc.nextInt();
				int a;
				System.out.println("\nEnter datas: ");
				for(int i = 1; i <= n; i++) {
					a = sc.nextInt();
					stack.push(a);
				}
				stack.printStack();
				break;
			}
			case 2: {
				System.out.print("\nHow many times you want to pop: ");
				int n = sc.nextInt();
				for(int i = 1; i <= n; i++) {
					stack.pop();
				}
				stack.printStack();
				break;
			}
			case 3: {
				stack.getTop();
				break;
			}
			case 4: {
				stack.getHeight();
				break;
			}
			default : {
				System.out.println("Wrong choice!");
				check=false;
				break;
			}
			}
		}
	}
}
