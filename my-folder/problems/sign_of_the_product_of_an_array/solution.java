class Solution {
    public int arraySign(int[] nums) {
        int ans = 1;
        for(int n:nums){
            if(n == 0){
                ans = 0;
                break;
            }
            else if(n < 0){
                ans = ans *-1;
            }
        }
    return ans;
    }
}