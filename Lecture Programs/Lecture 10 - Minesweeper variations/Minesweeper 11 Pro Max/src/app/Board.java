package app;

public class Board {
	private int size;
	private int[][] mines;
	private int[][] counts;

	public Board(int size, int numberOfMines) {
		this.size = size;
		this.mines = new int[size][size];

		for (int i = 0; i < numberOfMines; i++) {
			while (true) {
				int x = (int) Math.floor(Math.random() * size);
				int y = (int) Math.floor(Math.random() * size);

				if (this.mines[x][y] == 0) {
					this.mines[x][y] = 3 + (int) Math.floor(Math.random() * 10);
					break;
				}
			}
		}

		this.counts = new int[size][size];
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				if (this.doesSquareHaveMine(x, y)) {
					for (int x1 = Math.max(0, x - 1); x1 <= Math.min(size - 1, x + 1); x1++) {
						for (int y1 = Math.max(0, y - 1); y1 <= Math.min(size - 1, y + 1); y1++) {
							this.counts[x1][y1] += this.getMineCount(x, y);
						}
					}
				}
			}
		}
	}

	public int getWidth() {
		return this.size;
	}

	public int getHeight() {
		return this.size;
	}

	public boolean doesSquareHaveMine(int x, int y) {
		return this.mines[x][y] > 0;
	}

	public int getMineCount(int x, int y) {
		return this.mines[x][y];
	}

	public int getAdjencentMineCount(int x, int y) {
		return this.counts[x][y];
	}
}