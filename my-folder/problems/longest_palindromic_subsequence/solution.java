class Solution {
    public int longestPalindromeSubseq(String s) {
        return longestPalindromeSubseq(s, 0, s.length()-1, new Integer[s.length()][s.length()]);
    }
    int longestPalindromeSubseq(String s,int i, int j, Integer[][] mem){
        if(mem[i][j] != null){
            return mem[i][j];
        }
        if(i == j)
            return 1;
        if(i > j){
            return 0;
        }
        if(s.charAt(i) == s.charAt(j)){
            mem[i][j] = 2 + longestPalindromeSubseq(s, i + 1, j - 1, mem);
            return mem[i][j];
        }
        else{
            mem[i][j] = Math.max(longestPalindromeSubseq(s, i, j - 1, mem), longestPalindromeSubseq(s, i + 1, j, mem));
            return mem[i][j];
        }
    }
}