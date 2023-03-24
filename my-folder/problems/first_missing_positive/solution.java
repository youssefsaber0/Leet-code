class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0;i < nums.length; i++){
            if(nums[i] <= 0 || nums[i] > nums.length){
                continue;
            }
            else{
                if(nums[i] != nums[nums[i] - 1 ]){                    
                    swap(nums, i, nums[i]-1);
                    i--;
                }
            }
        }
        int i;
        for(i = 0;i < nums.length && i+1 == nums[i]; i++);
        return i+1;
    }
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}