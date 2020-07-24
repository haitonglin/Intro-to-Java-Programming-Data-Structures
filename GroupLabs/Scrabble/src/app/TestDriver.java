package app;

import java.util.ArrayList;

public class TestDriver {
	public static void main(String[] args) {
		Board a = new SmartBoard();
		Board b = new BrokenBoard();
		Board c = new BinarySearchBoard();
		ArrayList<Board> boards = new ArrayList<>();
		boards.add(a); boards.add(b); boards.add(c);
		BoardComparisonProxy boardlist = new BoardComparisonProxy(boards);
		testBoard(boardlist);
	}

	public static void testBoard(BoardComparisonProxy board) {

		//board.setupNewBoard("https://www.wordgamedictionary.com/sowpods/download/sowpods.txt", 10, 10);
		// TIP: download the file and save it to the project directory to save a lot of time; then, comment out the line above and un-comment the line below
		board.setupNewBoard("sowpods.txt", 10, 10);

		System.out.println(board.getColumns());
		System.out.println(board.getRows());

		Play p1 = new Play(4, 0, "Duke", false);
		System.out.println("Playing word " + p1 + " - used letters \'" + board.playWord(p1, false) + "\' (should be \'duke\')");
		System.out.println(board);

		Play p2 = new Play(0, 1, "compUter", true);
		System.out.println("Playing word " + p2 + " - used letters \'" + board.playWord(p2, false) + "\' (should be \'compter\')");
		System.out.println(board);

		Play p3 = new Play(8, 1, "science", false);
		System.out.println("Dry-running word " + p3 + " - used letters \'" + board.playWord(p3, true) + "\' (should be \'science\' -- and board should be unchanged)");
		System.out.println(board);

		System.out.println("Playing word " + p3 + " - used letters \'" + board.playWord(p3, false) + "\' (should be \'science\')");
		System.out.println(board);

		Play p4 = new Play(8, 1, "lab", false);
		System.out.println("Playing word " + p4 + " - used letters \'" + board.playWord(p4, false) + "\' (should be \'null\' -- not allowed)");
		System.out.println(board);

		Play p5 = new Play(6, 0, "mEter", false);
		System.out.println("Playing word " + p5 + " - used letters \'" + board.playWord(p5, false) + "\' (should be \'mter\'）");
		System.out.println(board);

		Play p6 = new Play(5, 3, "meter", true);
		System.out.println("Playing word " + p6 + " - used letters \'" + board.playWord(p6, false) + "\' (should be \'null\' -- not allowed)");
		System.out.println(board);

		System.out.println(board.getLetterAt(5, 3));

	}
}