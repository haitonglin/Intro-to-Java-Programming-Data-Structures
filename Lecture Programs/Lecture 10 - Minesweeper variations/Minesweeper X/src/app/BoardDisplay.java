package app;

public class BoardDisplay {
	private Board board;

	public BoardDisplay(Board board) {
		this.board = board;
	}

	public void showBoard(int xCursor, int yCursor, boolean[][] revealed, boolean showMines) {
		for (int y = 0; y < this.board.getHeight(); y++) {
			for (int x = 0; x < this.board.getWidth(); x++) {
				System.out.print(xCursor == x && yCursor == y ? ">" : " ");
				if (showMines && this.board.doesSquareHaveMine(x, y)) {
					System.out.print("*");	
				} else {
					int adjacentMineCount = this.board.getAdjencentMineCount(x, y);
					System.out.print(revealed[x][y] || showMines ? (adjacentMineCount == 0 ? "_" : adjacentMineCount) : "X");
				}
			}
			System.out.println();
		}
	}
}