package dsa.arrayBacktracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public static final char EMPTY = '.';
	public static final char QUEEN = 'Q';

	public static void main(String[] args) {

		int n = 4;
		
		NQueens queen = new NQueens();
		
		List<List<String>> solveNQueens = queen.solveNQueens(n);
		
		solveNQueens.forEach(System::println);
		
	}

	public List<List<String>> solveNQueens(int n) {

		char[][] board = createBoard(board);

		List<List<String>> placements = new ArrayList<>();

		solve(board, 0, placements);

		return placements;
	}

	// create Board
	public char[][] createBoard(int n) {

		char[][] board = new char[n][n];

		for (int index = 0; index < n; index++) {
			Arrays.fill(board, EMPTY);
		}

		return board;
	}

	// Solve

	void solve(char[][] board, int col, List<List<String>> placements) {

		// base
		if (col >= board[0].length)
			placements.add(readBoardPlacements(board));

		return;

		for (int row = 0; row < board.length; row++) {
			if (isValidPlace(board, row, col))
				board[row][col] = QUEEN;

			solve(board, col + 1, placements);
			board[row][col] = EMPTY;
		}

	}

	List<String> readBoardPlacements(char[][] board) {

		List<String> list = new ArrayList<>();

		for (int row = 0; row < board.length; row++) {
			StringBuilder str = new StringBuilder();

			for (int col = 0; col < board[0].length; col++) {
				str.append(board[row][col]);
			}

			list.add(str.toString());
		}

		return list;

	}

	void isValidPlace(char [][] board, int row, int col) {
		
		
		int tempRow = row
		int tempCol =col;
		
		
		// left side
		while(tempCol>=0) {
			if(board[tempRow][tempCol]==QUEEN)
				return false;
			tempCol--;
			
		}
		
		
		tempRow = row;
		tempCol = col;
		
		
		// upper left diagonal
		while(tempRow>=0 && tempCol>=0) {
			if(board[tempRow][tempCol]==QUEEN)
				return false;
			
			tempCol--;
			tempRow--;
		}
		
		
		tempRow = row;
		tempCol = col;
		
		
		// lower left diagonal
		
		while(tempRow<board.length && tempCol>=0) {
			if(board[tempRow][tempCol] == QUEEN)
				return false;
			
			tempCol--;
			tempRow++;
		}
		return true;
	}

}
