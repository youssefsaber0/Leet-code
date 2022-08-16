/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        ArrayList<Integer> post=new ArrayList<>();
        postorder(root,post);
        return post;
    }
    public void postorder(Node root,ArrayList<Integer> post){
        if(root==null){
            return;
        }
        for(Node i:root.children){
            postorder(i,post);
        }
        post.add(root.val);
    }
}