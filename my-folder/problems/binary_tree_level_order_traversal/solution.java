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
    public List<List<Integer>> levelOrder(TreeNode root) {
         Queue<TreeNode> q= new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        q.add(root);
        q.add(null);
        int i=0;
        while(!q.isEmpty()){
            TreeNode cur=q.remove();
            if(cur==null&&q.peek()==null){
                break;
            }
            if(i==ans.size()){
                ans.add(new ArrayList<>());
            }
            if(cur==null){
                q.add(null);
                i++;
            }
            else{
                if(cur.left!=null&&cur.right!=null){
                    q.add(cur.left);
                    q.add(cur.right);
                }
                else if(cur.left!=null){
                    q.add(cur.left);
                }
                else if(cur.right!=null){
                    q.add(cur.right);
                }
                ans.get(i).add(cur.val);

            }
        }
        return ans;
    }
}