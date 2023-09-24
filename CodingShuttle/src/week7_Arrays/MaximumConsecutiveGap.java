package week7_Arrays;

import java.util.Arrays;
import java.util.Set;

/*Problem Statement
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.
You may assume that all the elements in the array are non-negative integers.
Note: You must write an algorithm that runs in linear time and uses linear extra space.

Example 1:
Input:
[4, 4, 2, 5, 2, 9, 10, 3, 6, 6] 

Output:
3

Example 2:
Input:
[2]

Output:
0*/
public class MaximumConsecutiveGap {
	public static void main(String[] args) {
		int arr[]= {10,1,9,2,7,3,9,2,5};
		System.out.println(maximumGapUsingBuckets(arr));
	}
	
	//Solution with TC=O(nlogn) 
	public static int  maximumGap(int[] arr) {
		
	    int max=Integer.MIN_VALUE;
		
	    Arrays.sort(arr);
	    for(int i=0;i<arr.length;i++) {
	    	if(i>0 && arr[i-1]<arr[i]) {
	    		max=Math.max(max, Math.abs(arr[i-1]-arr[i]));
	    	}
	    		
	    }
	    
	    return max;
	}
	
	//Solution with TC=O(n) (Using Pigeonhole Priciple And Bucketing)
	public static int  maximumGapUsingBuckets(int[] arr) {
		
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			max=Math.max(max, arr[i]);
			min=Math.min(min, arr[i]);
		}
		
		int Interval= (int)Math.ceil((double)(max-min)/(arr.length-1));
		
		int maxBucket[]=new int[arr.length-1];
		int minBucket[]=new int[arr.length-1];
		
		Arrays.fill(maxBucket, -1);
		Arrays.fill(minBucket,Integer.MAX_VALUE);
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==min || arr[i]==max) continue;
			int index= (arr[i] - min)/Interval;
			
			maxBucket[index]=Math.max(maxBucket[index], arr[i]);
			minBucket[index]=Math.min(minBucket[index], arr[i]);
		}
		
		int maxGap=Integer.MIN_VALUE;
		int prev=min;
		
		for(int i=0;i<maxBucket.length;i++) {
			if(minBucket[i]==Integer.MAX_VALUE) continue;
			maxGap=Math.max(maxGap,minBucket[i]-prev);
			prev=maxBucket[i];			
		}
		
		maxGap=Math.max(max-prev, maxGap);
		
		return maxGap;
				
	}
}
