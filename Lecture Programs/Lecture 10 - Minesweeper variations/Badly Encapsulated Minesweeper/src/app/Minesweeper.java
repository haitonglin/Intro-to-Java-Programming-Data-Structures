package app;

import edu.princeton.cs.introcs.*;

public class Minesweeper {
	public static void main(String[] args) {
		// Basic parameters
		int size = 9;
		int numberOfMines = 10;

		// Set up initial board
		Board board = new Board(size, numberOfMines);

		// User cursor tracking
		int xCursor = 0;
		int yCursor = 0;
		boolean[][] revealed = new boolean[size][size];
		BoardDisplay display = new BoardDisplay(board);

		// Main game loop
		while (true) {
			// Show the current board state
			display.showBoard(xCursor, yCursor, revealed, false);

			// Prompt user to make move
			System.out.print("(u)p, (d)own, (l)eft, (r)ight, (s)tep? ");
			char ch = StdIn.readLine().charAt(0);
			System.out.println();
			if (ch == 'u') {
				--yCursor;
			} else if (ch == 'd') {
				++yCursor;
			} else if (ch == 'l') {
				--xCursor;
			} else if (ch == 'r') {
				++xCursor;
			} else if (ch == 's') {
				if (board.getMines()[xCursor][yCursor]) {
					System.out.println("Sorry.. you stepped on a mine");
					display.showBoard(xCursor, yCursor, revealed, true);
					return;
				}
				revealed[xCursor][yCursor] = true;
			}			
		}
	}
}