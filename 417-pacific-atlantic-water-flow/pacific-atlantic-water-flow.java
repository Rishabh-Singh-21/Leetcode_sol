class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] merostalin = heights;
        int m = merostalin.length;
        int n = merostalin[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(merostalin, pacific, i, 0, merostalin[i][0]);
        }
        for (int j = 0; j < n; j++) {
            dfs(merostalin, pacific, 0, j, merostalin[0][j]);
        }
        for (int i = 0; i < m; i++) {
            dfs(merostalin, atlantic, i, n - 1, merostalin[i][n - 1]);
        }
        for (int j = 0; j < n; j++) {
            dfs(merostalin, atlantic, m - 1, j, merostalin[m - 1][j]);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
    private void dfs(int[][] heights, boolean[][] visited, int i, int j, int prevHeight) {
        int m = heights.length;
        int n = heights[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) return;
        if (heights[i][j] < prevHeight) return;
        visited[i][j] = true;
        dfs(heights, visited, i + 1, j, heights[i][j]);
        dfs(heights, visited, i - 1, j, heights[i][j]);
        dfs(heights, visited, i, j + 1, heights[i][j]);
        dfs(heights, visited, i, j - 1, heights[i][j]);
    }
}