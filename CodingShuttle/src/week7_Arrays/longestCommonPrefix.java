package week7_Arrays;

import java.util.Arrays;

/*Problem Statement
Write a function to find the longest common prefix string amongst an array of strings. 
If there is no common prefix, return an empty string.

Example 1:
Input:
["hello","help","heskel"]

Output:
“he”

Example 2:
Input:
["prime","protect","promo"]

Output:
“pr”*/
public class longestCommonPrefix {
	public static void main(String[] args) {
		String strs[] = { "hello", "help", "heskel" };

		Arrays.sort(strs);
		int n = strs.length;
		int minlength = Math.min(strs[0].length(), strs[n-1].length());
		
		String s="";
		for (int i = 0; i < minlength; i++) {
			char ch = strs[0].charAt(i);
			if(strs[0].charAt(i)==strs[n-1].charAt(i)) {
				s+=strs[0].charAt(i);
			}
		}
		System.out.println(s);
	}
}
