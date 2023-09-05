package week4_backtracking;

/*Problem Statement
Write a program that fills in the empty cells in a given Sudoku puzzle.

The empty cells are indicated by the '.' character.

 

The following guidelines must all be followed:

- The numbers 1-9 must appear exactly once in each row.
- The numbers 1-9 must appear exactly once in each column.
- In each of the grid's nine 3x3 sub-boxes, the numbers 1-9 must appear exactly once.


Example 1:
Input: 
board = [["5","3",".",".","7",".",".",".","."],
         ["6",".",".","1","9","5",".",".","."],
         [".","9","8",".",".",".",".","6","."],
         ["8",".",".",".","6",".",".",".","3"],
         ["4",".",".","8",".","3",".",".","1"],
         ["7",".",".",".","2",".",".",".","6"],
         [".","6",".",".",".",".","2","8","."],
         [".",".",".","4","1","9",".",".","5"],
         [".",".",".",".","8",".",".","7","9"]]

Output: 
[["5","3","4","6","7","8","9","1","2"],
 ["6","7","2","1","9","5","3","4","8"],
 ["1","9","8","3","4","2","5","6","7"],
 ["8","5","9","7","6","1","4","2","3"],
 ["4","2","6","8","5","3","7","9","1"],
 ["7","1","3","9","2","4","8","5","6"],
 ["9","6","1","5","3","7","2","8","4"],
 ["2","8","7","4","1","9","6","3","5"],
 ["3","4","5","2","8","6","1","7","9"]]
Constraints:
board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution.*/

public class SudokuSolver {
	public static void main(String[] args) {
		char[][] board= {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};
		
		
//		char[][] resultboard=board;
		boolean isSudokuSolved=SudokuSolverHelper(board,0,0);
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	private static boolean SudokuSolverHelper(char[][] board, int row, int col) {
		if(row==9) {
			return true;
		}
		if(col==9) {
			return SudokuSolverHelper(board,row+1,0);
		}
		if(board[row][col]!='.') {
			return SudokuSolverHelper(board,row,col+1);
		}
		
		for(int i=1;i<10;i++) {
			if(isValid(i,board,row,col)) {
				board[row][col]=(char) (i+'0');
				if(SudokuSolverHelper(board,row,col+1)) {
					return true;
				}else{
					board[row][col]='.';
				};
				
			}
		}
		return false;
	}

	private static boolean isValid(int value, char[][] board, int row, int col) {
		
		//check for value already present in same row
		for(int i=0;i<9;i++) {
			if(board[row][i]==(char) (value+'0')) {
				return false;
			}
		}
		
		//check for value already present in same column
		for(int i=0;i<9;i++) {
			if(board[i][col]==(char) (value+'0')) {
				return false;
			}
		}
		
		int startRow=row-row%3;
		int startCol=col-col%3;
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(board[i+startRow][j+startCol]==(char) (value+'0')) {
					return false;
				}
			}
		}	
		return true;
	}
}
