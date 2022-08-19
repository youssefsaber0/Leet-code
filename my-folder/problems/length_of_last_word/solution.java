class Solution {
    public String[] splitString(String s){
        String[] words=s.split(" ");
         words = Arrays.stream(words).filter(word -> word.length() > 0).toArray(String[]::new);
        return words;      
    }
    public int lengthOfLastWord(String s) {
        String[] words= splitString(s);
      return  words[words.length-1].length();
         
    }
}