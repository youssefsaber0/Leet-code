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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> post = new ArrayList<>();
        postorderTraversal(root,post);
        return post;
    }
    public void postorderTraversal(TreeNode root,ArrayList<Integer> travers) {
        if(root==null){
            return;
        }
        postorderTraversal(root.left,travers);
        postorderTraversal(root.right,travers);
        travers.add(root.val);
    }
    
}