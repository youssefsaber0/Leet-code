class Solution {
    int[] runningSum(int[] nums) {

        int[] prefix =new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1;i < nums.length; i++){
            prefix[i] = prefix[i-1] + nums[i]; 
        }
        return prefix;
    }
    public int pivotIndex(int[] nums) {
       int[] prefix = runningSum(nums);
       int total = prefix[prefix.length - 1];
       for(int i = 0; i < prefix.length; i++){
           int req = total - nums[i];
           if(i == 0){
                if(req  == 0 ){
                    return 0;
                }   
           }
           else if(req % 2 == 0 && prefix[i - 1] == req /2 ){
               return i;
           }
       }
       return -1;
    }
}