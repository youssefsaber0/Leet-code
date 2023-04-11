class Solution {
    int findMin(int[] nums, int left, int right){
        if(left == right)
            return nums[left];
        int mid = (left + right) /2;
        if(nums[mid] > nums[right]){
            return findMin(nums, mid + 1, right);
        }
        else{
            return findMin(nums, left, mid);
        }
    
    }
    public int findMin(int[] nums) {
        return findMin(nums,0 , nums.length-1);
    }
}