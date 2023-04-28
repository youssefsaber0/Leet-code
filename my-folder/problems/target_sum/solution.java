class Solution {
    int totalSum;
    public int findTargetSumWays(int[] nums, int target) {
        totalSum = Arrays.stream(nums).sum();
        Integer dp[][] = new Integer[nums.length][2 * totalSum + 1];
        return findTargetSumWays(nums, target, 0, 0,dp);
    }
    int findTargetSumWays(int[] nums,int target, int idx, int curSum,Integer[][] dp){
        if(idx == nums.length){
            if(curSum == target){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[idx][totalSum - curSum] != null){
            return dp[idx][totalSum - curSum];
        }
        dp[idx][totalSum - curSum] = findTargetSumWays(nums, target, idx + 1, curSum + nums[idx],dp) + findTargetSumWays(nums, target, idx + 1, curSum - nums[idx],dp);
        return dp[idx][totalSum - curSum];
    }
}