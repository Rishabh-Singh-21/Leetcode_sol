class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[] cur=intervals[0];
        for (int i=1;i<intervals.length;i++) {
            if (cur[1]>=intervals[i][0]) {
                cur[1]=Math.max(cur[1],intervals[i][1]);
            } else {
                ans.add(cur);
                cur=intervals[i];
            }
        }
        ans.add(cur);
        int[][] res = new int[ans.size()][2];
        for (int i=0;i<ans.size();i++) {
            res[i] = ans.get(i);
        }
        return res; 
    }
}