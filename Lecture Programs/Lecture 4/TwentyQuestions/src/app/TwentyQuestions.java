package app;

import edu.princeton.cs.introcs.*; //import statement-make use of packages

public class TwentyQuestions {
	public static void main(String[] args) {
		// Generate a number and answer questions
		// while the user tries to guess the value.
		int secret = 1 + (int) (Math.random() * 1000000); //get a number between 1 and 1m

		StdOut.print("I'm thinking of a number ");
		StdOut.println("between 1 and 1,000,000");
		int guess = 0; 
		while (guess != secret) {
			// Solicit one guess and provide one answer
			StdOut.print("What's your guess? "); 
			guess = StdIn.readInt();  //read a single int from input
			if (guess < secret) {
				StdOut.println("Too low");
			} else if (guess > secret) {
				StdOut.println("Too high");
			}	else {
				StdOut.println("You win!");
			}
		}
	}
} 