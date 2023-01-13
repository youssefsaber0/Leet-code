class Solution {
public int coinChange(int[] coins, int val) {
      int [] dp=new int [val+1];
	    Arrays.fill(dp,Integer.MAX_VALUE);
	    dp[0]=0;
	    
	    for(int i =1;i<dp.length;i++){
	        for(int j =0;j<coins.length;j++){
	            if(coins[j]<=i){
	                int subres=dp[i-coins[j]];
	                
	                if(subres!=Integer.MAX_VALUE){
	                    dp[i]=Math.min(subres+1,dp[i]);//current value of dp[i] and subresult
	                }
	            }
	        }
	    }
	    
	    if(dp[val]==Integer.MAX_VALUE){
	        return -1;
	    }
	    return dp[val];
  }
}