package Singly_LinkedList;

public class Reverse {
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
	
	public void reverse() {
		Node prev = null;
		Node current = head;
		Node next;
		
		while(current != null) {
			 next = current.next;
			 current.next = prev;
			 prev = current;
			 current = next;
		}
		head = prev;
		
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
		Reverse list = new Reverse();
		list.insert(0);
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.insert(8);
		list.insert(9);
		list.displayList();
		list.reverse();
		list.displayList();

	}

}
