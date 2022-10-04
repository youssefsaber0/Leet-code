class Solution {
    public List<List<Integer>> setGraph(int numCourses,int array[][]){
        List< List<Integer>> adjList=new ArrayList<>();
        
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0;i<array.length;i++){
            adjList.get(array[i][1]).add(array[i][0]);
        }
        return adjList;
    }
    private boolean isCyclicUtil(List< List<Integer>> adj,int i, boolean[] visited
                                  ,boolean[] recStack)
    {
         
        if (recStack[i])
            return true;
 
        if (visited[i])
            return false;
             
        visited[i] = true;
 
        recStack[i] = true;
        List<Integer> children = adj.get(i);
         
        for (Integer c: children)
            if (isCyclicUtil(adj, c, visited, recStack))
                return true;
                 
        recStack[i] = false;
 
        return false;
    }
       private boolean isCyclic(List< List<Integer>> adj){
        boolean[] visited = new boolean[adj.size()];
        boolean[] recStack = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++)
            if (isCyclicUtil(adj , i, visited, recStack))
                return true;
 
        return false;
    }
    public void toplogicalSort(List< List<Integer>> adj,int i, boolean[] visited,Stack<Integer> sortedStack){
        visited[i] = true;
        List<Integer> children = adj.get(i);
        for(int index=0;index<children.size();index++){
            if(!visited[children.get(index)]){
                toplogicalSort(adj,children.get(index),visited,sortedStack);
            }
        }
        sortedStack.push(i);
    }
       int[] topologicalSort(List< List<Integer>> adj)
    {
        int V =adj.size(); 
        Stack<Integer> stack = new Stack<Integer>();
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
 
        for (int i = 0; i < V; i++)
            if (!visited[i] )
                toplogicalSort(adj,i, visited, stack);
        int[] order = new int[V];
           int i=0;
        while (!stack.empty()){
            
            order[i++] = stack.pop();
        }
           return order;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List< List<Integer>> adjList = setGraph(numCourses, prerequisites);
        if(isCyclic(adjList)){
            return new int[0];
        }

        return topologicalSort(adjList);
    }
}