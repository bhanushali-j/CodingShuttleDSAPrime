package ProblemOfTheDay;

/*
Problem Statement
Given a linked list A, remove the B-th node from the end of the list and return its head.
Consider the linked list 1->2->3->4->5 with B = 2. The linked list changes to 1->2->3->5 after the second node at the very end is removed.

NOTE: The list's first node should be eliminated if B exceeds the list's size.
NOTE: Try doing it using constant additional space.

Example 1:
Input:
A = 1 -> 2 -> 3 -> 4 -> 5
B = 3

Output:
1 -> 2 -> 4 -> 5

Explanation:
3 is the third last element.

Example 2:
Input:
A = 1 -> 2 -> 3 -> 4 -> 5
B = 7

Output:
2 -> 3 -> 4 -> 5*/
public class RemoveNthNodeFromListEnd {
	public static void main(String[] args) {
		ListNode A = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
//		ListNode l6 = new ListNode(6);

		A.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
//		l5.next = l6;
		
		int B=3;
		
		ListNode result=removeNthNodeFromListEndOptimized(A,3);
		
		while(result!=null) {
			System.out.print(result.val+"-> ");
			result=result.next;
		}
		
	}

	private static ListNode removeNthNodeFromListEnd(ListNode A, int B) {

		int count = 0;
		ListNode Temp = A;
		ListNode result=Temp;
		while (A != null) {
			count++;
			A = A.next;
		}
		if(B>=count){
          return result.next;
        }
		System.out.print(count);
		int index = count - B;
		for(int i=1;i<index;i++) {
			Temp=Temp.next;
		}
		Temp.next=Temp.next.next;
		
		return result; 
	}
	
	//Better solution using two pointers
	private static ListNode removeNthNodeFromListEndOptimized(ListNode A, int B) {

		int count = 0;
		ListNode temp = new ListNode(0);
		temp.next=A;
		ListNode first=temp;
		ListNode second=temp;
				
		for(int i=0;i<B;i++) {
			first=first.next;
		}
		
		//B is greater than length of entire Linked List
		if(first==null) {
			return A.next;
		}
		
		while(first.next!=null) {
			first=first.next;
			second=second.next;
		}
		
		second.next=second.next.next;
		
		return temp.next; 
	}
	
}
