class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,new ArrayList(),nums,0,nums.length);
        return res;
    }
    private static void backtrack(List<List<Integer>> res,List<Integer> l, int nums[],int s,int n){
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