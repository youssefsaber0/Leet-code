class Solution {
    public int addDigits(int num) {
        int x=num;
        int ans=0;
        while(x!=0){
            ans+=x%10;
            x/=10;
            if(x==0&&ans/10!=0){
                x=ans;
                ans=0;
            }
        }
        return ans;
    }
}