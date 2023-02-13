class Solution {
    public int searchInsert(int[] nums, int target) {
       return  search(nums, target, 0 , nums.length-1);
    }
    public int search(int[] nums, int target, int st, int end){
        int mid = (st + end)/2;
        if((st == end || st > end) && nums[mid] != target ){
            if(target > nums[st])
                return st +1;
            else 
                return st;
        }
        else if(nums[mid] == target)
            return mid;
        else if(nums[mid] > target ){
            System.out.println(st);
                        System.out.println(mid-1);

            return search(nums, target, st , mid-1);
        }
        else 
            return search(nums, target, mid+1, end);
    }
}