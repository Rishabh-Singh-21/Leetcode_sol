class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for(List<Integer> list : map.values()){
            int size = list.size();
            long prefixSum = 0;
            for(int i = 0; i < size; i++){
                int idx = list.get(i);
                res[idx] += (long)i * idx - prefixSum;
                prefixSum += idx;
            }
            prefixSum = 0;
            for(int i = size - 1; i >= 0; i--){
                int idx = list.get(i);
                res[idx] += prefixSum - (long)(size - i - 1) * idx;
                prefixSum += idx;
            }
        }
        return res;
    }
}