package week4_backtracking;

import java.util.ArrayList;
import java.util.List;

/*Problem Statement
Given a string s, a partitioning of the string is a palindrome partitioning 
if every sub-string of the partition is a palindrome. Return all possible palindrome 
partitioning of s.

Example 1:
Input:
"nnwesipil"
Output:
[["n", "n", "w", "e", "s", "i", "p", "i", "l"], 
["n", "n", "w", "e", "s", "ipi", "l"],
["nn", "w", "e", "s", "i", "p", "i", "l"],
["nn", "w", "e", "s", "ipi", "l"]]
Example 2:
Input:

"aab"

Output:

[["a", "a", "b"],

["aa", "b"]]

Constraints:
1 <= n <= 15*/

public class palindromePartitioning {
	public static void main(String[] args) {
		
		List<List<String>> resultList=new ArrayList<>();
		String s="nnwesipil";
		
		palindromePartionaningHelper(s,0,resultList,new ArrayList<>());
		
		System.out.println(resultList);
		
	}

	private static void palindromePartionaningHelper(String s, int index, List<List<String>> resultList, List<String> curr) {
		if(index==s.length()) {
			List<String> currCopy=new ArrayList<>(curr);
			resultList.add(currCopy);
			return;
		}
		
		for(int i=index;i<s.length();i++) {
			if(isPalindrome(s,index,i)) {
				curr.add(s.substring(index,i+1));
				palindromePartionaningHelper(s,i+1,resultList,curr);
				curr.remove(curr.size()-1);
			}
		}
		
	}

	private static boolean isPalindrome(String s, int l, int r) {
		while(l<=r) {
			if(s.charAt(l)!=s.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
}
