class Solution {
    public int maxArea(int[] height) {
        int st = 0, end = height.length - 1, ans = 0 , current=0;
        while(st < end){
            if(height[st] < height[end]){
                current = (end - st) * height[st] ;
                st++;
            }
            else{
                current = (end - st) *  height[end];
                end--; 
            }
            ans = Math.max(current, ans);
        }
        return ans;
    }
}