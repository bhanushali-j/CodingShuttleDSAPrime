package week4_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Problem Statement
Given an integer n, return all distinct solutions to the n-queens puzzle. 
You may return the answer in any order. The n-queens puzzle is the problem of 
placing n queens on an n x n chessboard such that no two queens attack each other.
Each solution contains a distinct board configuration of the n-queens' placement, 
where 'Q' and '.' both indicate a Queen and an empty space, respectively.

Example 1:

Sample Input:
4
Sample Output:
[[".Q..","...Q","Q...","..Q."],

["..Q.","Q...","...Q",".Q.."]]

 

Explanation:

Example 2:
Sample Input:
1
Sample Output:
[“Q”]

Constraints:
1 <= n <= 9*/

public class NQueens {
	
	public static void main(String[] args) {
		List<List<String>> allBoards=new ArrayList<List<String>>(4);
//		System.out.println(queenList);
		
//		int[][] queenArr = new int[4][4];
//		 
		char[][] board=new char[4][4];
		nQueens(4,board,allBoards,0);
		
//		for(int[] row: allBoards) {
//			for(int col:row) {
//				System.out.print(col);
//			}
//			System.out.println();
//		}
		
		System.out.println(allBoards);
		
		
	}
	
	public static boolean isValid(int row,int col,char[][] board, int n) {
		
		//horizontal
		for(int i=0;i<n;i++) {
			if(board[row][i]=='Q') {
				return false;
			}
		}
		
		//vertical
		for(int i=0;i<n;i++) {
			if(board[i][col]=='Q') {
				return false;
			}
		}
		
		//upper left
		for(int i=row, j=col;i>=0 && j>=0;i--,j--) {
			if(board[i][j]=='Q') {
				return false;
			}
		}
		
		//upper right
		for(int i=row, j=col;i>=0 && j<n;i--,j++) {
			if(board[i][j]=='Q') {
				return false;
			}
		}
		
		//lower left
		for(int i=row, j=col;i<n && j>=0;i++,j--) {
			if(board[i][j]=='Q') {
				return false;
			}
		}
		
		//lower right
		for(int i=row, j=col;i<n && j<n;i++,j++) {
			if(board[i][j]=='Q') {
				return false;
			}
		}
		
		return true;
	}
	
	
	public static void nQueens(int n,char[][] board,List<List<String>> allBoards,int row){
		if(row==n) {
			save(board,allBoards);
			return;	
		}
		
		for(int col=0;col<n;col++) {
			if(isValid(row,col,board,n)) {
				board[row][col]='Q';
				nQueens(n,board,allBoards,row+1);
				board[row][col]='.';
			}
			
			
		}
	}

	private static void save(char[][] board,List<List<String>> allBoards) {
		
		String row="";
		List<String> newBoard=new ArrayList<>();
		for(int i=0;i<board.length;i++) {
			row="";
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j]=='Q') {
					row+='Q';
				}else {
					row+='.';
				}
			
			}
			newBoard.add(row);
		}
		allBoards.add(newBoard);
	}
	

}
   


































