package Singly_LinkedList;
import java.util.*;

public class MergeSortLinkedList {
	
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
		
		//method to determine mid of the linked list
		public Node getMid(Node head) {
			Node slow = head;
			Node fast = head.next;
			
			while(fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			
			return slow;
		}
		
		
		//Method for merge
		public Node merge(Node head1, Node head2) {
			Node mergedLL = new Node();
			mergedLL.data = -1;
			Node temp = mergedLL;
			
			while(head1 != null && head2 != null) {
				if(head1.data <= head2.data) {
					temp.next = head1;
					head1 = head1.next;
					temp = temp.next;
				} else {
					temp.next = head2;
					head2 = head2.next;
					temp = temp.next;
				}
			}
			
			while(head1 != null) {
				temp.next = head;
				head1 = head1.next;
				temp = temp.next;
			}
			while(head2 != null) {
				temp.next = head;
				head2 = head2.next;
				temp = temp.next;
			}
			
			return mergedLL.next;
		}
		
		//Method for merge sort.
		public Node mergeSort(Node head) {
			if(head == null || head.next == null) {
				return head;
			}
			//find mid
			Node mid = getMid(head);
			
			//left & right merge sort
			Node rightHead = mid.next;
			mid.next = null;
			Node newLeft = mergeSort(head);
			Node newRight = mergeSort(rightHead);
			
			//merge
			return merge(newLeft, newRight);
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
		MergeSortLinkedList list = new MergeSortLinkedList();

		list.insert(20);
		list.insert(10);
		list.insert(60);
		list.insert(80);
		list.insert(50);
		list.insert(70);
		list.insert(30);
		list.insert(90);
		list.insert(40);
		list.insert(100);
		System.out.println("Current Node: ");
		list.displayList();	
		 list.head = list.mergeSort(list.head);
		 System.out.println("After Merge sort:");
		 list.displayList();
		
		
	}

}
