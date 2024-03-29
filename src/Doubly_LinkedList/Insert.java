package Doubly_LinkedList;

import java.util.Scanner;

public class Insert {
	
private Node head = null;
	
	//Method for inserting new node to a doubly linked list.
	public void insert(int data) {
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
			newNode.prev = last;
		}
	}
	
	//Method for inserting  element  first into the linked list.
	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		Node firstNode = head;
		newNode.next = firstNode;
		firstNode.prev = newNode;
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
		newNode.prev = currentNode;
	}
	
	//Method for inserting new node at a givien point.
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
			System.out.println("List (first <--> last) ");
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
		
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.insert(8);
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
