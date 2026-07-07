class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> res = new HashSet<>();
        backtrack(res,new ArrayList(),nums,0,nums.length);
        List<List<Integer>> ans = new ArrayList<>(res);
        return ans;
    }
    private static void backtrack(HashSet<List<Integer>> res,List<Integer> l, int nums[],int s,int n){
        if(s==n){
            res.add(new ArrayList<>(l));
            return;
        }
        l.add(nums[s]);
        backtrack(res,l,nums,s+1,n);
        l.remove(l.size()-1);
        backtrack(res,l,nums,s+1,n);
    }
}