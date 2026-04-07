class Solution {
    public int[] runningSum(int[] nums) {
        int[] pre = new int[nums.length];
        pre[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            pre[i] = nums[i]+pre[i-1];
        }
        return pre;
    }
}