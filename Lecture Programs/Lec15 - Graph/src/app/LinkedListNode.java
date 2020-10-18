package app;

public class LinkedListNode {
	private LinkedListNode previous;
	private LinkedListNode next;
	private String data;

	public LinkedListNode getPrevious() {
		return previous;
	}

	public String getData() {
		return data;
	}

	public LinkedListNode getNext() {
		return next;
	}

	public void setNext(LinkedListNode next) {
		this.next = next;
	}

	public void setPrevious(LinkedListNode previous) {
		this.previous = previous;
	}

	public void setData(String data) {
		this.data = data;
	}
}