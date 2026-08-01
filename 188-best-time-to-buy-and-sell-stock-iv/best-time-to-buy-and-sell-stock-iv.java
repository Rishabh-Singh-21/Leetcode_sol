class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k+1];
        for(int[][] i:dp){
            for(int[]j:i){
                Arrays.fill(j,-1);
            }
        }
        return solve(0,0,k,prices,n,dp);
    }
    private static int solve(int idx, int buy, int cap,int[] p,int n,int[][][]dp){
        if(cap==0) return 0;
        if(idx==n) return 0;
        if(dp[idx][buy][cap]!=-1) return dp[idx][buy][cap];
        int profit;
        if(buy==0){
            profit= Math.max(0+solve(idx+1,0,cap,p,n,dp),-p[idx]+solve(idx+1,1,cap,p,n,dp));
        }
        else{
            profit=Math.max(0+solve(idx+1,1,cap,p,n,dp),p[idx]+solve(idx+1,0,cap-1,p,n,dp));
        }
        return dp[idx][buy][cap]=profit;
    }
}