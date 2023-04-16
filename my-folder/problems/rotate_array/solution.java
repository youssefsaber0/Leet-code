class Solution {
    public void rotate(int[] nums, int k) {
        int m = k % nums.length;
        int[] rotated = new int[ m + 1];
        int loop = Math.max(nums.length- m,m);
        for(int i = 0; i <loop ; i++){
            if(i < m){
                rotated[i] = nums[nums.length - i - 1];
            }
            if(i < nums.length- m )
            nums[ nums.length - i - 1] = nums[nums.length-i - m -1];  
        }
        for(int i = 0; i < m; i++){
            nums[m  - 1 - i] = rotated[i];  
        }
    }   
}