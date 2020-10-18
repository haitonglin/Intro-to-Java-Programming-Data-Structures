package app;

import java.util.ArrayList;
import java.util.List;

public class Folder extends File {
	private ArrayList<File> items = new ArrayList<>();

	public Folder(String name) {
		super(name);
	}

	public void add(File f) {
		this.items.add(f);
		f.setParentFolder(this);
	}

	public List<File> getItems() {
		return items;
	}
}