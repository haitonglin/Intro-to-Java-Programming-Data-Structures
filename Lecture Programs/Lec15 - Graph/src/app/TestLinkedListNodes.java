package app;

import edu.princeton.cs.introcs.In;

public class TestLinkedListNodes {
	public static void main(String[] args) {
		In in = new In("words");
		LinkedListNode first = null;
		LinkedListNode last = null;
		while (in.hasNextLine()) {
			String s = in.readLine();
			LinkedListNode node = new LinkedListNode();
			node.setData(s);
			if (first == null) {
				last = first = node;
			} else {
				node.setNext(first);
				first.setPrevious(node);
				first = node;
				// node.setPrevious(last);
				// last.setNext(node);
				// last = node;
			}
		}

		// Remove nodes that contain the letter "l"
		LinkedListNode node = first;
		while (node != null) {
			if (node.getData().indexOf("l") != -1) {
				if (node == first) {
					first = node.getNext();
				} else {
					node.getPrevious().setNext(node.getNext());
				}
				if (node == last) {
					last = node.getPrevious();
				} else {
					node.getNext().setPrevious(node.getPrevious());
				}
			}
			node = node.getNext();
		}

		// Print out data
		node = first;
		while (node != null) {
			System.out.println(node.getData());
			node = node.getNext();
		}
	}
}