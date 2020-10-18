package app;

public class Fibonacci {
    public static long fibonacci(int n) {
        if (n == 0) {  //base case
            return 0;
        } else if (n == 1) {
            return 1;
        }
        
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        // int n = Integer.parseInt(args[0]);
        int n = 44;
        System.out.println(fibonacci(n));
    }
}

// the reasons why this runs slow: lots of redundency (calculated fib(2) over and over again)