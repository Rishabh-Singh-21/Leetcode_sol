class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int [] i:dp){
            Arrays.fill(i,-1);
        }
        return solve(n-1,amount,coins,dp);
    }
    private int solve(int idx,int t,int[] a,int[][] dp){
        if(idx==0) {
            if(t%a[0]==0){
                return 1;
            }else return 0;
        }
        if(dp[idx][t]!=-1) return dp[idx][t];
        int notake = solve(idx-1,t,a,dp);
        int take = 0;
        if(a[idx]<=t) take = solve(idx,t-a[idx],a,dp);
        return dp[idx][t]=notake+take;
    }
}