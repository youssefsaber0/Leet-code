class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int j=1;
        for(int i=1;i<n;i++){
            if(nums[i-1]!=nums[i]){
                nums[j++]=nums[i];
            }
        }
        // if(nums[j-1]!=nums[n]){
        //     System.out.println(j);
        //     nums[j++]=nums[n];
        // }
        return j;
    }
}