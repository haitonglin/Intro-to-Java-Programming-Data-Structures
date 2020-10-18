package app;

import java.util.ArrayList;
import java.util.Collections;

public class SortNumbers {
	public static void main(String[] args) {
		ArrayList<Integer> listOfNumbers = new ArrayList<>();
		for (int i = 0; i < args.length; i++) {
			listOfNumbers.add(Integer.parseInt(args[i]));
		}

		Collections.sort(listOfNumbers);
		System.out.println(listOfNumbers);
	}
}