class Solution {
    public int singleNumber(int[] nums) {
       int n = nums.length;
        for(int i = 0;i < n;i++){
            boolean flag = false;
            for(int j = 0;j < n;j++){
                if(i != j && nums[i] == nums[j]){
                    flag = true;
                } 
            }
            if(flag != true) return nums[i];
        }
        return -1; 
    }
}