class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        int n = s.length();
        return check(s,0,n);
    }
    private boolean check(String s,int i,int n){
        if(i>=n/2) return true;
        if(s.charAt(i)!=s.charAt(n-i-1)) return false;
        return check(s,i+1,n);
    }
}