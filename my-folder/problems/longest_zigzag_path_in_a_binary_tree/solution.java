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
    int max = 0;
     void longestZigZagR(TreeNode root, Boolean isLeft,int maxWay){
        if(root == null ){
                   

        return;}
        max = Math.max(maxWay, max);

        if( (root.left == null && root.right == null))
            return;
        if(isLeft == null){
            longestZigZagR(root.left, true, maxWay + 1);
            longestZigZagR(root.right, false, maxWay + 1);
        }
        else if(isLeft){
            longestZigZagR(root.left, true, 1);
            longestZigZagR(root.right, false, maxWay+1);
        }
        else{
            longestZigZagR(root.left, true, maxWay+1);
            longestZigZagR(root.right, false, 1);
        }
     }
    public int longestZigZag(TreeNode root) {
        longestZigZagR(root, null, 0);
        return max;
    }
}