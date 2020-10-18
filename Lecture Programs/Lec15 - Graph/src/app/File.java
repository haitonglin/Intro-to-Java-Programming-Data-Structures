package app;

import java.util.Collections;
import java.util.List;

public class File {
	private String name;
	private Folder parentFolder;

	public File(String name) {
		this.name = name;
	}

	protected void setParentFolder(Folder parentFolder) {
		this.parentFolder = parentFolder;
	}

	public Folder getParentFolder() {
		return this.parentFolder;
	}

	public String getName() {
		return this.name;
	}

	public List<File> getItems() {
		return Collections.emptyList();
	}

	public int countAllDescendents() {
		int c = 1;
		for (File f2 : getItems()) {
			c += f2.countAllDescendents();
		}
		return c;
	}
}