public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        boolean neg = false;
        if(n < 0){
            neg = true;
            n = ~n;
        }
        int ans = 0;
        while(n != 0){
            n = n & (n-1);
            ans++;
        }
        return neg ? 32 - ans:ans;
    }
}