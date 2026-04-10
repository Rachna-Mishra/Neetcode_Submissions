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
    TreeNode mainRoot;
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        mainRoot = root;
        dfs(root, target, 0, null);
        return mainRoot;
    }
    public void dfs(TreeNode root, int target, int dir, TreeNode par){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
          //  System.out.println(root.val+" " +dir);
            if(root.val == target){
                if(par == null){
                    return;
                }
                if(dir == 1){
                    par.right = null;
                }else{
                    par.left = null;
                }
            }
            return;
        }
        dfs(root.left, target, -1, root);
        dfs(root.right, target, +1, root);
        if(par == null && root.val == target){
            mainRoot = null;
        }
        if(root != null && root.left == null && root.right == null)
            dfs(root, target, dir, par);
    }
}