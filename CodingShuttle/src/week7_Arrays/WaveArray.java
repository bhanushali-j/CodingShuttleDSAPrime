package week7_Arrays;

import java.util.Arrays;

/*Problem Statement
Given an array of integers A, sort the array into a wave-like array and return it. Arrange the elements into a 
sequence such that -

a1 >= a2 <= a3 >= a4 <= a5.....

NOTE: If multiple answers are possible, return the lexicographically smallest one.

Example 1:
Input:
A = [1, 2, 3, 4]

Output:
[2, 1, 4, 3]

Example 2:
Input:
 
A[] = [2, 4, 7, 8, 9, 10]
Output: 
[4, 2, 8, 7, 10, 9]*/
public class WaveArray {
	public static void main(String[] args) {
		
		int arr[]= {2,4,7,8,9,10};
		
		//sort the array
		Arrays.sort(arr);
		
		//check for every odd position and if larger then previous position then swap them
		for(int i=1;i<arr.length;i+=2) {
			if(arr[i]>arr[i-1]) {
				swap(arr,i);
			}
		}
		
		for(int ele:arr) {
			System.out.print(ele+" ");
		}
	}

	private static void swap(int[] arr, int i) {
		int temp=arr[i-1];
		arr[i-1]=arr[i];
		arr[i]=temp;
	}
}


	
	
	
	
	

