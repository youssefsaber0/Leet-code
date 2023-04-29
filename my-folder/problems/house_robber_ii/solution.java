class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int n = nums.length;
        Integer dp[] =new Integer[n];
        int with_last = rec(nums, 1, n-1,dp);
        dp =new Integer[n];
        int with_first = rec(nums, 0, n-2,dp);
        return Math.max(with_last, with_first);
    }
    int rec(int[] nums, int st, int i, Integer dp[]){
        if(i <st){
            return 0;
        }
        if(dp[i] != null){
            return dp[i]; 
        }
        int n = rec(nums, st,i-2,dp) + nums[i];
        int m = rec(nums, st,i-1,dp);
        dp[i] = Math.max(n, m);
        return dp[i];
    }
}