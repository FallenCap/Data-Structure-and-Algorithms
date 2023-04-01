package Singly_LinkedList;

class Nodee {
	int data;
	Nodee next;
	
	Nodee(int data) {
		this.data = data;
	}
	
	public void displayNode() {
		System.out.print("{" + data + "}-->");
	}
}

public class DetectLoop {
	
	private static Nodee head;
	
	public static boolean floydsAlgo() {
		Nodee slow = head;
		Nodee fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	public static void removeCycle() {
		//detect cycle
		Nodee slow = head;
		Nodee fast = head;
		boolean cycle = false;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				cycle = true;
				break;
			}
		}
		
		if(cycle == false) {
			return;
		}
		
		//find meeting pointing
		
		slow = head;
		Nodee prev = null;
		while(slow != fast) {
			prev = fast;
			slow = slow.next;
			fast = fast.next; 
		}
		//remove cycle -> last.next = null
		prev.next = null;
	}
	
	public static void main(String[] args) {
	
		head = new Nodee(1);
		Nodee temp = new Nodee(2);
		head.next = temp;
		head.next.next = new Nodee(3);
		head.next.next.next = temp;
		
		System.out.println(floydsAlgo());
		removeCycle();
		System.out.println(floydsAlgo());

	}
}
