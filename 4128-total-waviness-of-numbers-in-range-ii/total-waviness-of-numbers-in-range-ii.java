class Solution {
    static class Pair {
        long count;
        long waviness;
        Pair(long count, long waviness) {
            this.count = count;
            this.waviness = waviness;
        }
    }
    String s;
    Pair[][][][][] memo;
    boolean[][][][][] seen;
    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }
    private long solve(long x) {
        if (x <= 0) return 0;
        s = String.valueOf(x);
        int n = s.length();
        memo = new Pair[n][2][2][11][11];
        seen = new boolean[n][2][2][11][11];
        Pair res = dfs(0, 1, 0, 10, 10);
        return res.waviness;
    }
    private Pair dfs(int pos,
                     int tight,
                     int started,
                     int prevPrev,
                     int prev) {
        if (pos == s.length()) {
            return new Pair(1, 0);
        }
        if (seen[pos][tight][started][prevPrev][prev]) {
            return memo[pos][tight][started][prevPrev][prev];
        }
        seen[pos][tight][started][prevPrev][prev] = true;
        int limit = tight == 1 ? s.charAt(pos) - '0' : 9;
        long totalCount = 0;
        long totalWave = 0;
        for (int digit = 0; digit <= limit; digit++) {
            int nextTight =
                    (tight == 1 && digit == limit) ? 1 : 0;
            if (started == 0 && digit == 0) {
                Pair child =
                        dfs(pos + 1,
                                nextTight,
                                0,
                                10,
                                10);
                totalCount += child.count;
                totalWave += child.waviness;
            }
            else {
                if (started == 0) {
                    Pair child =
                            dfs(pos + 1,
                                    nextTight,
                                    1,
                                    10,
                                    digit);
                    totalCount += child.count;
                    totalWave += child.waviness;
                }
                else {
                    int add = 0;
                    if (prevPrev != 10) {
                        boolean peak =
                                prev > prevPrev &&
                                prev > digit;
                        boolean valley =
                                prev < prevPrev &&
                                prev < digit;
                        if (peak || valley) {
                            add = 1;
                        }
                    }
                    Pair child =
                            dfs(pos + 1,
                                    nextTight,
                                    1,
                                    prev,
                                    digit);

                    totalCount += child.count;
                    totalWave += child.waviness
                            + (long) add * child.count;
                }
            }
        }
        return memo[pos][tight][started][prevPrev][prev] =
                new Pair(totalCount, totalWave);
    }
}