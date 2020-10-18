package app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

import edu.princeton.cs.introcs.*;

public class AirportCollectionTest {
	public static void fillCollection(String[] airports, Collection c) {
		for (int i = 0; i < airports.length; i++) {
			c.add(airports[i]);
		}
	}

	public static void accessEveryAirport(String[] airports, Collection c) {
		for (int i = 0; i < airports.length; i++) {
			if (!c.contains(airports[i])) {
				System.out.println("Didn't find airport " + airports[i]);
			}
		}
	}

	public static String[] readAirports() {
		In in = new In("airports.csv");
		String[] lines = in.readAllLines();
		for (int i = 0; i < lines.length; i++) {
			lines[i] = lines[i].split(",")[1];
		}
		System.out.println("Read " + lines.length + " airports");
		return lines;
	}

	public static void main(String[] args) {
		String[] airports = readAirports();

		final int iterations = 100;
		ArrayList arrayList = new ArrayList();
		TreeSet treeSet = new TreeSet();

		fillCollection(airports, arrayList);
		fillCollection(airports, treeSet);

		Stopwatch arrayListStopwatch = new Stopwatch();
		for (int i = 0; i < iterations; i++) {
			accessEveryAirport(airports, arrayList);
		}
		System.out.println("Array list time: " + arrayListStopwatch.elapsedTime());

		Stopwatch treeSetStopwatch = new Stopwatch();
		for (int i = 0; i < iterations; i++) {
			accessEveryAirport(airports, treeSet);
		}
		System.out.println("Tree set time: " + treeSetStopwatch.elapsedTime());
	}
}