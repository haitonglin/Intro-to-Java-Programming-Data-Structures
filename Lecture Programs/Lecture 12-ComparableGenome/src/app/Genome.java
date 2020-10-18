package app;

public class Genome implements Comparable<Genome> {
	private String nucleotides = "";

	public Genome() {
	}

	public void addNucleotide(char ch) {
		nucleotides += ch;
	}

	public char nucleotideAt(int i) {
		return nucleotides.charAt(i);
	}

	public String toString() {
		return nucleotides;
	}

	public int compareTo(Genome that) {
		// return this.nucleotides.compareTo(that.nucleotides);
		for (int i = 0; i < this.nucleotides.length() && i < that.nucleotides.length(); i++) {
			char ch1 = this.nucleotideAt(i);
			char ch2 = that.nucleotideAt(i);
			if (ch1 < ch2) {
				return -1;
			} else if (ch1 > ch2) {
				return 1;
			}
		}
		return this.nucleotides.length() - that.nucleotides.length();
	}
}