class Solution {
    boolean isVowel(char c){
        return c == 'a' || c == 'e'|| c == 'i'|| c == 'o'|| c == 'u';
    }
    public int maxVowels(String s, int k) {
        int max = 0;
        int cur = 0;
        
        for(int i = 0; i < k;i++){
            if(isVowel(s.charAt(i))){
                cur++;
            }
        }
        max = Math.max(max, cur);
        int i = 0;
        while(i + k < s.length()){
            if(isVowel(s.charAt(i))){
                cur--;
            }
            if(isVowel(s.charAt(i + k))){
                cur++;
            }
            max = Math.max(max, cur);
            i++;

        }
        return max;
    }
}