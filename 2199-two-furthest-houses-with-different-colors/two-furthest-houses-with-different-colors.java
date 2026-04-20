class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int mdist = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (colors[i] != colors[j]) {
                    mdist = Math.max(mdist, j - i);
                }
            }
        }
        return mdist;
    }
}