package week4_backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*Problem Statement
Given a collection of candidate numbers candidates and a target number target, 
find all unique combinations in candidates where the candidate numbers sum to the target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:
Sample Input:

Target = 12

Candidates = [8, 1, 3, 7, 2, 1, 5]

Sample Output:

[[1, 1, 2, 3, 5],
[1, 1, 2, 8],
[1, 1, 3, 7],
[1, 3, 8],
[2, 3, 7],
[5, 7]]
Example 2:
Sample Input:

Target = 14

Candidates = [3, 9, 8, 7, 5]

Sample Output 

[[5, 9]]

Constraints:
1 <= |Candidates| <= 18

1<= Candidates[i] <= 50

1<= Target <= 30
*/


public class CombinationSumProblem {
	public static void main(String[] args) {
		
		List<List<Integer>> resultList=new ArrayList<>();
		int target=12;
		int[] candidates= {8, 1, 3, 7, 2, 1, 5};
		List<Integer> result=new ArrayList<>();
		List<Integer> candidateList=new ArrayList<>();
		
		for(int i:candidates) {
			candidateList.add(i);
		}
		
		Collections.sort(candidateList);
		
		CombinationSum(resultList,candidateList,target,result,0,0);
		System.out.println(resultList);
		
	}

	private static void CombinationSum(List<List<Integer>> resultList, List<Integer> candidateList, int target,
			List<Integer> result, int sum,int index) {
		
		if(sum==target) {
			List<Integer> copyResult=new ArrayList<>(result);
			
				resultList.add(copyResult);
			
			sum=0;
			return;
		}
		
		for(int i=index;i<candidateList.size();i++) {
			
			if(i>index && candidateList.get(i)==candidateList.get(i-1)) continue;
			
			if(sum+candidateList.get(i) <= target) {
				sum+=candidateList.get(i);
				result.add(candidateList.get(i));
				CombinationSum(resultList, candidateList, target, result, sum,i+1);
				result.remove(result.size()-1);
				sum-=candidateList.get(i);
			}
		}
		
	}
}
