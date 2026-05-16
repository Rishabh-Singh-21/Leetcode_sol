class Solution {
    public int fib(int n) {
        return fibonacci(n);
    }
    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}