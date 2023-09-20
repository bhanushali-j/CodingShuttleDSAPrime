package ProblemOfTheDay;

/*Problem Statement
You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.

The middle node of a linked list of size n is the [n/2]th node from the start using 0-based indexing, where [x]
denotes the largest integer less than or equal to x.

Example 1:
Input:
head = [1, 2, 3, 4, 5]

Output:
[1, 2, 4, 5]

Example 2:
Input:
head = [2, 4, 8, 6]

Output:
[2, 4, 6]*/
class ListNode {
	int val;
	ListNode next;

	ListNode() {
		val = 0;
		next = null;
	}

	ListNode(int val) {
		this.val = val;
		next = null;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class DeleteMiddleNodeOfLinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);

		head.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;

		deleteMiddleNode(head);

		while (head != null) {
			System.out.print(head.val + "-> ");
			head = head.next;
		}

	}

	private static void deleteMiddleNode(ListNode head) {

		ListNode slow = head.next;
		ListNode fast = head.next.next;

		while (fast != null && fast.next != null) {
			head = head.next;
			slow = slow.next;
			fast = fast.next.next;
		}

		System.out.println("Head value is : " + head.val);
		head.next = slow.next;
		System.out.println("Middle Node value is : " + slow.val);
	}

}
