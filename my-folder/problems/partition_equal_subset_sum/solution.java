class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for(int i = 0; i < nums.length; i++) sum += nums[i];
            boolean[][] dp=new boolean[sum/2 + 1][ nums.length + 1];
            if(sum %2 != 0){
                return false;
            }
            for(int i = 0; i <= nums.length ; i++)
                dp[0][i] = true;
            for(int i = 1; i <= sum/2; i++){
                dp[i][0] = false;
            }
            for(int i = 1; i <= sum / 2 ; i++){
                for (int j = 1; j <= nums.length; j++) {
                    dp[i][j] = dp[i][j - 1];
                    if (i >= nums[j - 1])
                            dp[i][j]
                                = dp[i][j] || dp[i - nums[j - 1]][j - 1];
                    }
            }
            return dp[sum / 2][nums.length] ;
        }
    }