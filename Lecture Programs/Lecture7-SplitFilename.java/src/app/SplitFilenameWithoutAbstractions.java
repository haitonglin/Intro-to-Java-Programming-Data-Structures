package app;

public class SplitFilenameWithoutAbstractions {
	public static void main(String[] args) {
		String s0 = args[0];
		char[] s = s0.toCharArray();

		//where is .
		int dot = -1;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == '.') {
				dot = i;
				break;
			}
		}

		//the part before . 
		char[] base = new char[dot]; 
		for (int i = 0; i < dot; i++) {
			base[i] = s[i];
		}

		//the part after .
		char[] extension = new char[s.length - dot - 1];
		for (int i = dot + 1; i < s.length; i++) {
			extension[i - dot - 1] = s[i];
		}


		//base and extension are actually arrays of char
		System.out.print("Base: ");
		System.out.println(base); 
		System.out.print("Extension: ");
		System.out.println(extension);
	}
}