class Solution {
    public int numberOfSpecialChars(String word) {
        int cnt = 0;
        int n = word.length();
        for(char i='a';i<='z';i++) {
            boolean lower = false;
            boolean upper = false;
            for(int j= 0;j<n;j++) {
                if(word.charAt(j)==i) {
                    lower = true;
                }
                if(word.charAt(j)==Character.toUpperCase(i)) {
                    upper = true;
                }
            }
            if(lower && upper) {
                cnt++;
            }
        }
        return cnt;
    }
}