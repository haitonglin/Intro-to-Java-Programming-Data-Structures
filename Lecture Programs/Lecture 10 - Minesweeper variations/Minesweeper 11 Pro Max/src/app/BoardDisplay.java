package app;

import edu.princeton.cs.introcs.*;

public class BoardDisplay {
	private Board board;

	public BoardDisplay(Board board) {
		this.board = board;
	}

	public void showBoard(int xCursor, int yCursor, boolean[][] revealed, boolean showMines) {
		int squareSize = 40;
		StdDraw.setCanvasSize(this.board.getWidth() * squareSize, this.board.getHeight() * squareSize);
		StdDraw.setXscale(0, this.board.getWidth() * squareSize);
		StdDraw.setYscale(-this.board.getHeight() * squareSize, 0);
		StdDraw.clear();
		for (int x = 0; x < this.board.getWidth(); x++) {
			for (int y = 0; y < this.board.getHeight(); y++) {
				if (showMines && this.board.doesSquareHaveMine(x, y)) {
					StdDraw.filledEllipse(x * squareSize + squareSize / 2, -y * squareSize - squareSize / 2, squareSize / 2, squareSize / 2);
				} else {
					int adjacentMineCount = this.board.getAdjencentMineCount(x, y);
					if (revealed[x][y]) {
						if (adjacentMineCount > 0) {
							StdDraw.text(x * squareSize + squareSize / 2, -y * squareSize - squareSize / 2, "" + adjacentMineCount);
						}
					} else if (!showMines) {
						StdDraw.text(x * squareSize + squareSize / 2, -y * squareSize - squareSize / 2, "X");
					}
				}
			}
		}

		StdDraw.rectangle(xCursor * squareSize + squareSize / 2, -yCursor * squareSize - squareSize / 2, squareSize / 2, squareSize / 2);

		// for (int y = 0; y < this.board.getHeight(); y++) {
		// 	for (int x = 0; x < this.board.getWidth(); x++) {
		// 		System.out.print(xCursor == x && yCursor == y ? ">" : " ");
		// 		if (showMines && this.board.doesSquareHaveMine(x, y)) {
		// 			System.out.print("*");	
		// 		} else {
		// 			int adjacentMineCount = this.board.getAdjencentMineCount(x, y);
		// 			System.out.print(revealed[x][y] || showMines ? (adjacentMineCount == 0 ? "_" : adjacentMineCount) : "X");
		// 		}
		// 	}
		// 	System.out.println();
		// }
	}
}