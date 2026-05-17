class Solution {
    public boolean canReach(int[] arr, int start) {

        boolean[] visited = new boolean[arr.length];

        return dfs(arr, start, visited);
    }

    private boolean dfs(int[] arr,int idx,boolean[] visited) {

        if (idx < 0 || idx >= arr.length) {
            return false;
        }
        if (visited[idx]) {
            return false;
        }
        if (arr[idx] == 0) {
            return true;
        }

        visited[idx] = true;

        int forward = idx + arr[idx];
        int backward = idx - arr[idx];

        return dfs(arr, forward, visited)
            || dfs(arr, backward, visited);
    }
}