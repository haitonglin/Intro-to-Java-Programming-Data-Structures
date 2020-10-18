package app;

import edu.princeton.cs.introcs.*;

public class Minesweeper {
    public static void main(String[] args) {
        int size = 9;
        boolean[][] mines = new boolean[size][size]; //default setting theres no mines

        //putting mines on
        int numberOfMines = 10;  
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

        //putting numbers on
        int[][] counts = new int[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (mines[x][y]) {
                    //the algorithm works from (x-1,x+1) when x has mine
                    //max and min are used when x+1 or x-1 go off the board
                    for (int x1 = Math.max(0, x - 1); x1 <= Math.min(size - 1, x + 1); x1++) {
                        //very common way 
                        //that means like: take x+1 unless its bigger than size-1, then just take size-1
                        //and: take x-1 unless its less than 0, then just take 0
                        for (int y1 = Math.max(0, y - 1); y1 <= Math.min(size - 1, y + 1); y1++) {
                            ++counts[x1][y1];
                        }
                    }
                }
            }
        }

        int xCursor = 0;
        int yCursor = 0;
        boolean[][] revealed = new boolean[size][size]; //record the previous steps
        while (true) {
            for (int y = 0; y < size; y++) {
                for (int x = 0; x < size; x++) {
                    System.out.print(xCursor == x && yCursor == y ? ">" : " ");
                    System.out.print(revealed[x][y] ? (counts[x][y] == 0 ? "_" : counts[x][y]) : "X");
                }
                System.out.println();
            }
    
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
                if (mines[xCursor][yCursor]) { //dont need to compare cause boolean is already true/false
                    System.out.println("Sorry.. you stepped on a mine");
                    break;
                }
                revealed[xCursor][yCursor] = true; //mark that you've stepped on it
            }
        }

        //print the entire graph out in the end
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                System.out.print(" ");
                System.out.print(mines[x][y] ? "*" : (counts[x][y] == 0 ? "_" : counts[x][y]));
            }
            System.out.println();
        }
    }
}