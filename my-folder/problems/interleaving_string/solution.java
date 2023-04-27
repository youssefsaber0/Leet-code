class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if((s1.length() +s2.length()) != s3.length())
            return false;
        Boolean[][] dp = new Boolean[s1.length() +1][s2.length()+1];
        dp[s1.length() ][s2.length() ] = true;
        return topDown(s1,s2,s3,0,0,0,dp);
    }
    boolean topDown(String s1,String s2,String s3,int i1,int i2,int i3,Boolean [][]dp){
        if(dp[i1][i2] != null){
            return dp[i1][i2];
        }
        if(i1 == s1.length()){
            if(s2.charAt(i2) != s3.charAt(i3)){
                dp[i1][i2] = false;
                return false;
            }
            dp[i1][i2] = topDown(s1,s2,s3,i1,i2 + 1 , i3 + 1,dp);
            return dp[i1][i2];
        }
        if(i2 == s2.length()){
            if(s1.charAt(i1) != s3.charAt(i3)){
                dp[i1][i2] = false;
                return false;
            }
            dp[i1][i2] = topDown(s1,s2,s3,i1+ 1,i2, i3 + 1,dp);
            return dp[i1][i2];
        }
        if(s1.charAt(i1)==s3.charAt(i3) && s2.charAt(i2)==s3.charAt(i3)){
            dp[i1][i2] = topDown(s1,s2,s3,i1 + 1,i2,i3 + 1,dp)||topDown(s1,s2,s3,i1 ,i2+ 1,i3+1,dp);
        }
        else if(s1.charAt(i1)==s3.charAt(i3)){
            dp[i1][i2] = topDown(s1,s2,s3,i1 + 1,i2,i3 + 1,dp);
        }
        else if(s2.charAt(i2)==s3.charAt(i3)){
            dp[i1][i2] = topDown(s1,s2,s3,i1 ,i2+ 1,i3 + 1,dp);
        }
        else{
            dp[i1][i2] = false;
        }
        return dp[i1][i2];
    }
}