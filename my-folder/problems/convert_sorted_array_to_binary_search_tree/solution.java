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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root=null;
        root=sortedArrayToBST(nums,root,0,nums.length-1);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums,TreeNode root, int start,int end){
        int mid=(start+end)/2;
        if(root==null){
            
            root=new TreeNode(nums[mid]);
            sortedArrayToBST(nums,root,mid+1,end);
            sortedArrayToBST(nums,root,start,mid-1);
            return root;
        }
        if(start>end){
            return root;
        }
        if(nums[mid]>root.val){
            root.right=new TreeNode(nums[mid]);
            sortedArrayToBST(nums,root.right,mid+1,end);
            sortedArrayToBST(nums,root.right,start,mid-1);
            return root;
        }
        else{
            root.left=new TreeNode(nums[mid]);
            
            sortedArrayToBST(nums,root.left,mid+1,end);
            sortedArrayToBST(nums,root.left,start,mid-1);
            
            return root;
        }
    }
}