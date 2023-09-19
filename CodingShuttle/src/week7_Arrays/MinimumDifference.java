package week7_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Problem Statement
Given an array of distinct integers, find all pairs of elements where 
the difference between the two elements is the smallest among all pairs in the array. Return these pairs in ascending order, where each pair is represented by [a, b], such that a, b are elements from the array and a < b. The difference between a and b should be the smallest possible.

Example 1:
Input:
arr = [12, 9, 8, 2, 11]

Output:
[[8, 9], [11, 12]]

Example 2:
Input:
arr = [22, 7, 1, 3, 11, 20, 19]

Output:
[[19, 20]]*/
public class MinimumDifference {
	public static void main(String[] args) {
		int arr[]= {12,9,8,2,11};
		Arrays.sort(arr);
		
		List<List<Integer>> result=new ArrayList<>();
		
		int min=Integer.MAX_VALUE;
		for(int i=1;i<arr.length;i++) {
			min=Math.min(min, arr[i]-arr[i-1]);
		}
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i]-arr[i-1]==min) {
				List<Integer> temp=new ArrayList<>();
				temp.add(arr[i-1]);
				temp.add(arr[i]);
				result.add(temp);
			}
		}
		
		System.out.println(result);
	}
}
