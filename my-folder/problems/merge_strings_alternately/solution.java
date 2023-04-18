class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int k = 0, j=0, i=0;
        while(i < word1.length() && j < word2.length()){

            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
            i++;
            j++;
                
        }
        if(i < word1.length()){
            while(i < word1.length()){

                sb.append(word1.charAt(i));
                i++;
                    
            }
        }
        else if(j < word2.length()){
            while(j < word2.length()){

                sb.append(word2.charAt(j));
                j++;
                    
            } 
        }
        return sb.toString();
    }
}