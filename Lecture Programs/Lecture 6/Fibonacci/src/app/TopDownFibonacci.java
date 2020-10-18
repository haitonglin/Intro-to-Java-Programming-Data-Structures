package app;

public class TopDownFibonacci {
    public static long fibonacci(int n, long[] memo) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (memo[n] > 0) {
            // Already been memoized
            return memo[n];
        } 
        
        memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        // int n = Integer.parseInt(args[0]);
        int n = 44;
        long[] memo = new long[92];
        System.out.println(fibonacci(n, memo));
    }
}