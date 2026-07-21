class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
        return solve(m-1,n-1,dp,obstacleGrid);
    }
    private int solve(int i, int j,int[][] dp, int[][] a){
        if(i>=0 && j>=0 && a[i][j]==1) return 0;
        if(i==0&&j==0) return 1;
        if(i<0||j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int up = solve(i-1,j,dp,a);
        int left = solve(i,j-1,dp,a);
        return dp[i][j] = up + left;
    }
}