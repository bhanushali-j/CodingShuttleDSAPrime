package week4_backtracking;

import java.util.ArrayList;

/*Problem Statement
In a square matrix of order N * N, imagine a rat placed at position (0, 0). The final location must be reached at (N - 1, N - 1). Find every route the rat might possibly take to go from point A to point B. The rat can move in the following directions: "U" (up), "D" (down), "L" (left), and "R" (right). Rats cannot move to a cell with a value of 0 in the matrix because it is blocked, while rats can pass through cells with a value of 1 in the matrix.
No cell can be visited more than once in a journey. The rat cannot go to any other cell if the originating cell is 0.

 

Complete the function findPath() which takes N and 2D array m[ ][ ] as input parameters and returns the list of paths in lexicographically increasing order. 

Example 1:
Input:
N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1}, 
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output:
DDRDRR DRDDRR
Explanation:
The rat can reach the destination at 
(3, 3) from (0, 0) by two paths - DRDDRR 
and DDRDRR, when printed in sorted order 
we get DDRDRR DRDDRR.
Example 2:
Input:
N = 2
m[][] = {{1, 1},
         {1, 1}}

Output:
DR RD
Constraints:
2 ≤ N ≤ 5
0 ≤ Mat[i][j] ≤ 1*/


public class RatInAMaze {
	
	public static void main(String[] args) {
		
		int[][] arr= {{1, 1},
		         	  {1, 1,}};
		         
		System.out.println(findPath(arr,2));
	}
	
	public static ArrayList < String > findPath(int[][] arr, int n) {

        boolean visited[][]=new boolean[n][n];
        ArrayList<String> pathList=new ArrayList<>();
        if(arr[0][0]==0) {
        	return pathList;
        }
        visited[0][0]=true;
        return ratInAMaze(arr,visited,0,0,"",n-1,pathList);
    
  }
	
	 public static boolean isValid(int i, int j, int length,boolean visited[][], int arr[][]){

	      if(i>=0 && i<=length && j>=0 && j<=length && arr[i][j]==1 && !visited[i][j] ){
	        return true;
	      }
	      return false;
	    }

	    public static ArrayList<String> ratInAMaze(int arr[][], boolean visited[][],int i,int j,String path, int length, ArrayList<String> pathList){
	      if(i==length && j==length){
	        pathList.add(path);
	        path="";
	        return pathList;
	      }

	      //check if we can go down
	      if(isValid(i+1,j,length,visited,arr)){
	        visited[i+1][j]=true;
	        ratInAMaze(arr,visited,i+1,j,path+"D",length,pathList);
	        visited[i+1][j]=false;
	      }

	       //check if we can go left
	      if(isValid(i,j-1,length,visited,arr)){
	        visited[i][j-1]=true;
	        ratInAMaze(arr,visited,i,j-1,path+"L",length,pathList);
	        visited[i][j-1]=false;
	      }

	      //check if we can go right
	      if(isValid(i,j+1,length,visited,arr)){
	        visited[i][j+1]=true;
	        ratInAMaze(arr,visited,i,j+1,path+"R",length,pathList);
	        visited[i][j+1]=false;
	      }

	       //check if we can go up
	      if(isValid(i-1,j,length,visited,arr)){
	        visited[i-1][j]=true;
	        ratInAMaze(arr,visited,i-1,j,path+"U",length,pathList);
	        visited[i-1][j]=false;
	      }
	      
	      return pathList;
	      
	    }
}
