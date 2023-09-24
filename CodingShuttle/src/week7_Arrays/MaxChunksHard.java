package week7_Arrays;

/*Problem Statement
You are given an integer array arr. We split arr into some number of chunks (i.e., partitions), 
and individually sort each chunk. After concatenating them, the result should equal the sorted array.
Return the largest number of chunks we can make to sort the array.

Example 1:
Input:
arr = [5,4,3,2,1]

Output:
1

Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted.

Example 2:
Input:
arr = [8, 2, 5, 2]

Output:
1*/
public class MaxChunksHard {
	public static void main(String[] args) {
		int[] arr= {49,94,49,13,45,27,46,58};
		System.out.println(maxChunks(arr));
	}

	private static int maxChunks(int[] arr) {
		int chunks=0;
		
		int[] left=new int[arr.length];
		int[] right=new int[arr.length];
		
		int max=arr[0];
		int min=arr[arr.length-1];
		
		for(int i=0;i<arr.length;i++) {
			max=Math.max(max,arr[i]);
			left[i]=max;
		}
		for(int i=arr.length-1;i>=0;i--) {
			min=Math.min(min,arr[i]);
			right[i]=min;
		}
		
		for(int i=0;i<arr.length;i++) {
			if(i!=arr.length-1 && left[i]<=right[i+1]) {
				chunks++;
			}
		}
		return chunks+1;
	}
}
