package app;

public class TestFiles {
	public static void main(String[] args) {
		Folder assignments = new Folder("assignments");
		Folder labs = new Folder("labs");
		assignments.add(labs);
		labs.add(new File("groupLab1"));
		labs.add(new File("groupLab2"));
		Folder homework = new Folder("homework");
		assignments.add(homework);
		homework.add(new File("homework1"));

		printTree(assignments, 0);
		System.out.println("Total files (counted via static method): " + countFiles(assignments));
		System.out.println("Total files (counted via instance method): " + assignments.countAllDescendents());
	}

	public static void printTree(File f, int indentLevel) {
		// Indent
		for (int i = 0; i < indentLevel; i++) {
			System.out.print("  ");
		}

		System.out.println(f.getName());
		for (int i = 0; i < f.getItems().size(); i++) {
			File f2 = f.getItems().get(i);
			printTree(f2, indentLevel + 1);
		}
	}

	public static int countFiles(File f) {
		int c = 1;
		for (File f2 : f.getItems()) {
			c += countFiles(f2);
		}
		return c;
	}
}