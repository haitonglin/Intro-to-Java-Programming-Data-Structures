package app;

import edu.princeton.cs.introcs.*;
//this prints the graphical result but it's not interactive
public class Minesweeper {
	public static void main(String[] args) {
		int size = 11;
		boolean[][] mines = new boolean[size][size];

		int numberOfMines = 7;
		for (int i = 0; i < numberOfMines; i++) {
			while (true) {
				int x = (int) Math.floor(Math.random() * size);
				int y = (int) Math.floor(Math.random() * size);

				if (!mines[x][y]) {
					mines[x][y] = true;
					break;
				}
			}	
		}

		int[][] counts = new int[size][size];
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				if (mines[x][y]) {
					for (int x1 = Math.max(0, x-1); x1 <= Math.min(size-1, x+1); x1++) {
						for (int y1 = Math.max(0, y-1); y1 <= Math.min(size-1, y+1); y1++) {
							++counts[x1][y1];
						}
					}
				}
			}
		}
		//This is the part that prints it to the screen
		// for (int y = 0; y < size; y++) {
		// 	for (int x = 0; x < size; x++) {
		// 		System.out.print(" ");
		// 		System.out.print(mines[x][y] ? "*" : 
		// 			(counts[x][y] == 0 ? "_" : counts[x][y]));
		// 	}
		// 	System.out.println();
		// }

		//The code that do the visual 
        int squareSize = 50; //the scale of the window
        StdDraw.setCanvasSize(size * squareSize, size * squareSize); //the scale of the board/coordinate
        StdDraw.setXscale(0, size * squareSize); 
        StdDraw.setYscale(-size * squareSize, 0); //"flip" the coordinates cause the orientation
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (mines[x][y]) {
                    StdDraw.filledEllipse(x * squareSize + squareSize / 2, -y * squareSize - squareSize / 2, squareSize / 2, squareSize / 2);
                } else if (counts[x][y] > 0) {
					//takes the middle point of the potential block of text
					StdDraw.text(x * squareSize + squareSize / 2, -y * squareSize - squareSize / 2, 
					"" + counts[x][y]); //a trick to turn the number into a string
                }
            }
        }
	}
}