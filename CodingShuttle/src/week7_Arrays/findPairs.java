package week7_Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*Problem Statement
Given an array arr of n positive elements. Return the pairs in sorted order 
(in case of the same first element sort on the basis of the second element) whose sum already exists in the given array.

Example 1:
Input:
arr = [10, 4, 8, 13, 5]

Output:
[[5, 8]]

Explanation:
5+8 = 13 is present in the array

Example 2:

Input:
arr[] = {2, 8, 7, 1, 5}

Output:
[[2, 5], [1, 7]]*/
public class findPairs {
	public static void main(String[] args) {
		int arr[]= {1,9,10,8,2,2,10,7,9,1};
		System.out.println(findPair(arr));
	}

	private static List<List<Integer>> findPair(int[] arr) {
		List<List<Integer>> result=new ArrayList<>();
//		Arrays.sort(arr);
		
		Set<Integer> set=new HashSet<>();
		
		for(int a:arr) {
			set.add(a);
		}
		
		for (int i = 0; i<arr.length ; i++) {
			for(int j=i+1;j<arr.length;j++) {
				int sum=arr[i]+arr[j];
				if(set.contains(sum)) {
					List<Integer> temp=new ArrayList<>();
					temp.add(arr[i]);
					temp.add(arr[j]);
					result.add(temp);
				}
			}
		}
		Collections.sort(result,(x,y) -> {
	          for(int i=0;i<x.size();i++){
	            if(x.get(i).compareTo(y.get(i))!=0){
	              return x.get(i) - (y.get(i));
	            }
	          }
	          return 0;
	        });
		return result;
	}
}
