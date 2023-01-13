class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int allCuts[] =new int[cuts.length+2];
        allCuts[0] = 0;
        allCuts[allCuts.length - 1] = n;
        for(int i = 1; i<cuts.length + 1; i++){
            allCuts[i] = cuts[i - 1] ; 
        }
        int dp[][] = new int[allCuts.length][allCuts.length];
        for(int i = 0; i<allCuts.length; i++){
            for(int j = 0; j<allCuts.length; j++)
                dp[i][j] = Integer.MAX_VALUE;
        }
        return minCuts(allCuts, 0, allCuts.length - 1, dp);
    }
    public int minCuts(int cuts[],int st, int end,int dp[][]){
        if(dp[st][end] != Integer.MAX_VALUE){
            return dp[st][end];
        }
        if(end-st <= 1 )
            return 0;
        for(int i = st +1; i < end ; i++){
            dp[st][end] = Math.min(
                dp[st][end],
                minCuts(cuts, st, i, dp) + minCuts(cuts, i, end, dp) + (cuts[end] - cuts[st])
            );
        }
        return  dp[st][end];  
    }
}