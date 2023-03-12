class Solution {
    boolean isVowelChar(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
    boolean isVowel(String word){
        return isVowelChar(word.charAt(0))&&
        isVowelChar(word.charAt(word.length()-1));
    }
    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        for(int i=left; i <= right;i++){
            if(isVowel(words[i]))
                ans++;
        }
        return ans;
    }
}