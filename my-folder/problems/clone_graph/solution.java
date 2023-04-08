/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Node bfs(Node node, Map<Integer, Boolean> visited){
        Map<Integer, Node> newNodes = new HashMap<>(); 
        Node clone = new Node(node.val);
        List<Node> list = new ArrayList<>();
        list.add(node);
        int i = 0;
        while( i < list.size()){
            Node cur = list.get(i);
            i++;
            visited.put(cur.val, true);
            for(Node n : cur.neighbors){
                if(!visited.getOrDefault(n.val, false)){
                    list.add(n);
                    visited.put(n.val, true);
                }
            }
        }
        for(Node n:list){
            Node cur=newNodes.get(n.val);
            if(cur == null){
                cur = new Node(n.val);
                 newNodes.put(n.val, cur);
            }
            
            for(Node neighbor :n.neighbors ){
                if(newNodes.get(neighbor.val) == null){
                    newNodes.put(neighbor.val, new Node(neighbor.val));
                }
                cur.neighbors.add(newNodes.get(neighbor.val));
            }
        }
        return newNodes.get(node.val);
    }
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        Map<Integer, Boolean> visited = new HashMap<>();
        
        return bfs(node, visited);
    }
}