class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> primes = primeFactors(nums[i]);
            for (int p : primes) {
                map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.offer(0);
        visited[0] = true;
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int i = q.poll();
                if (i == n - 1) return steps;
                if (i - 1 >= 0 && !visited[i - 1]) {
                    visited[i - 1] = true;
                    q.offer(i - 1);
                }
                if (i + 1 < n && !visited[i + 1]) {
                    visited[i + 1] = true;
                    q.offer(i + 1);
                }
                if (isPrime(nums[i])) {
                    int p = nums[i];
                    if (map.containsKey(p)) {
                        for (int next : map.get(p)) {
                            if (!visited[next]) {
                                visited[next] = true;
                                q.offer(next);
                            }
                        }
                        map.remove(p);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    private boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
    private List<Integer> primeFactors(int x) {
        List<Integer> res = new ArrayList<>();
        for (int p = 2; p * p <= x; p++) {
            if (x % p == 0) {
                res.add(p);
                while (x % p == 0) {
                    x /= p;
                }
            }
        }
        if (x > 1) {
            res.add(x);
        }
        return res;
    }
}