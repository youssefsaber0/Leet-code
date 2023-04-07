class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 1;
        for(int i = 0; i < m; i++){
            if(grid[i][0] == 1 && !visited[i][0]){

                 dfs(grid, visited,i,0);
            }
            if(grid[i][n-1] == 1 && !visited[i][n-1]){

                 dfs(grid, visited,i,n-1);
                
            }
        }
        for(int i = 0; i < n; i++){
            if(grid[0][i] == 1 && !visited[0][i]){
                 dfs(grid, visited,0,i);
            }
            if(grid[m-1][i] == 1 && !visited[m-1][i]){
                 dfs(grid, visited,m-1,i);
            }
        }
        ans = 0;
        for(int i=0; i<m; i++){
            for(int j = 0 ; j<n; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                        ans++;
                }
            }
        }
        return ans;
    }
    void dfs(int[][] grid, boolean[][] visited,int i, int j){
        visited[i][j] = true;
        if(i+1 < grid.length && grid[i+1][j] ==1 &&!visited[i+1][j]  ){
             dfs(grid,visited ,i+1, j);
        }
        if(j+1 < grid[0].length && grid[i][j+1] ==1 &&!visited[i][j+1]  ){
             dfs(grid,visited, i, j+1);
        }
        if(i-1 >= 0 && grid[i-1][j] ==1 &&!visited[i-1][j]  ){
            dfs(grid,visited, i-1, j);
        }
        if(j-1 >= 0 && grid[i][j-1] ==1 &&!visited[i][j-1]  ){
            dfs(grid,visited, i, j-1);
        }
    }
}