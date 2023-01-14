package Circular_Doubly_LinkedList;

import java.util.Scanner;

public class Insert {
	
	private Node head;
	private Node tail;
	
	//Method for inserting new node to a singly linked list.
	public void insert(int  data) {
		Node newNode = new Node();
		 newNode.data = data;
		 if(head == null) {
			 head = newNode;
			 tail = newNode;
			 newNode.next = head;
			 newNode.prev = head;
		 }
		 else {
			 tail.next = newNode;
			 newNode.prev = tail;
			 tail = newNode;
			 tail.next = head;
			 head.prev = tail; 
		 }
	}
	
	//Method for inserting node at begining.
	public void insertFirst(int data) {
		Node newNode = new Node();
		 newNode.data = data;
		 tail.next = newNode;
		 newNode.prev = tail;
		 newNode.next = head;
		 head.prev = newNode;
		 head = newNode;
	}
	
	//Method for inserting node at end.
	public void insertLast(int data) {
		Node newNode = new Node();
		newNode.data = data;
		tail.next = newNode;
		newNode.prev = tail;
		newNode.next = head;
		head.prev = newNode;
		tail = newNode;
	}
	
	//Method for inserting new node at a given point.
	public void insertPosition(int pos, int data) {
		Node newNode = new Node();
		Node currentNode = head;
		for(int i = 1; i < pos - 1; i++) {
			currentNode= currentNode.next;
		}
		newNode.data=data;
		Node nextNode = currentNode.next;
		newNode.next = currentNode.next;
		currentNode.next = newNode;
		newNode.prev = currentNode;
		nextNode.prev = newNode;
	}
	
	//Method for display the linked list.
	public void displayList() {
		System.out.println("List (first --> last-->first) ");
		Node current = head;
		do {
			current.displayNode();
			current = current.next;
		}while(current != head);
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
