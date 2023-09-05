package week4_backtracking;
/*You are given an NxM chessboard and the starting position (0, 0) of a knight. 
 * Your goal is to find a sequence of moves for the knight such that it visits every 
 * square on the chessboard exactly once, following the rules of knight movement.

The function should return a 2D array of integers representing the order in which the
knight visits each square. 

		 

Note:

There may be multiple possible orders in which the knight can visit the squares. 
Your function should return just one of these possible orders.
If it is not possible to complete the knight's tour, return an NxM matrix 
having all values equal to -1.

 

Example 1:
Input: 
n = 5, m = 5

Output: 
[[0, 5, 14, 9, 20], 
[13, 8, 19, 4, 15], 
[18, 1, 6, 21, 10], 
[7, 12, 23, 16, 3], 
[24, 17, 2, 11, 22]]

Explanation: 
This is one of the order of each cell in which they are visited by knight.
Example 2:
Input: 
n = 2, m = 3

Output: 
[[-1, -1, -1], 
[-1, -1, -1]]
Constraints:
1 <= N, M <= 7*/


public class TheKnightsTour {
	public static void main(String[] args) {
		
		int n=4;int m=5;
		int resultArray[][]=knightTour(n,m);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(resultArray[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	private static int[][] knightTour(int n,int m) {
		int arr[][]=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j]=-1;
			}
		}
		arr[0][0]=0;
		
		int movesX[]= {2, 1, -1, -2, -2, 1, -1, 2};
		int movesY[]= {1, 2, 2, 1, -1, -2, -2, -1};
		
		if(knightTourHelper(arr,n,m,movesX,movesY,0,0,1)) {
			
			return arr;
		}
		arr[0][0]=-1;	
		return arr;
	}

	private static boolean knightTourHelper(int[][] resultArray, int n, int m,
			int movesX[],int movesY[], int currX, int currY, int step) {
		
		if(step==(n*m)) {
			return true;
		}
		
		for(int i=0;i<8;i++) {
			int nextX=currX+movesX[i];
			int nextY=currY+movesY[i];
			if(isValid(resultArray,n,m,nextX,nextY)) {
				resultArray[nextX][nextY]=step;
				boolean KnightOnCorrectPath=knightTourHelper(resultArray,n,m,movesX,movesY,nextX,nextY,step+1);
				if(KnightOnCorrectPath) {
					return true;
				}else {
					resultArray[nextX][nextY]=-1;//BackTracking step
				}
			}
		}
		
		
		return false;
	}

	private static boolean isValid(int[][] resultArray, int n, int m,int currX, int currY) {
		if(currX>=0 && currY>=0 && currX<n && currY<m && resultArray[currX][currY]==-1) {
			return true;
		}
		return false;
	}
}

















