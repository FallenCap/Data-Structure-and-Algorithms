package Singly_LinkedList;

 class Swap {
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
		
		public void swapPair() {
			Node temp = head;
			Node nextNode = temp.next;
			
			
			while(temp != null) {
				int s = temp.data;
				temp.data = nextNode.data;
				nextNode.data = s;
				temp = temp.next.next;
				nextNode = nextNode.next;
			}
			
		}
		public void displayList() {
			System.out.println("List (first --> last) ");
			Node current = head;
			
			while(current != null) {
				current.displayNode();
				current = current.next;
			}
			System.out.println();
		}
}

public class SwapPairwise {

	public static void main(String[] args) {
		Swap list = new Swap();
		
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.insert(8);
		
		list.displayList();
		
		list.swapPair();
		list.displayList();
	}

}
