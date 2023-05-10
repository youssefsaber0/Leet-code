class Solution {
    public int uniquePaths(int m, int n) {
        Integer dp[][] =new Integer[m][n];
        return uniquePaths(m, n, 0,0, dp);
    }
    private int uniquePaths(int m, int n, int i, int j, Integer[][] dp){
        if(i == m-1 && j == n-1){
            return 1;
        }
        else if(i >= m || j >= n){
            return 0;
        }
        else if (dp[i][j]!= null){
            return dp[i][j];
        }
        else{
            dp[i][j] = uniquePaths(m, n, i + 1, j, dp) + uniquePaths(m, n, i , j+ 1, dp);
            return dp[i][j];
        }
    }
}