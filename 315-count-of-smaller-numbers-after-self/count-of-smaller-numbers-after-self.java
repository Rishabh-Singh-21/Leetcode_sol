class Solution {
    int[] tree;
    int size = 20001;

    void update(int node, int start, int end, int idx) {
        if (start == end) {
            tree[node] += 1;
            return;
        }

        int mid = (start + end) / 2;

        if (idx <= mid)
            update(2 * node + 1, start, mid, idx);
        else
            update(2 * node + 2, mid + 1, end, idx);

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l)
            return 0;

        if (l <= start && end <= r)
            return tree[node];

        int mid = (start + end) / 2;

        return query(2 * node + 1, start, mid, l, r)
                + query(2 * node + 2, mid + 1, end, l, r);
    }

    public List<Integer> countSmaller(int[] nums) {

        tree = new int[4 * size];
        Integer[] ans = new Integer[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {

            int val = nums[i] + 10000;

            ans[i] = query(0, 0, size - 1, 0, val - 1);

            update(0, 0, size - 1, val);
        }

        return Arrays.asList(ans);
    }
}