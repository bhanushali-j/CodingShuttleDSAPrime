package week4_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*Problem Statement
Given an array arr[] having N positive integers, you have to generate all different subsequences of the array. 
Return the answer in a Lexographically sorted order.

Note: The array can contain duplicates.

Example 1:
Input: 

arr[] = [1, 2, 3]
Output: 

[[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
Explanation:
The total subsequences of the given array are [], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3] .

Example 2:
Input: 

arr[] = [1, 1, 1]
Output: 

[[], [1], [1, 1], [1, 1, 1]]

Constraints:
1 <= n <= 20
1 <= arr[i] <=10*/

public class SubsequenceOfArray {
	
	public static void main(String[] args) {
		List<List<Integer>> resultList=new ArrayList<>();
		
		List<Integer> a=Arrays.asList(1,3,2,1);
		List<Integer> result=new ArrayList<Integer>();
		subsequence(a,result,resultList,0);
		
		 //Using Comparator
        Collections.sort(resultList, (list1, list2) -> {
            for (int i = 0; i < Math.min(list1.size(),list2.size()); i++) {
            	
                int cmp = list1.get(i).compareTo(list2.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return Integer.compare(list1.size(), list2.size());
        });
        
		System.out.println(resultList);
	}

	private static void subsequence(List<Integer> a, List<Integer> result, List<List<Integer>> resultList, int index) {
			
			List<Integer> list=new ArrayList<>(result);
				resultList.add(list);
			
			for(int i=index;i<a.size();i++) {
				
				if(i>index && a.get(i)==a.get(i-1)) continue; //Avoid duplicates
					result.add(a.get(i));
					subsequence(a,result,resultList,i+1);
					result.remove(result.size()-1); //backtracking
			}		
	}
}
