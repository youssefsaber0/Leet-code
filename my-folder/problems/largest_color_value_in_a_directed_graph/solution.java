class Solution {
    int max;
    int dfs(int node,String colors, Map<Integer, List<Integer>> adj, int[][] freq, boolean[]visited, boolean[] inStack){
        if(inStack[node]){
            max = Integer.MAX_VALUE;
            return Integer.MAX_VALUE;
        }
        if(visited[node]){
            return -1;
        }
        inStack[node] = true;
        visited[node] = true;
        int max = 0;
        if (adj.containsKey(node)) {
            for (int neighbor : adj.get(node)) {
                if (dfs(neighbor, colors, adj, freq, visited, inStack) == Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                for (int i = 0; i < 26; i++) {
                    freq[node][i] = Math.max(freq[node][i], freq[neighbor][i]);
                    max=Math.max(max,freq[node][i] );
                }
            }
        }
        inStack[node] = false;
        freq[node][colors.charAt(node) - 'a']++;
        max=Math.max(max, freq[node][colors.charAt(node) - 'a']);
        return max;
    }
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        boolean[] inStack = new boolean[n];
        boolean[] visited = new boolean[n];
        int[][] freq = new int[n][26];
        for(int[] edge: edges){
            adj.computeIfAbsent(edge[0], k->new ArrayList<Integer>()).add(edge[1]);
        }
        max = 0;
        for (int i = 0; i < n; i++) {
             max = Math.max(max, dfs(i, colors, adj, freq, visited, inStack));
             if(max == Integer.MAX_VALUE){
                 return -1;
             }
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}