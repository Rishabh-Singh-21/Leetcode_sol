class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] arr = new int[c+2];
        arr[0]=0;
        arr[c+1]=n;
        for(int i=0;i<c;i++){
            arr[i+1]=cuts[i];
        }
        Arrays.sort(arr);
        int[][] dp = new int[c+1][c+1];
        for(int[]i:dp){
            Arrays.fill(i,-1);
        }
        return solve(1,c,arr,dp);
    }
    private static int solve(int i, int j,int[] cuts,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int cmin = Integer.MAX_VALUE;
        for(int z =i;z<=j;z++){
            int cost = cuts[j+1]-cuts[i-1]+solve(i,z-1,cuts,dp)+solve(z+1,j,cuts,dp);
            cmin = Math.min(cmin,cost);
        }
        return dp[i][j]=cmin;
    }
}