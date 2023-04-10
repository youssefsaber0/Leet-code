class Solution {
    public int missingNumber(int[] nums) {
   int numLength = nums.length;
    int actualSum = numLength * (numLength +1)/2;
    
    for(var num : nums) {
        actualSum = actualSum - num;
    }
    return actualSum;
    }
}