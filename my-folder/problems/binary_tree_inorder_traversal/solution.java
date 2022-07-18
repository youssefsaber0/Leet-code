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
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer>ans=new ArrayList<>();
        inorderTraversal(root,ans);
        return ans;
    }
    private void inorderTraversal(TreeNode root,List<Integer> val){
        if(root==null){
            return;
        }
        inorderTraversal(root.left,val);
        val.add(root.val);
        inorderTraversal(root.right,val);  
    }
}