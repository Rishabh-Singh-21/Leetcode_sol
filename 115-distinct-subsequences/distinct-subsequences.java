class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for(int []i:dp){
            Arrays.fill(i,-1);
        }
        return solve(n-1,m-1,s,t,dp);
    }
    private int solve(int i, int j,String s, String s2,int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s2.charAt(j)) return dp[i][j]=solve(i-1,j-1,s,s2,dp)+solve(i-1,j,s,s2,dp);
        else return dp[i][j]=solve(i-1,j,s,s2,dp);
    }
}