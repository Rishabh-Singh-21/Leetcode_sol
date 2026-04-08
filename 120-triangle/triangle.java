class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1;i < n;i++) {
            for (int j = i;j >= 0;j--) {
                int val =triangle.get(i).get(j);
                if (j == 0) {
                    dp[j] = dp[j] + val;
                } else if (j == i) {
                    dp[j] = dp[j - 1] + val;
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + val;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int num : dp) {
            min = Math.min(min, num);
        }
        return min;
    }
}