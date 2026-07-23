class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m = grid[0].length;
        int [][][] dp = new int[n][m][m];
        for(int [][] i:dp){
            for(int[]j:i){
                Arrays.fill(j,-1);
            }
        }
        return solve(0,0,m-1,grid,n,m,dp);
    }
    private int solve(int i, int j1,int j2,int[][] a,int n, int m,int[][][] dp){
        if(j1<0||j1>=m||j2<0||j2>=m){
            return (int)-1e9;
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        if(i==n-1){
            if(j1==j2) return a[i][j1];
            else return a[i][j1]+a[i][j2];
        }
        int maxi =0;
        for(int dj1=-1;dj1<+2;dj1++){
            for(int dj2=-1;dj2<+2;dj2++){
                if(j1==j2){
                    maxi = Math.max(maxi,a[i][j1]+solve(i+1,j1+dj1,j2+dj2,a,n,m,dp));
                }
                else{
                    maxi = Math.max(maxi,a[i][j1]+a[i][j2]+solve(i+1,j1+dj1,j2+dj2,a,n,m,dp));
                }
            }
        }
        return dp[i][j1][j2]=maxi;
    }
}