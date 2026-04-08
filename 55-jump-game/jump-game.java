class Solution {
    public boolean canJump(int[] nums) {
        int c=0;
        for(int i=0;i<nums.length;i++){
            if(i>c) return false;
            c= Math.max(c,i+nums[i]);
            if(c>=nums.length-1) return true;
        }
        return true;
    }
}