class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totsum =0;
        for(int i=0;i<nums.length;i++){
            totsum+=nums[i];
        }
        if(totsum - target<0 || (totsum-target)%2!=0) return 0;
        return ways(nums,(totsum - target)/2);
    }
    static int ways(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n][target+1];
        for(int[]i:dp){
            Arrays.fill(i,-1);
        }
        return solve(n-1,target,arr,dp);
    }
    static int solve(int idx,int s,int[] a,int[][] dp){
        if(idx==0){
            if(s == 0 && a[0] == 0) return 2;
            if(s == 0 || s == a[0]) return 1;
            return 0;
        }
        if(dp[idx][s]!=-1) return dp[idx][s];
        int nopick=solve(idx-1,s,a,dp);
        int pick =0;
        if(a[idx]<=s) pick = solve(idx-1,s-a[idx],a,dp);
        return dp[idx][s]= nopick+pick;
    }
}