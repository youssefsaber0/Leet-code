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
    void inOrder(TreeNode root, ArrayList<Integer> inorder,int k){
        if(root == null) return;
        inOrder(root.left, inorder, k);
        inorder.add(root.val);
        if(inorder.size() == k)
            return;
        inOrder(root.right, inorder, k);

    } 
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> inorder = new ArrayList<>();
        inOrder(root, inorder,k);
        return inorder.get(k - 1);
    }
}