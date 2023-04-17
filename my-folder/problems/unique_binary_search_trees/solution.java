class Solution {
    public int numTrees(int n) {
        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[0] = 1;
        for(int i = 2; i <= n; i++){
            int max = i/2 +1;
            if(i % 2 == 0){
                max = i/2;
            }
            for(int j = 1; j <= max; j++){
                int right = i - j;
                int left = j - 1; 
                if(right == left){
                    dp[i] += dp[right] * dp[left] ;
                }
                else dp[i] += dp[right] * dp[left] * 2;
            }
        }
        return dp[n];
    }
}