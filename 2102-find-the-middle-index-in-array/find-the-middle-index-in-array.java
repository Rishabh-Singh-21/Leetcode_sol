class Solution {
    public int findMiddleIndex(int[] nums) {
        int pref[] = new int[nums.length];
        pref[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            pref[i] = nums[i]+pref[i-1];
        }
        int suff[] = new int[nums.length];
        suff[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length-2;i>0;i--){
            suff[i] = nums[i]+suff[i+1];
        }
        for(int i=0;i<pref.length;i++){
            int left;
            if(i==0){
                left = 0; 
            }else{
                left = pref[i-1];
            }
            int right;
            if(i==nums.length-1){
                right =0;
            }else{
                right = suff[i+1];
            }
            if(left == right){
                return i;
            }
        }
        return -1;
    }
}