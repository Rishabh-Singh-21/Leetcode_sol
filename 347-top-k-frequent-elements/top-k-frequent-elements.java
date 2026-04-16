class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        List<int[]> list = new ArrayList<>();
        int count = 1;
        for(int i = 1; i <= nums.length; i++){
            if(i < nums.length && nums[i] == nums[i-1]){
                count++;
            } else {
                list.add(new int[]{nums[i-1], count});
                count = 1;
            }
        }
        list.sort((a, b) -> b[1] - a[1]);
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = list.get(i)[0];
        }
        return res;
    }
}