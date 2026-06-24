class Solution {

    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {

        int m = r - l + 1;
        int sz = 2 * m;

        long[] base = new long[sz];

        for (int v = 0; v < m; v++) {
            base[v] = v;                 
            base[m + v] = m - 1 - v;    
        }

        if (n == 2) {
            long ans = 0;
            for (long x : base) {
                ans = (ans + x) % MOD;
            }
            return (int) ans;
        }

        long[][] T = new long[sz][sz];

        for (int v = 0; v < m; v++) {
            for (int x = 0; x < v; x++) {
                T[v][m + x] = 1;
            }
            for (int x = v + 1; x < m; x++) {
                T[m + v][x] = 1;
            }
        }

        long[][] P = power(T, n - 2);

        long[] res = multiply(P, base);

        long ans = 0;

        for (long x : res) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }

    private long[][] power(long[][] A, long exp) {

        int n = A.length;

        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {

            if ((exp & 1) == 1) {
                res = multiply(res, A);
            }

            A = multiply(A, A);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {

        int n = A.length;

        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {

            for (int k = 0; k < n; k++) {

                if (A[i][k] == 0) continue;

                long val = A[i][k];

                for (int j = 0; j < n; j++) {

                    if (B[k][j] == 0) continue;

                    C[i][j] = (C[i][j] + val * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }

    private long[] multiply(long[][] A, long[] v) {

        int n = A.length;

        long[] res = new long[n];

        for (int i = 0; i < n; i++) {

            long cur = 0;

            for (int j = 0; j < n; j++) {
                cur = (cur + A[i][j] * v[j]) % MOD;
            }

            res[i] = cur;
        }

        return res;
    }
}