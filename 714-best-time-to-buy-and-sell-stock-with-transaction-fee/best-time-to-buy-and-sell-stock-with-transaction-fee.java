class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[]i:dp){
            Arrays.fill(i,-1);
        }
        return solve(0,0,n,prices,dp,fee);
    }
    private int solve(int idx,int buy,int n, int[] a,int[][] dp,int fees){
        if(idx==n) return 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        int profit;
        if(buy==0){
            profit = Math.max(0+solve(idx+1,0,n,a,dp,fees),-a[idx]+solve(idx+1,1,n,a,dp,fees));
        }
        else{
            profit= Math.max(0+solve(idx+1,1,n,a,dp,fees),a[idx]-fees+solve(idx+1,0,n,a,dp,fees));
        }
        return dp[idx][buy]=profit;
    }
}