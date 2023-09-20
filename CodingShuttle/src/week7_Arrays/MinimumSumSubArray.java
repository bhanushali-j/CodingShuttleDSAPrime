package week7_Arrays;
/*Problem Statement
Given an array of positive integers A and a positive integer K, return the minimal length of a Subarray whose sum is greater than or equal to the target. If there is no such subarray, return 0 instead.

Example 1:
Input: 
target = 7
nums = [2,3,1,2,4,3]

Output: 
2

Explanation: 
The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: 
target = 4
nums = [1,4,4]

Output: 
1*/
public class MinimumSumSubArray {
	public static void main(String[] args) {
		int nums[]= {2,3,1,7,4,3};
		int target=7;
		
		int l=0;
		int r=0;
		
		int Sum=0;
		int minLen=Integer.MAX_VALUE;
		
		while(r<nums.length) {
			Sum+=nums[r];
			while(Sum>=target) {
				minLen=Math.min(minLen, r-l+1);
				Sum-=nums[l];
				l++;
			}
			r++;
		}
		if(minLen==Integer.MAX_VALUE) {
			minLen=0;
		}
		System.out.println(minLen);
	}
}
