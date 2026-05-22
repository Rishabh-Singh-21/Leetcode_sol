class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
    
        for(int num : nums){
            sum += num;
        }
        Boolean[][] dp = new Boolean[sum/2+1][nums.length+1];
        if(sum % 2 != 0) return false;
        return solve(dp,nums,0,sum/2);

    }
    public boolean solve(Boolean[][] dp,int[] nums,int i,int target){
        if(i >= nums.length) return false;
        if(target == 0) return true;
        if(target < 0)return false;
        if(dp[target][i] != null)return dp[target][i];

        boolean take = solve(dp,nums,i+1,target-nums[i]);
        boolean inTake = solve(dp,nums,i+1,target);
        return dp[target][i] = take || inTake;
    }
}