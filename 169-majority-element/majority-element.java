class Solution {
    public int majorityElement(int[] nums) {
        int n =-1;
        int c=0;
        for(int i:nums){
            if(c==0){
                n=i;
                c=1;
            }else if(i==n){
                c++;
            }else c--;
        }
        c=0;
        for(int i:nums){
            if(i==n) c++;
        }
        if(c>nums.length/2){
            return n;
        }else return -1;
    }
}