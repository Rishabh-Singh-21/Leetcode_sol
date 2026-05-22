class Solution {
    public int heightChecker(int[] heights) {
        int c=0;
        int e [] = new int[heights.length];
        for(int i=0;i<heights.length;i++){
            e[i] = heights[i];
        }
        Arrays.sort(heights);
        for(int i=0;i<heights.length;i++){
            if(heights[i]!=e[i]){
                c++;
            }
        }
        return c;
    }
}