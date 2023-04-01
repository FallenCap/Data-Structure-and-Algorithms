package Singly_LinkedList;

public class Palindrome {
	
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
	
	public Node findMid(Node head) {
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public boolean checkPalindrome() {
		Node mid = findMid(head);
		
		//Reversing the second half
		Node prev = null;
		Node curr = mid;
		Node next;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		Node right = prev;
		Node left = head;
		
		while(right != null) {
			if(left.data != right.data) {
				return false;
			}
			left = left.next;
			right = right.next;
		}
		return true;
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
		
		Palindrome list = new Palindrome();
		list.insert(1);
		list.insert(0);
		list.insert(0);
		list.insert(0);
		list.insert(1);
		list.displayList();
		
		if(list.checkPalindrome()) {
			System.out.println("Palindrome.");
		} else {
			System.out.println("Not palindrome.");
		}

	}

}
