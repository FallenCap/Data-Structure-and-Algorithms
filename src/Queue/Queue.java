package Queue;

import java.util.*;

public class Queue {
	public static Scanner sc = new Scanner(System.in);
	
	private Node first;
	private Node last;
	private int length = 0;
	
	//Method for enqueue from the Queue.
	public void enqueue(int data) {
		Node newNode = new Node();
		newNode.data = data;
		
		if(length == 0) {
			first = newNode;
			last = newNode;
		}
		else {
			last.next = newNode;
			last = newNode;
		}
		length++;
	}
	
	//Method for dequeue from the queue.
		public Node dequeue() {
			if(length == 0 ) {
				return null;
			}
			Node temp = first;
			if(length == 1) {
				first = null;
				last = null;
			}
			else {
				first = first.next;
				temp.next = null;
			}
			length--;
			return temp;
		}
	
	//Method to print the queue
	public void printQueue() {
		Node temp = first;
		System.out.println("\nQueue: ");
		do {
			System.out.print("{" + temp.data + "}-->");
			temp = temp.next;
		} while(temp != null);
		System.out.println("");
	}
	
	//Method to show the first element.
	public void getFirst() {
		System.out.println("\nFirst: " + first.data);
	}
	
	//Method to show the last element.
	public void getLast() {
		System.out.println("\nLast: " + last.data);
	}
	
	//Method to show the length of the queue.
	public void getLength() {
		System.out.println("\nLength: " + length);
	}

	public static void main(String[] args) {

		Queue queue = new Queue();
		
		boolean check = true;
		while(check) {
			System.out.println("1. Enqueue." + 
					"\n2. Dequeue." + 
					"\n3. Show the first element." +
					"\n4. Show the last element." +
					"\n5. Show the length.");

			System.out.println("\nEnter your choice:");
			int choice = sc.nextInt();
			switch(choice) {
			case 1: {
				System.out.print("\nHow many times you want to enqueue: ");
				int n = sc.nextInt();
				int a;
				System.out.println("\nEnter datas: ");
				for(int i = 1; i <= n; i++) {
					a = sc.nextInt();
					queue.enqueue(a);
				}
				queue.printQueue();
				break;
			}
			case 2: {
				System.out.print("\nHow many times you want to dequeue: ");
				int n = sc.nextInt();
				for(int i = 1; i <= n; i++) {
					queue.dequeue();
				}
				queue.printQueue();
				break;
			}
			case 3: {
				queue.getFirst();
				break;
			}
			case 4: {
				queue.getLast();
				break;
			}
			case 5: {
				queue.getLength();
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
