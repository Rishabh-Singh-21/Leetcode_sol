class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            res.add(new ArrayList<>());
        }
        int[] d = new int[numCourses];
        for(int i[] : prerequisites){
            res.get(i[1]).add(i[0]);
            d[i[0]]++;
            
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<numCourses;i++){
            if(d[i]==0){
                q.add(i);
            }
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            cnt++;
            for(int i : res.get(curr)){
                d[i]--;
                if(d[i]==0){
                    q.add(i);
                }
            }
        }
        return cnt == numCourses;

    }
}