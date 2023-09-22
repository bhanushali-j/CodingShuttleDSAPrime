package ProblemOfTheDay;

/*Problem Statement
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, 
leaving only distinct numbers from the original list. Return the linked list sorted as well.

Example 1:
Input:
head = [-1, 1, 2, 3, 3, 3]

Output:
[-1, 1, 2]

Example 2:
Input:
head = [-1, 1, 2, 2]

Output:
[-1, 1]*/
public class RemoveDuplicateFromList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(3);
		ListNode l6 = new ListNode(6);

		head.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		
	        ListNode temp=new ListNode(0);
	        temp.next=head;
	        ListNode prev=temp;

			while (head != null) {
				if (head.next != null && head.val == head.next.val) {
					while (head.next != null && head.val == head.next.val) {
						head = head.next;
					}
					prev.next = head.next;
				} else {
					prev = prev.next;
				}
				head = head.next;	
			}
		
		traverse(temp.next);
	}
	
	public static void traverse(ListNode head) {
		while(head!=null) {
			System.out.print(head.val+"-> ");
			head=head.next;
		}
	}
}	
