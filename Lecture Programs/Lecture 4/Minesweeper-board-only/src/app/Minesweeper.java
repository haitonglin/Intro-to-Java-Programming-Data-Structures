package app;

public class Minesweeper {
	public static void main(String[] args) {
		int size = 7;
		boolean[][] mines = new boolean[size][size]; //default value is false

		int numberOfMines = 5;
		for (int i = 0; i < numberOfMines; i++) {
			while (true) {   //imfinite loop
				int x = (int) Math.floor(Math.random() * size);
				int y = (int) Math.floor(Math.random() * size);

				if (!mines[x][y]) { //if there is no mines in this position, looking at random places
					mines[x][y] = true;
					break;  //break from the infinite loop (move the logic to the body)
				}
			}	
		}

		int[][] counts = new int[size][size]; //default value is 0
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				if (mines[x][y]) {
					for (int x1 = Math.max(0, x-1); x1 <= Math.min(size-1, x+1); x1++) { 
						//making sure you don't go too far
						for (int y1 = Math.max(0, y-1); y1 <= Math.min(size-1, y+1); y1++) {
							++counts[x1][y1];
						}
					}
				}
			}
		}

		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				System.out.print(" ");
				System.out.print(mines[x][y] ? "*" :  //?: fancy ways to write if/elif
					(counts[x][y] == 0 ? "_" : counts[x][y]));
			}
			System.out.println();
		}
	}
}