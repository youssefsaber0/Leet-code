class Solution {
    public int[] productExceptSelf(int[] nums) {
        int mult = 1;
        int postionOfZero = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                postionOfZero = postionOfZero|1<<i;
                continue;
            }
            mult *= nums[i];
        }
        int []ans=new int[nums.length];
        for(int  i = 0; i< nums.length; i++){
            if(postionOfZero == 0){
                ans[i] = mult / nums[i]; 
            }
            else{
                if((postionOfZero & ~(1 << i)) == 0)
                    ans[i] = mult;
                else{
                    ans[i]=0;
                }
            }
        }
        return ans;
    }
}