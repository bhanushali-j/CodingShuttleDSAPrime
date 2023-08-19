package week3_Recursion;

/*Problem Statement
Given a string S, check if it is palindrome or not.

Example 1:
Input: S = "racecar"
Output: 1
Explanation: S is a palindrome*/

public class palindromeString {
	public static void main(String[] args) {
		System.out.println(isPalindromeRecursion("tot",0,2));
	}

	public static boolean isPalindrome(String str) {
		int l = 0;
		int r = str.length() - 1;
		while (l < r) {
			if (str.charAt(l) != str.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
	
	public static boolean isPalindromeRecursion(String str,int l, int r) {
//		int l = 0;
//		int r = str.length() - 1;
		while (l <= r) {
			if (str.charAt(l) != str.charAt(r)) {
				return false;
			}
			return isPalindromeRecursion(str,l++,r--);
		}
		return true;
	}
}
