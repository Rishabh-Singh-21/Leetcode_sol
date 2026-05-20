/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<String> arr = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root,"");
        return arr;
    }
    public void dfs(TreeNode root,String path){
        if(root == null) return;
        path = path + root.val;
        if(root.left == null && root.right == null) {
            arr.add(path);
            return;
        } 
        path = path + "->";
        dfs(root.left,path);
        dfs(root.right,path);
    }
}