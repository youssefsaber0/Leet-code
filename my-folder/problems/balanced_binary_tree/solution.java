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
    public int calcHeight(TreeNode node,Map<TreeNode, Integer> heights){
        if(node == null){
            return -1;
        }
        else if(heights.containsKey(node)){
            return heights.get(node);
        }
        else{
            int height=Math.max(calcHeight(node.left,heights),calcHeight(node.right,heights))+1;
            heights.put(node,height);
            return height;
        }
    }
    public boolean isBalanced(TreeNode root) {
       Map<TreeNode, Integer> heights  = new HashMap<>();
       return isBalanced(root,heights);
    }
     public boolean isBalanced(TreeNode root, Map<TreeNode, Integer> heights){
        if(root==null){
            return true;
        }
         boolean c=Math.abs(calcHeight(root.left,heights)-calcHeight(root.right,heights))<2;
         return c&&isBalanced(root.right,heights)&&isBalanced(root.left,heights);
     }
}