package week4_backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Problem Statement
Given a string s, write a program that prints all unique permutations of the string in lexicographically sorted order.

Example 1:
Input: 

s = “ABC”

Output: 

“ABC”, “ACB”, “BAC”, “BCA”, “CAB”, “CBA”

Example 2:
Input:

s = “AB”

Output: 

“AB”, “BA”

Constraints:
1 <= s.length <= 6
A <= s[i] <= Z
It can contain duplicates.*/
public class StringPermuations {
	
	public static void main(String[] args) {
		
		String str="CAB";
		List<String> permuteList=new ArrayList<>();
		System.out.println(permute(str,0,str.length(),permuteList));
		
	}
	
	
	
//	** Instead you can also use this condition with the base condition of permute function
//	(l==r-1 && !permuteList.contains(str)) then there is no need of canSwap()
//	
	// Returns true if str[l] does not matches with any of the
	// characters after str[i]
	
	
	public static boolean canSwap(String str,int i,int l) {
		for (int j = i; j < l; j++) {
            if (str.charAt(j) == str.charAt(l)) {
                return false;
            }
        }
        return true;
	}

	
	public static List<String> permute(String str, int l, int r,List<String> permuteList){
		if(l==r-1 && !permuteList.contains(str)) {
			permuteList.add(str);
			Collections.sort(permuteList);
			return permuteList;
		}
		
		for(int i=l;i<r;i++) {
//			if(canSwap(str,l,i)) { // Edge case to check duplicate values
				str=swap(str,l,i);
				permute(str,l+1,r,permuteList);
				swap(str,l,i); ///Backtracking step to swap the string back to what it was.
//			}
		}
		
		return permuteList;
	}
	
	public static String swap(String str,int i,int l) {
		
		char strArr[]=str.toCharArray();
		char temp=strArr[i];
		strArr[i]=strArr[l];
		strArr[l]=temp;
		return String.valueOf(strArr);
		
	}

}
