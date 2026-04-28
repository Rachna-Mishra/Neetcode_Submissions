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
    int d;
    public int diameterOfBinaryTree(TreeNode root) {
        d = 0;
        findDiameter(root);
        return d;
    }
    public int findDiameter(TreeNode root) {
        if(root == null){
            return 0;
        }
        int lh = findDiameter(root.left);
        int rh = findDiameter(root.right);
        if(lh + rh > d)
            d = lh + rh;
        return 1 + Math.max(lh, rh);
    }
}
