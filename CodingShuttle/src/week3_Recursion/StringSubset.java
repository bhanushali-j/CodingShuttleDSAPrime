package week3_Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Problem Statement
Given a string, write a program to output every non-empty substring of the given string in a 
Lexographically sorted order.
 

Note: Here we will not consider an empty string as the subset of a String

Example 1:
Input: s = abc
Output: [a, ab, abc, ac, b, bc, c] 
Example 2:
Input: s = ab
Output: [a, ab, b] 
Constraints:
1 <= s.length <= 10
A <= s[i] <= Z
All the characters of the given String are unique.*/
public class StringSubset {
	public static void main(String[] args) {
		List<String> subsets=new ArrayList<>();
		System.out.println(subsetHelper("abc",0,"",subsets));
	
	}
	public static List<String> subsetHelper(String s, int i, String curr,List<String> subsets){
	      if(i==s.length()){
	    	  if(curr.length()>0) {  // To remove the empty string
	    		  subsets.add(curr);
	    		  Collections.sort(subsets); 
		          return subsets;
	    	  }   
	          return subsets;
	      }
	      subsetHelper(s,i+1,curr+s.charAt(i),subsets);
	      subsetHelper(s,i+1,curr,subsets);
	      return subsets;
	 }
}
