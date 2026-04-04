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

public class Codec {

    String data;
    TreeNode head;
    int cur;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        data = "";
        dfs(root);
        // System.out.println(data);
        return data;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        cur = -1;
        String[] dataSet = data.split(" ");
        decodeString(head, 0, dataSet);
        return head;
    }

    public void decodeString(TreeNode p, int dir, String[] data){
       // System.out.println("cur"+data.length+" "+cur);
        cur++;
        if(cur == data.length || data[cur].equals("N")){
            return;
        }
        if(dir == 0){
            head = new TreeNode(Integer.valueOf(data[cur]));
            p = head;
        }
        TreeNode n = new TreeNode(Integer.parseInt(data[cur]));
        if(dir == -1){
            p.left = n;  
            p = p.left;
        }
        if(dir == 1) {
            p.right = n;
            p = p.right;
        }
        decodeString(p, -1, data);
        decodeString(p, 1, data);
        }

    void dfs(TreeNode root){
        if(root == null){
            data = data + "N"+" ";
            return;
        }
        data = data+root.val+" ";
        dfs(root.left);
        dfs(root.right);
    }
}
