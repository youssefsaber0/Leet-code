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
    public void binaryTreePaths(TreeNode root, StringBuilder sb, List<String> roots){
        if(root.left == null && root.right == null){
            roots.add(sb.toString());
            return;
        }
        else{
            if(root.left != null){
                sb.append("->");
                sb.append(root.left.val);
                binaryTreePaths(root.left, sb, roots);
                int index = sb.lastIndexOf("->");
                String str=  sb.substring(0, index);
                sb.setLength(0);
                sb.append(str);
            }
            if(root.right != null){
                sb.append("->");
                sb.append(root.right.val);
                binaryTreePaths(root.right, sb, roots);
                int index = sb.lastIndexOf("->");
                String str=  sb.substring(0, index);
                sb.setLength(0);
                sb.append(str);
            } 
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list=  new ArrayList<>();
       StringBuilder strB= new StringBuilder();
        strB.append(root.val);
        binaryTreePaths(root, strB,list);
        return list;
    }
}