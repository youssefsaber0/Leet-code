class Solution {
    public long findTheArrayConcVal(int[] nums) {
        return findTheArrayConcVal( nums , 0, nums.length-1, 0);
    }
    public long findTheArrayConcVal(int[] nums, int st, int end,long ans){
        if(st == end){
            return ans + nums[st];
        }
        else if(st == end-1){
            return ans + Integer.parseInt
            (
                Integer.toString(nums[st]) + 
                Integer.toString(nums[end])
            );
        }
        else
            return findTheArrayConcVal(nums, st + 1 , end - 1, ans + Integer.parseInt
            (
                Integer.toString(nums[st]) + 
                Integer.toString(nums[end])
            ) );
    }
}