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
import java.util.Hashtable;

class Solution {
        Hashtable<TreeNode, Integer> ht1 = new Hashtable<>();
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        if(Math.abs(getHeight(root.right)-getHeight(root.left))>1){
            return false;
        }
        
        return true&&isBalanced(root.right)&&isBalanced(root.left);
    }
    public int getHeight(TreeNode root){
        if(root==null){
            return -1;
        }
        if(ht1.containsKey(root)){
            return ht1.get(root);
        }
        else{
            int ans =Math.max(getHeight(root.right),getHeight(root.left))+1;
            ht1.put(root,ans);
            return ans;
        }
    }
    
     
}