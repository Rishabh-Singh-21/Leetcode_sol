class Solution {
    public int fib(int n) {
        return fibonacci(n);
    }
    private static int fibonacci(int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        if (n <= 1) {
            return n;
        }
        if(dp[n]!=-1) return dp[n];
        return dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}