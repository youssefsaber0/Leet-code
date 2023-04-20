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
    class Pair{
        TreeNode node;
        long index;
        public Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        long left = Long.MAX_VALUE,right= Long.MIN_VALUE,max = 0;
        Pair st = new Pair(root,1);
        q.add(st);
        q.add(null);
        while(true){
            Pair cur = q.remove();
            if(cur == null && q.peek() == null){
                max = Math.max(max,(int) (right - left + 1));
                break;
            }
            else if(cur == null){
                max = Math.max(max,(int) (right - left + 1));
                left = Long.MAX_VALUE;
                right= Long.MIN_VALUE;
                q.add(null);
            }
            else{
                if(left == Long.MAX_VALUE){
                    left = cur.index;
                }
                right = cur.index;
                if(cur.node.left != null ){
                    Pair p = new Pair(cur.node.left, 2 * cur.index - 1);
                    q.add(p);
                }
                if(cur.node.right != null){
                    Pair p = new Pair(cur.node.right, 2 * cur.index );
                    q.add(p);
                }
            }
        }
        return (int)max;
    }
}