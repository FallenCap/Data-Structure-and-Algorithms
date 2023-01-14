package Singly_LinkedList;

import java.util.Scanner;

public class Insert {

	private Node head = null;
	
	//Method for inserting new node to a singly linked list.
		public void insert(int  data) {
			
			Node newNode = new Node();
			 newNode.data = data;
			 
			 if(head == null) {
				 head = newNode;
			 }
			 else {
				 Node last = head;
				 while(last.next != null) {
					 last = last.next;
				 }
				 last.next = newNode;
			 }
		}
		
		//Method for inserting  element  first into the linked list.
		public void insertFirst(int data) {
			Node newNode = new Node();
			
			newNode.data = data;
			newNode.next = head;
			 head = newNode;
		}
		
		//Method for inserting  element at the end of the linked list.
		public void insertLast(int data) {
			Node newNode = new Node();
			Node currentNode = head;
			
			while(currentNode.next != null) {
				currentNode = currentNode.next;
			}
			newNode.data = data;
			currentNode.next = newNode;
			newNode.next = null;
		}
		
		//Method for inserting new node at a given point.
		public void insertPosition(int pos, int data) {
			Node newNode = new Node();
			Node currentNode = head;
			
			for(int i = 1; i < pos - 1; i++) {
				currentNode = currentNode.next;
			}
			newNode.data = data;
			newNode.next = currentNode.next;
			currentNode.next = newNode;
		}
		
		//Method for display the linked list.
		public void displayList() {
			System.out.println("List (first --> last) ");
			Node current = head;
			
			while(current != null) {
				current.displayNode();
				current = current.next;
			}
			System.out.println();
		}
		
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Insert list = new Insert();
		
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		list.insert(50);
		list.insert(60);
		list.insert(70);
		list.insert(80);
		list.insert(90);
		list.insert(100);
		System.out.println("Current Node: ");
		list.displayList();
		
		System.out.println("1. Insert at first." +
										"\n2. Insert at end." +
										"\n3. Insert at a given point.");
		
		System.out.print("Enter your choice: ");
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1: {
			System.out.println("Enter the data: ");
			int data = sc.nextInt();
			list.insertFirst(data);
			list.displayList();
			break;
		}
		case 2: {
			System.out.println("Enter the data: ");
			int data = sc.nextInt();
			list.insertLast(data);
			list.displayList();
			break;
		}
		case 3: {
			System.out.println("Enter the data: ");
			int data = sc.nextInt();
			System.out.println("Enter the position");
			int pos = sc.nextInt();
			list.insertPosition(pos, data);
			list.displayList();
			break;
		}
		default: System.out.println("Wrong choice.");
		}
		sc.close();
	}
}
