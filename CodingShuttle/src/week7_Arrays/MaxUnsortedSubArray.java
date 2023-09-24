package week7_Arrays;

import java.util.ArrayList;
import java.util.List;

/*Problem Statement
Given an array A of non-negative integers of size N. Find the minimum subarray Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array, then the whole array should get sorted. If A is already sorted, output -1.

Example 1:
Input: 
A = [1, 3, 2, 4, 5]

Output:
[1, 2]

Explanation:

If we sort the array between the indices 1 to 2, the whole array will be sorted.

Example 2:
Input:
A = [1, 2, 3, 4, 5]

Output:
[-1]*/
public class MaxUnsortedSubArray {
	public static void main(String[] args) {
		int arr[] = { 229462, 879748, 524108, 109767, 416718, 58019, 469065, 89537, 651016, 913512, 398017, 57475,
				836393, 857686, 712427, 276823, 803826, 905589 };

		System.out.println(maxUnsortedSubArray(arr));

	}

	private static List<Integer> maxUnsortedSubArray(int[] arr) {
		ArrayList<Integer> result = new ArrayList<>();
		int max[] = new int[arr.length];
		int min[] = new int[arr.length];

		int maxSoFar = arr[0];
		for (int i = 0; i < arr.length; i++) {
			maxSoFar = Math.max(maxSoFar, arr[i]);
			max[i] = maxSoFar;
		}

		int minSoFarFromRight = arr[arr.length - 1];
		for (int i = arr.length - 1; i >= 0; i--) {
			minSoFarFromRight = Math.min(minSoFarFromRight, arr[i]);
			min[i] = minSoFarFromRight;
		}

		// check for leftmost index in unsorted position
		for (int i = 0; i < min.length - 1; i++) {
			if (min[i] == min[i + 1]) {
				result.add(i);
				break;
			}
		}
		
		// check for rightmost index to in unsorted position
		for (int i = max.length - 1; i > 0; i--) {
			if (max[i] == max[i - 1]) {
				result.add(i);
				break;
			}
		}

		
		if (result.size() == 0) {
			result.add(-1);
		}
		return result;
	}
}
