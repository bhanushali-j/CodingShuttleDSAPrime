package week7_Arrays;
/*Problem Statement
Given an integer K and a matrix of N rows and M columns, the task is to find the minimum number 
of operations required to make all the elements of the matrix equal. In a single operation, 
K can be added to or subtracted from any element of the matrix.

Example 1:
Input:
A = [[0, 2, 8],
     [8, 2, 0],
     [0, 2, 8]]
K = 2

Output:
12*/

import java.util.Arrays;

public class MinimumOperationsToMakeArrayEqual {
	public static void main(String[] args) {
		int A[][] = { { 3, 3, 2 }, { 0, 2, 8 }, { 0, 2, 8 } };
		int K = 2;

		int arr[] = new int[A.length * A[0].length];

		int temp = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				arr[temp] = A[i][j];
				temp++;
			}
		}

		Arrays.sort(arr);

		int median = arr[arr.length / 2];

		System.out.println(MinOperationsToMakeArrayEqual(arr, median, K));
	}

	private static int MinOperationsToMakeArrayEqual(int[] arr, int median, int k) {

		int count = 0;
		for (int ele : arr) {
			if (ele % median != 0) { // To check if the element in the number is even divisible by median value into
										// which we want to convert it
				count = -1;
				break;
			}
			count += Math.abs(ele - k) / median;
		}
		return count;
	}
}
