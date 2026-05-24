class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        int i = 0;
        int j = 0;
        int size = nums.length;
        double max = -Double.MAX_VALUE;

        while(j < size){
            sum = sum + nums[j];
            
            if(j-i+1 < k){
                j++;
            }
            else if(j-i+1 == k){
                max = Math.max(max,sum);
                sum = sum - nums[i];
                i++;
                j++;
            }
        }
        return max/k;
    }
}