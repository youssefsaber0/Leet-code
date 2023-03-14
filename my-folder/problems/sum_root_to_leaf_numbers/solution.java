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
     public int sumNumbers(TreeNode root, Integer cur,int sum){
        if(root.left == null && root.right == null ){
            sum = sum + cur;
            return sum;
        }
        if(root.left != null){
            sum = sumNumbers(root.left, cur * 10 + root.left.val, sum);
        }
        if(root.right != null){
            sum = sumNumbers(root.right, cur * 10 + root.right.val, sum);
        }
        return sum;
     }
    public int sumNumbers(TreeNode root) {
        int sum = sumNumbers(root, root.val, 0);
        return sum;
    }
}