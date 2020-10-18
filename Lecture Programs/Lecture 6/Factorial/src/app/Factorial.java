package app;

public class Factorial {
	public static long factorial(int n) {
		if (n == 1) {
			return 1;
		}
		
		return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		// int n = Integer.parseInt(args[0]);
		int n = 3;
		System.out.println(factorial(n));
	}
}