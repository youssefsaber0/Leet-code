class Solution {
    public int rob(int[] nums) {
       Integer dp[] = new Integer[nums.length];
       return rec(nums, nums.length - 1 ,dp); 
    }
    int rec(int[] nums, int i, Integer dp[]){
        if(i <0){
            return 0;
        }
        if(dp[i] != null){
            return dp[i]; 
        }
        int n = rec(nums, i-2,dp) + nums[i];
        int m = rec(nums, i-1,dp);
        dp[i] = Math.max(n, m);
        return dp[i];
    }
}