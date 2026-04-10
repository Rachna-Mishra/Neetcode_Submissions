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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null){
            return order;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            while(n-- > 0){
                TreeNode k = queue.remove();
                if(n == 0){
                    order.add(k.val);
                }
                if(k.left != null){
                    queue.add(k.left);
                }
                if(k.right != null){
                    queue.add(k.right);
                }
            }
        }
        return order;
    }
}
