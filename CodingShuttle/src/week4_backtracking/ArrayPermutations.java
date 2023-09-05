package week4_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*Problem Statement
Given an array nums[] of distinct integers, return all the possible permutations.

Return the answer in sorted order. See the examples for more clarification.

Example 1:
Input: 
nums = [1,2,3]
Output: 
[[1,2,3],[1,3,2],[2,1,3],
 [2,3,1],[3,1,2],[3,2,1]]


Example 2:
Input: 
nums = [1,2,3,4]
Output: 
[[1,2,3,4],[1,2,4,3],[1,3,2,4],[1,3,4,2],[1,4,2,3],[1,4,3,2],
 [2,1,3,4],[2,1,4,3],[2,3,1,4],[2,3,4,1],[2,4,1,3],[2,4,3,1],
 [3,1,2,4],[3,1,4,2],[3,2,1,4],[3,2,4,1],[3,4,1,2],[3,4,2,1],
 [4,1,2,3],[4,1,3,2],[4,2,1,3],[4,2,3,1],[4,3,1,2],[4,3,2,1]]
Constraints:
1 <= nums.length <= 6
-10 <= nums[i] <= 10*/


public class ArrayPermutations {
	public static void main(String[] args) {
		List<List<Integer>> permutedArrayList=new ArrayList<List<Integer>>();
		int arr[]= {1,2,3};
		permute(arr,0,arr.length,permutedArrayList);
		
		
		//Using Comparator to compare/sort list objects in list<list<Integer>>;
		Collections.sort(permutedArrayList, (list1, list2) -> {
            for (int i = 0; i < list1.size(); i++) {
                int cmp = list1.get(i).compareTo(list2.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return Integer.compare(list1.size(), list2.size());
        });
		
		System.out.println(permutedArrayList);
		
	}

	private static void permute(int arr[], int l, int r, List<List<Integer>> permutedArrayList) {
		// TODO Auto-generated method stub
 		if(l==r-1) {
 			List<Integer> innerList=new ArrayList<>();
 			for(int ele:arr) {
 				innerList.add(ele);
 			}
 			permutedArrayList.add(innerList);
		}
		
		for(int current=l;current<r;current++) {
			swap(arr,l,current);
			permute(arr,l+1,r,permutedArrayList);
			swap(arr,l,current);
		}
		
	}

//	private static void printArray(int arr[]) {
//		for(int ele:arr) {
//			System.out.print(ele+", ");
//		}
//		System.out.println();
//	}

	private static void swap(int[] arr, int l, int current) {
		int temp=arr[l];
		arr[l]=arr[current];
		arr[current]=temp;
	}

	
	
}
