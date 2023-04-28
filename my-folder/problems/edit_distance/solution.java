class Solution {
    void fillDp(int max, int min,int[][] dp){

    }
    public int minDistance(String word1, String word2) {
        if(word1.length() < word2.length()){
            String temp = word1;
            word1 = word2;
            word2 = temp;
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 1; i <=  word1.length(); i++) dp[i][0] = i;
        for(int j = 1; j <=  word2.length(); j++) dp[0][j] = j;
        for(int i = 1; i <= word1.length(); i++){
            for(int j = 1; j <= word2.length(); j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i-1][j], dp[i][j - 1])) + 1;
                }
            } 
        }
        if(word1.length() != word1.length()){

        }
        // System.out.println(word1 + " "+word2);

        // System.out.println(Arrays.deepToString(dp));
        return dp[word1.length()][word2.length()];
    }
}