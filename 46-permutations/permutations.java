class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean [] b = new boolean[nums.length];
        backtrack(nums,new ArrayList<>(),b,res);
        return res;
    }
    private void backtrack(int[] nums,List<Integer> lst,boolean[] b,List<List<Integer>> res){
        if(lst.size()== nums.length){
            res.add(new ArrayList<>(lst));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(!b[i]){
                b[i] = true;
                lst.add(nums[i]);
                backtrack(nums,lst,b,res);
                lst.remove(lst.size()-1);
                b[i] = false;
            }
        }
    }
}