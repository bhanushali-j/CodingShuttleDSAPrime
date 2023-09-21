package week7_Arrays;

import java.util.HashSet;
import java.util.Set;

/*Problem Statement
Determine if there are any two distinct indices i and j in the sorted array arr such that arr[i] - arr[j] equals 
a non-negative integer k. Return true if possible else false.

Example 1:
Input:

arr[] = [1, 1, 1, 2, 2, 6, 8, 8, 8]
k = 2

Output:
true

Explanation:
There exists two numbers 6 and 8 whose difference is equal to 2.

Example 2:
Input:
arr[] = [1, 4, 5, 8, 10, 14, 18]
k = 5

Output:
true*/
public class DifferencePossible {
	public static void main(String[] args) {
		int arr[]= {1,1,1,2,2,6,8,8,8};
		int k=2;
		
		Set<Integer> set=new HashSet<>();
	
		for(int ele:arr) {
			set.add(ele);
		}
		
		for(Integer ele:set) {
			int sum=ele+k;
			if(set.contains(sum)) {
				System.out.println(true);
			}
		}
		System.out.println(false);
	}
}
