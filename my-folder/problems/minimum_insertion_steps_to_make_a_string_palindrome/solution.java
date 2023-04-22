class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        String  s1 = s.substring(0,n / 2);
        String s2 = s.substring(n/2 );
        Integer dp[][] = new Integer[s.length() +1][s.length()+1];
        dp[0][0] = 0;
        for(int i = 1;i < s.length() + 1;i++ ) {
            dp[i][0] = 0;
        }
        for(int i = 1;i < s.length() + 1;i++ ) {
            dp[0][i] = 0;
        }
        for(int i = 1; i <= s.length();i++){
            for(int j = 1; j <= s.length() ;j++){
                // System.out.print("( "+s.charAt(s.length() - i) + ", "+ s.charAt(j - 1)+"), ");
                if(s.charAt(s.length() - i) == s.charAt(j - 1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j - 1]);
                }

            } 
            // System.out.println(" ");
            }           
            //  System.out.println(" ");

        //     for(int i = 0; i <= s.length();i++){
        //     for(int j = 0; j <= s.length() ;j++){
        //         System.out.print("( "+dp[i][j]+"), ");

        //     }
        //     System.out.println(" ");
        // }
        return n  - dp[s.length() ][s.length()];
   }
     int minInsertions(String s1,String s2, int i, int j, Integer[][] dp){
        if(dp[i][j] != null){
            return dp[i][j];
        }
        else{
            if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                dp[i][j] = minInsertions(s1,s2, i - 1, j - 1,dp);;
            }
            else{
                dp[i][j ] = Math.min(minInsertions(s1,s2, i - 1, j,dp) + 1 , minInsertions(s1,s2, i , j- 1,dp) +1);
            }
        }
        return dp[i][j];
    }

}