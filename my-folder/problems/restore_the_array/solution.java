class Solution {
    public int numberOfArrays(String s, int k) {
        Integer dp[] = new Integer[s.length()];
        return rec(s, k,0, dp);
    }
    int rec(String s, int k,int idx,Integer dp[]){
        if(s.length() == idx){
            return 1;
        }
        if(s.charAt(idx) == '0'){
            return 0;
        }
        if(dp[idx] != null){
            return dp[idx];
        }
        else{
            long count = 0;
            dp[idx] = 0;
            long a = 0;
            for(int i = idx; i< s.length(); i++){
                a = a * 10 + s.charAt(i) - '0';
                if(a == 0){
                    break;
                }
                if( a > k){
                    break;
                }
                count = (rec(s,k , i+1,dp) % 1000000007 + count % 1000000007)% 1000000007 ;
            }
            dp[idx]= (int)count ;
            return dp[idx];
        }

    }
}