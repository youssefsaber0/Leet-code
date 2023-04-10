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
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        TreeNode cur = q.remove();
        while(!(cur == null && q.peek() == null)){
            if(cur==null){
                q.add(null);
                cur = q.remove();
                continue;
            }
            if(q.peek() == null){
                ans.add(cur.val);
            }
            if(cur.left != null){
                q.add(cur.left);
            }
            if(cur.right != null){
                q.add(cur.right);
            }
            cur = q.remove();
        }
        // System.out.println(cur.val);
        return ans;
    }
}