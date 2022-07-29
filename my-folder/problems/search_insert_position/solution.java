class Solution {
    public int searchInsert(int[] nums, int target) {
        int end=nums.length-1,start=0;
        int mid=(start+end)/2;
        while(start<=end){
            System.out.println(mid);
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<target)
                    start=mid+1;
            else
                end=mid-1;
            mid=(start+end)/2;
        }
        if(target>nums[mid]){
            return mid+1;
        }
        return mid;
    }
}