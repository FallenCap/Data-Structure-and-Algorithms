package Doubly_LinkedList;

import java.util.Scanner;

public class Delete {
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
	
	//Method for deletinng the first node of the linked list.
	public void deleteFirst() {
		Node firstNode = head; 
		head = firstNode.next;
		head.prev = null;
	}
	
	//Method for deleting the last element from the linked list.
	public void deleteLast() {
		Node currentNode = head;
		while(currentNode.next.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = null;
	}
	
	//Method to delete node from a given position.
	public void deletePosition(int pos) {
		Node currentNode = head;
			
		for(int i = 1 ; i < pos - 1; i++) {
			currentNode = currentNode.next;
		}
		Node nextNode = currentNode.next.next;
		currentNode.next = nextNode; 
		nextNode.prev = currentNode;
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
		
		Delete list = new Delete();

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
		
		System.out.println("1. Delete at first." +
				"\n2. Delete at end." +
				"\n3. Delete at a given point.");

		System.out.print("Enter your choice: ");
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1: {
		list.deleteFirst();
		list.displayList();
		break;
		}
		case 2: {
		list.deleteLast();
		list.displayList();
		break;
		}
		case 3: {
		System.out.println("Enter the position:");
		int pos = sc.nextInt();
		list.deletePosition(pos);
		list.displayList();
		break;
		}
		default: System.out.println("Wrong choice.");
		}
		sc.close();
	}

}
