package week4_backtracking;

import java.util.ArrayList;
import java.util.List;

/*Problem Statement
Given an integer N representing the number of pairs of parentheses, The goal is to produce all possible combinations of balanced
and well-formed brackets. Return the answer according to sorted order where '(' comes first and then ')'.

Example 1:
Input: 
n = 3
Output: 
[((())), (()()), (())(), ()(()), ()()()]
Example 2:
Input: 
n = 2
Output: 
[(()), ()()]
Constraints:
1 ≤ N ≤ 12*/

public class GenerateParenthesis {
	public static void main(String[] args) {
		int n=11;
		List<String> parenthesisList=new ArrayList<String>();
		generateParenthesis(n,0,0,parenthesisList,"");
		System.out.println(parenthesisList);
	}

	private static void generateParenthesis(int n, int l, int r, List<String> parenthesisList,String curr) {
		if(l==n && r==n) {
			parenthesisList.add(curr);
			return;
		}
		
		if(l<n) {
			curr=curr+"(";
			generateParenthesis(n,l+1,r,parenthesisList,curr);
			curr=curr.substring(0,curr.length()-1); //Backtracking step to remove the added ( to current string
		}
		
		if(r<l) {
			curr=curr+")";
			generateParenthesis(n,l,r+1,parenthesisList,curr); 
			//No Need of backtracking here as curr is never used after this code
		}
		
	}
}
