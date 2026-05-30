class Solution {
    static class Fenwick {
        int[] bit;
        Fenwick(int n) {
            bit = new int[n + 2];
        }
        void update(int idx, int val) {
            idx++;
            while (idx < bit.length) {
                bit[idx] = Math.max(bit[idx], val);
                idx += idx & -idx;
            }
        }
        int query(int idx) {
            idx++;
            int ans = 0;
            while (idx > 0) {
                ans = Math.max(ans, bit[idx]);
                idx -= idx & -idx;
            }
            return ans;
        }
    }
    public List<Boolean> getResults(int[][] queries) {
        int maxX = 0;
        for (int[] q : queries) {
            maxX = Math.max(maxX, q[1]);
        }
        int LIMIT = maxX + 1;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(LIMIT);
        for (int[] q : queries) {
            if (q[0] == 1) {
                set.add(q[1]);
            }
        }
        Fenwick fw = new Fenwick(LIMIT + 5);
        Integer prev = null;
        for (int x : set) {
            if (prev != null) {
                fw.update(x, x - prev);
            }
            prev = x;
        }
        ArrayList<Boolean> ans = new ArrayList<>();
        for (int i = queries.length - 1; i >= 0; i--) {
            int[] q = queries[i];
            if (q[0] == 1) {
                int x = q[1];
                Integer left = set.lower(x);
                Integer right = set.higher(x);
                set.remove(x);
                fw.update(right, right - left);
            } else {
                int x = q[1];
                int sz = q[2];
                Integer leftObstacle = set.floor(x);
                int bestGapBefore = fw.query(leftObstacle);
                boolean ok =bestGapBefore >= sz ||(x - leftObstacle) >= sz;
                ans.add(ok);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}