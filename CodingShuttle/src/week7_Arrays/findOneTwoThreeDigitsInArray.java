package week7_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Problem Statement
You’re given an array of ‘N’ integers. Your task is to find all those array elements which contain 1, 2, and 3
in their digits and then print them in ascending order. If no element has 1,2 and 3 in its digits, then print ‘-1’.

Example 1:
Input:

arr = [321, 123, 89, 32, 11]

Output:

[123, 321]

Example 2:
Input:

arr = [8, 9, 132]

Output:

[132]*/
public class findOneTwoThreeDigitsInArray {
	public static void main(String[] args) {
		int arr[] = { 321, 123, 89, 32, 11 };
		
		List<Integer> result=new ArrayList<>();

		Arrays.sort(arr);
		for (int ele : arr) {
			boolean found123Digits = find123Digits(ele);
			if(found123Digits) result.add(ele);
		}
		
		System.out.println(result.size()>0?result:-1);
	}

	private static boolean find123Digits(int ele) {
		
		boolean isOne=false;
		boolean isTwo=false;
		boolean isThree=false;
		
		while(ele>0) {
			int digit=ele%10;
			if(digit==1) isOne=true;
			if(digit==2) isTwo=true;
			if(digit==3) isThree=true;
			
			ele=ele/10;
		}
		
		if(isOne && isTwo && isThree) {
			 return true;
		}
		
		return false;
	}
}
