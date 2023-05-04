class Solution {
    int dp[] = new int[38];
    public int tribonacci(int n) {
        if(n < 3 ) return n > 0 ? 1 : 0;
        else if(dp[n] != 0) return dp[n];
        else{
            dp[n] = tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
            return dp[n];
        }
    }
}