class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        return solve(nums,k);
    }
    public int countPartitions(int[] a, int maxSum) {
        int n = a.length;
        int partitions = 1;
        long subarraySum = 0;

        for (int i = 0; i < n; i++) {
            if (subarraySum + a[i] <= maxSum) {
                subarraySum += a[i];
            } else {
                partitions++;
                subarraySum = a[i];
            }
        }
        return partitions;
    }
    public int solve(int[] a, int k) {
        int low = Arrays.stream(a).max().getAsInt();
        int high = Arrays.stream(a).sum();
        while(low<=high){
            int mid = (low+high)/2;
            int nonstd=countPartitions(a,mid);
            if(nonstd>k) low = mid+1;
            else high = mid-1;
        }
        return low;
    }
    
}