class Solution {
    public ArrayList<ArrayList<Integer>> prepareGraph(int n,int edges[][]){
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        return adjList;
    }
    public boolean bfs(ArrayList<ArrayList<Integer>> adjList,int source,int destination,boolean[] visited){
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[source]=true;
        queue.add(source);
        while(queue.size()!=0){
            int current=queue.poll();
            for(Integer i:adjList.get(current)){
                if(i==destination){
                    return true;
                }
                if(!visited[i]){
                    visited[i]=true;
                    queue.add(i);
                }
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination){
            return true;
        }
        ArrayList<ArrayList<Integer>> adjList=prepareGraph(n,edges);
        boolean visited[]=new boolean[n];
        return bfs(adjList,source,destination,visited);
    }
}