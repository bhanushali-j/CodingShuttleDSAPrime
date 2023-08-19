package week3_Recursion;

/*Problem Statement
Count every path that can lead from the top left to the bottom right of a M X N matrix, with the restriction that you can only move right or down from each cell

Example 1:
Input:  

M = 2, N = 2

Output: 

2

Explanation:

There are only two paths
(0, 0) -> (0, 1) -> (1, 1)
(0, 0) -> (1, 0) -> (1, 1)
*/
public class MatrixPath {
	
	public static int numberOfPaths(int m, int n) {
	      if(m==1 || n==1){
	        return 1;
	      }
	      return numberOfPaths(m-1,n) + numberOfPaths(m,n-1) ;
	    }
}
