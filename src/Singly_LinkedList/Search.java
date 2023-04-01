package Singly_LinkedList;

import java.util.Scanner;

public class Search {
	
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
		
		public int searchData(int key) {
			int pos = 0;
			Node temp = head;
			 while(temp.next != null) {
				 if(temp.data == key) {
					 return pos;
				 }
				 temp = temp.next;
				 pos++;
			 }
			 
			 return -1;
			
		}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Search list = new Search();
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
		
		System.out.print("Enter the data you want ot search: ");
		int key = sc.nextInt();
		
		int ans = list.searchData(key);
		
		if(ans == -1) {
			System.out.println("The element is not in the list.");
		} else {
			System.out.println("The index of the element:" + ans);
		}
		
		sc.close();
	}

}
