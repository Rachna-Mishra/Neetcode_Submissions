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
    public int maxDepth(TreeNode root) {
        return findMaxDepth(root, 0);
    }
    public int findMaxDepth(TreeNode root, int l){
        if(root == null){
            return 0;
        }
        return Math.max(findMaxDepth(root.left, l)+1, 
                findMaxDepth(root.right, l)+1);
    }
}
