package week7_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Problem Statement
Return all triplets [nums[i], nums[j], nums[k]] where i!= j, i!= k, j!= k, and nums[i] + nums[j] + nums[k] == 0 for an integer array nums.
Keep in mind that there cannot be any duplicate triplets in the solution set.

Note: The order of the output and the order of the triplets does not matter.

Example 1:
Input: 
nums = [-2, 0, 1, 2, 1]
Output: 
[[-2, 1, 1],[-2,0,2]]
Explanation: 
nums[0] + nums[2] + nums[4] = (-2) + 1 + 1 = 0.
nums[0] + nums[1] + nums[3] = (-2) + 0 + 2 = 0.
The distinct triplets are [-2, 1, 1] and [-2,0,2].
Example 2:
Input: nums = [0,1,1]
Output: []*/
public class ThreeSumProblem {
	
	public static void main(String[] args) {
		int nums[] = {-2, 0, 1, 2, 1};
		Arrays.sort(nums);
		List<List<Integer>> result=new ArrayList<>();
		
		for(int i=0;i<nums.length-2;i++) {
			if(i>0 && nums[i]==nums[i-1]) {
				continue;
			}
			List<List<Integer>> twoSumResult=twoSum(nums,i+1,-nums[i]);
				for(List<Integer> list:twoSumResult) {
					list.add(0,nums[i]);
					result.add(list);
			}
		}
		System.out.println(result);
	}
	
	public static List<List<Integer>> twoSum(int nums[],int start,int target){
		Map<Integer,Integer> hm=new HashMap<>();
		List<List<Integer>> twoSumresult=new ArrayList<>();
		for(int i=start;i<nums.length;i++) {
			int sub=target-nums[i];
			if(hm.containsKey(sub)) {
				List<Integer> temp=new ArrayList<>();
				temp.add(sub);
				temp.add(nums[i]);
				twoSumresult.add(temp);
			}else {
				hm.put(nums[i], i);
			}
		}
		
		return twoSumresult;
	}

}
