class Solution {
    private long numWays(String[] words, String target, int j, int i, Long[][] mem, int[][] freq){
        if(j == 0){
            return i == 0 ? 1 : 0;
        }
        else if(mem[i][j] != null){
            return mem[i][j];
        }
        mem[i][j] = numWays(words, target, j - 1, i,mem, freq);
        if( i>0 &&freq[target.charAt(i - 1) - 'a'][j - 1] > 0)
            mem[i][j] += freq[target.charAt(i - 1) - 'a'][j - 1] *  numWays(words, target, j - 1, i - 1,mem, freq);
        mem[i][j] %= 1000000007;
        return mem[i][j];
    }
    public int numWays(String[] words, String target) {
        Long[][] mem = new Long[target.length() + 1][words[0].length() + 1];
        int[][] freq = new int[26][words[0].length()];
        for(int i =0; i < words[0].length(); i++){
            for(String word:words){
                freq[word.charAt(i) - 'a'][i]++;
            }
        }
       return (int)numWays(words, target, words[0].length(), target.length(), mem, freq);
    }

}