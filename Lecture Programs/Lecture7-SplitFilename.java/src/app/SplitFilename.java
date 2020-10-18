package app;

public class SplitFilename {
	public static void main(String[] args) {
		String s = args[0];

		//the "hard part" are the following 3 lines
		int dot = s.indexOf(".");
		String base = s.substring(0, dot); //get the part before
		String extension = s.substring(dot + 1, s.length()); //get the part after

		System.out.println("Base: " + base);
		System.out.println("Extension: " + extension);
	}
}