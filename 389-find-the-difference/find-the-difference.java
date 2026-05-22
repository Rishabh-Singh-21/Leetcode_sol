class Solution {
    public char findTheDifference(String s, String t) {
        char ch[] = s.toCharArray();
        char ch1[] = t.toCharArray();
        Arrays.sort(ch);
        Arrays.sort(ch1);
        for(int i = 0;i < ch.length;i++){
            if(ch[i] != ch1[i]){
                return ch1[i];
            }
        }
        return ch1[ch1.length-1];
    }
}