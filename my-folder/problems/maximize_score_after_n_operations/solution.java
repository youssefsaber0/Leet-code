class Solution {
    int memoSize;
    public int maxScore(int[] nums) {
        memoSize = 1 << nums.length;
        Integer[] memo = new Integer[memoSize];
        return backTrack(nums, 0, 0, memo);
    }
    private int backTrack(int[] nums, int picked, int bitMask, Integer[] memo){
        if(picked *2 == nums.length){
            return 0;
        }
        else if(memo[bitMask] != null){
            return memo[bitMask];
        } 
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if (((bitMask >> i) & 1) == 1 || ((bitMask >> j) & 1) == 1) {
                    continue;
                }               
                int newMask = bitMask | 1 << i|  1 << j;
                int cur = (picked + 1) * gcd(nums[i], nums[j]);
                int r = backTrack(nums, picked + 1, newMask, memo);
                max = Math.max(max, r + cur);
            }
        }
        memo[bitMask] = max;
        return max;
    }
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}