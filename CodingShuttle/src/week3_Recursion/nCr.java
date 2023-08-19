package week3_Recursion;
/*Problem Statement
Given two integers n and r, find nCr (Combination)

Example 1:
Input: n = 3, r = 2
Output: 3
Explaination: 3C2 = 3. 
Example 2:
Input: n = 4, r = 4
Output: 1
Constraints:
1 ≤ n, r ≤ 20*/

public class nCr {
	public static int nCr(int n, int r) {
	    
	    if (r>n) {
	      return 0;
	    }
	    if(n==r || r==0){
	          return 1;
	    }
	    return nCr(n-1,r-1) + nCr(n-1,r);
	    }
}
