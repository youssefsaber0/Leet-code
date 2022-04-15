class Solution {
    int firstEven(int start,int []nums){
        for(int i=start;i<nums.length;i++){
            if(nums[i]%2==0){
                return i;
            }
        }
         
            return start;
    }
    int firstOdd(int start,int nums[]){
        for(int i=start;i<nums.length;i++){
            if(nums[i]%2==1){
                return i;
            }
        }
                 
            return start;
    }
    void swap(int[]nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public int[] sortArrayByParityII(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                if(nums[i]%2==0){
                    continue;
                }
               int temp =firstEven(i,nums);
                swap(nums,i,temp);
                continue;
            }
            if(nums[i]%2==1){
                    continue;
                }
               int temp =firstOdd(i,nums);
                swap(nums,i,temp);
        }
        return nums;
    }
}