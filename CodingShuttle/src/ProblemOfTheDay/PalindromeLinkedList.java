package ProblemOfTheDay;

/*Problem Statement
Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, indicating if 
the palindrome is a palindrome or not.

Example 1:
Input: 
1 -> 2 -> 3 -> 2 -> 1

Output: 
1

Example 2:
Input: 
1 -> 2 -> 3 -> 2 -> 5

Output: 
0*/

public class PalindromeLinkedList {
	public static void main(String[] args) {

		ListNode A = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(0);
//		ListNode l5 = new ListNode(1);
//		ListNode l6 = new ListNode(6);

		A.next = l2;
		l2.next = l3;
		l3.next = l4;
//		l4.next = l5;
//		l5.next = l6;
		
		int isPalindromeLinkedList=isPalindromeLL(A);
		System.out.println(isPalindromeLinkedList);
		
		
	}

	private static int isPalindromeLL(ListNode A) {
		// Find the mid of Linkedist
				ListNode slow = A;
				ListNode fast = A;

				while (fast != null && fast.next != null) {
					slow = slow.next;
					fast = fast.next.next;
				}

				// Reverse from the mid
				ListNode reversedFromMid=reverse(slow);
				
				System.out.println(reversedFromMid.val);

				// check from start with reverse from mid
				while (reversedFromMid.next != null) {
					if (A.val != reversedFromMid.val) {
						return 0;
					}
					A=A.next;
					reversedFromMid=reversedFromMid.next;
				}

				return 1;

	}

	public static ListNode reverse(ListNode head) {

		ListNode curr = head.next;
		ListNode prev = head;
		head.next = null;
		while (curr!= null) {
			ListNode temp = curr.next;
			curr.next=prev;
			prev = curr;
			curr = temp;
		}
		
		return prev;
	}
}
