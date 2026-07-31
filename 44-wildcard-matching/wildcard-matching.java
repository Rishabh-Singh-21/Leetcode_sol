class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m= p.length();
        int[][] dp = new int[m][n];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return solve(m-1,n-1,s,p,dp);
    }
    private boolean solve(int i, int j,String s, String p,int[][] dp){
        if(i<0&&j<0) return true;
        if(i<0&&j>=0) return false;
        if(j<0&&i>=0){
           return isAllStars(p,i);
        }
        if(dp[i][j]!=-1) return dp[i][j]==1;
        if(p.charAt(i) == s.charAt(j) || p.charAt(i)== '?')  dp[i][j] = solve(i-1,j-1,s,p,dp) ?1:0;
        else if(p.charAt(i)=='*')  dp[i][j]=(solve(i-1,j,s,p,dp)||solve(i,j-1,s,p,dp))?1:0;
        else dp[i][j]=0;
        return dp[i][j]==1;
    }
    private boolean isAllStars(String S1, int i) {
        for (int j = 0; j <= i; j++) {
            if (S1.charAt(j) != '*')
                return false;
        }
        return true;
    }
}