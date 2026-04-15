class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int max=0;
        int n = heights.length;
        for(int i=0;i<=n;i++){
            int curr;
            if(i==n){
                curr =0;
            }else{
                curr = heights[i];
            }
            while(!st.isEmpty()&& curr<heights[st.peek()]){
                int w,h=heights[st.pop()];
                if(st.isEmpty()) w=i;
                else w=i-st.peek()-1;
                max = Math.max(max,h*w);
            }
            st.push(i);
        }
        return max;
    }
}