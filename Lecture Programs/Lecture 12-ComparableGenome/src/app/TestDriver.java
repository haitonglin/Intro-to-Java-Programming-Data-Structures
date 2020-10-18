package app;

import java.util.ArrayList;
import java.util.Collections;

public class TestDriver {
	public static void main(String[] args) {
		Genome tca = new Genome();
		tca.addNucleotide('T');
		tca.addNucleotide('C');
		tca.addNucleotide('A');

		Genome tag = new Genome();
		tag.addNucleotide('T');
		tag.addNucleotide('A');
		tag.addNucleotide('G');

		Genome tagtag = new Genome();
		tagtag.addNucleotide('T');
		tagtag.addNucleotide('A');
		tagtag.addNucleotide('G');
		tagtag.addNucleotide('T');
		tagtag.addNucleotide('A');
		tagtag.addNucleotide('G');

		ArrayList<Genome> genomes = new ArrayList<Genome>();
		genomes.add(tagtag);
		genomes.add(tca);
		genomes.add(tag);

		Collections.sort(genomes);
		System.out.println(genomes);
	}
}