class Solution {
    public void rotate(int[] nums, int k) {
        int m = k % nums.length;
        int[] rotated = new int[ m + 1];
                     System.out.println("m "+m);
        int loop = Math.max(nums.length- m,m);
        for(int i = 0; i <loop ; i++){
            if(i < m){
                System.out.println("i "+i);
                rotated[i] = nums[nums.length - i - 1];
            }
            // System.out.println(nums.length-i - m -1);
            //  System.out.println("i"+i);
            if(i < nums.length- m )
            nums[ nums.length - i - 1] = nums[nums.length-i - m -1];  
        }
        for(int i = 0; i < m; i++){
            System.out.println(rotated[i]);
            nums[m  - 1 - i] = rotated[i];  
        }
    }   
}