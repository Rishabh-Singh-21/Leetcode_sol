class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> freq = new HashMap<>();

        for (int x : nums) {
            freq.put((long) x, freq.getOrDefault((long) x, 0) + 1);
        }

        int ans = 1;
        if (freq.containsKey(1L)) {
            int cnt = freq.get(1L);
            if (cnt % 2 == 0) {
                ans = Math.max(ans, cnt - 1);
            } else {
                ans = Math.max(ans, cnt);
            }
        }

        for (long start : freq.keySet()) {

            if (start == 1L) continue;

            long cur = start;
            int len = 0;

            while (true) {

                Integer cnt = freq.get(cur);

                if (cnt == null) break;

                if (cnt >= 2) {
                    len += 2;
                } else {
                    len++;
                    break;
                }

                if (cur > 1000000000L / cur) {
                    len--;
                    break;
                }

                cur *= cur;
            }

            if (len % 2 == 0) len--;

            ans = Math.max(ans, len);
        }

        return ans;
    }
}