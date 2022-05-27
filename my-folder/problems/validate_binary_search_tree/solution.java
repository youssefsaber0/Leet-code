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
    public boolean isValidBST(TreeNode root) {
        List<Integer> temp = new ArrayList<>();
        preOrder(temp, root);
        for(int i = 1; i < temp.size(); i++){
            if(temp.get(i) <= temp.get(i - 1)){
                return false;
            }
        }
        return true;
    }

    public void preOrder(List<Integer> list, TreeNode root){
        if(root == null){
            return;
        }
        preOrder(list, root.left);
        list.add(root.val);
        preOrder(list, root.right);
    }

}