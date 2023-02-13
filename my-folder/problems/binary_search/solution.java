class Solution {
    public int search(int[] nums, int target) {
       return  search(nums, target, 0 , nums.length-1);
    }
    public int search(int[] nums, int target, int st, int end){
        int mid = (st + end)/2;
        if(st > end)
            return -1;
        else if(nums[mid] == target)
            return mid;
        else if(nums[mid] > target ){
            return search(nums, target, st , mid-1);
        }
        else 
            return search(nums, target, mid+1, end);
    }
}