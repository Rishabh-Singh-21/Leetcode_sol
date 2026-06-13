class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();
        for(String word : words){
            int tw = 0;
            for(char ch : word.toCharArray()){
                tw += weights[ch - 'a'];
            }
            int md = tw%26;
            char mCh = (char)('z' - md);
            ans.append(mCh);
        }
        return ans.toString();
    }
}