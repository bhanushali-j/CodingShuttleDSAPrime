package ProblemOfTheDay;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*Problem Statement
Return the indices of the two numbers so that they add up to target given an array 
of integers nums and an integer target.
You can make an assumption that every input has exactly one solution, and you may
avoid using the same element more than once.

Note: Return the answer in sorted order.

Example 1:
Input: 
nums = [1,2,3,4,5]
target = 8
Output: 
[2,4]
Explanation: 
Because nums[2] + nums[4] == 8, we return [2, 4].
Example 2:
Input: 
nums = [1,2,3,4,5]
target = 3
Output:
[0,1]
*/
public class TwoSum {
	public static void main(String[] args) {
		int nums[]= {5,5};
		int target=10;
		int result[]=twoSum(nums,target);
		
		for(int ele: result) {
			System.out.print(ele+" ");
		}
	}
	
	public static int[] twoSum(int[] nums, int target) {
	      //You can code here
	      HashMap<Integer,Integer> hm=new LinkedHashMap<>();
	      
	      int result[]=new int[2];
	      
	      for(int i=0;i<nums.length;i++) {
	    	  int sub=target-nums[i];
	    	  if(hm.containsKey(sub)) {
	    		  result[0]=hm.get(sub);
	    		  result[1]=i;
	    	  }
	    	  else {
	    		  hm.put(nums[i],i);
	    	  }
	      }
	      return result;
	}
	
}
