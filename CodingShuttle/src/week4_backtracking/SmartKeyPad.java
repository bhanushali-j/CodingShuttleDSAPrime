package week4_backtracking;

import java.util.ArrayList;
import java.util.List;

/*Problem Statement
You are given a string digits that contains digits from [2 - 9], 
both inclusive. Return all possible letter combinations that the number could
 represent in sorted order. 

Example 1:

Input: 
digits = "23"
Output: 
["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: 
digits = "9"
Output: 
["w", "x", "y", "z"]
Constraints:*/
/*0 <= digits.size <= 4*/

public class SmartKeyPad {
	public static void main(String[] args) {
		
		String digits="23";
		String letters[]={
		        "",
		        "",
		        "abc",
		        "def",
		        "ghi",
		        "jkl",
		        "mno",
		        "pqrs",
		        "tuv",
		        "wxyz"
		      };

		List<String> resultList=new ArrayList<>();
		smartKeyPadHelper(digits, letters, 0, resultList,"");
		System.out.println(resultList);
	}

	private static void smartKeyPadHelper(String digits, String[] letters, int index, List<String> resultList,String curr) {
		if(index==digits.length()) {
			resultList.add(curr);
			return; 
		}
		
		int button=digits.charAt(index)-'0';
		String buttonValues=letters[button];
		
		for(int i=0;i<buttonValues.length();i++) {
			curr=curr+buttonValues.charAt(i);
			smartKeyPadHelper(digits,letters,index+1,resultList,curr);
			curr=curr.substring(0,curr.length()-1); //backtrack
		}
	}
}
