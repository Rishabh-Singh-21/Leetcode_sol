class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] i : dp)
            Arrays.fill(i, -1);
        return solve(m-1,n-1,grid,dp);
    }
    private int solve(int i, int j,int[][] a,int[][] dp){
        if(i==0 && j==0) return a[0][0];
        if(i<0 || j<0) return (int)1e9;
        if(dp[i][j]!=-1) return dp[i][j];
        int up = a[i][j]+solve(i-1,j,a,dp);
        int left = a[i][j]+solve(i,j-1,a,dp);
        return dp[i][j]=Math.min(up,left);
    }
}