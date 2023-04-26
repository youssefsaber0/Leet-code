class Solution {
    public int lengthOfLIS(int[] nums) 
    {int n = nums.length;
        int []tail = new int[n];
        tail[0] = nums[0];
        int len=1;
        for(int i = 1; i<n;i++){
            if(nums[i] < tail[0]){
                tail[0] = nums[i];
            }
            else if(tail[len - 1] < nums[i]){
                tail[len] = nums[i]; 
                len++;
            }
            else{
                int ceil = ceilIndex(tail,-1,len - 1,nums[i]);
                tail[ceil] = nums[i];
            }
        }
        return len;
    }
    int ceilIndex(int tail[], int l, int r, int key)
    {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (tail[m] >= key)
                r = m;
            else
                l = m;
        }
 
        return r;
    }
}