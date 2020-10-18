package app;

import java.util.Iterator;
import java.util.LinkedList;

import edu.princeton.cs.introcs.In;

public class TestLinkedList {
	public static void main(String[] args) {
		In in = new In("words");
		LinkedList<String> list = new LinkedList<>();
		while (in.hasNextLine()) {
			String s = in.readLine();
			list.addFirst(s);
		}

		// Remove nodes that contain the letter "l"
		Iterator<String> i = list.descendingIterator();
		while (i.hasNext()) {
			String s = i.next();
			if (s.indexOf("l") != -1) {
				i.remove();
			}
		}

		// Print out data
		for (String s : list) {
			System.out.println(s);
		}
	}
}