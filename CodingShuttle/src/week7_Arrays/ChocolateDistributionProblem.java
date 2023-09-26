package week7_Arrays;

import java.util.Arrays;

/*Problem Statement
Given an array A[ ] of positive integers of size n, where each value represents the number of chocolates in a packet. 
Each packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets among m students such that :
1. Each student gets exactly one packet.
2. The difference between the maximum number of chocolates given to a student and the minimum number of chocolates given to a student is minimum.

 

Example 1:
Input:
arr = [7, 3, 2, 4, 9, 12, 56]
m = 3

Output:
2 

Explanation:
The chocolate packets given are 3 , 2 , 4.Thus the difference is 2

Example 2:
Input:
N = 8, M = 5
A = {3, 4, 1, 9, 56, 7, 9, 12}

Output:
6

Explanation:
The minimum difference between maximum chocolates and minimum chocolates is 9 - 3 = 6 by choosing the following m packets: {3, 4, 9, 7, 9}.*/
public class ChocolateDistributionProblem {
	public static void main(String[] args) {
		int arr[] ={7,3,2,4,9,12,56};
		int m=3;
		System.out.println(findMinDiff(arr,m));
	}
	public static int findMinDiff(int[] arr, int m)
    {
        Arrays.sort(arr);
		
		int mindiff=Integer.MAX_VALUE;
		
		for(int i=0;i<arr.length-m+1;i++) {
			mindiff=Math.min(mindiff, arr[i+m-1] - arr[i]);
		}
		return mindiff;
    }
}
