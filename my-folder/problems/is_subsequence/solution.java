class Solution {
    public boolean isSubsequence(String s, String t) {
        int sIndex = 0, tIndex = 0;
        if(s.length() > t.length()){
            return false;
        }
        for(; sIndex < s.length(); sIndex++){
            while(tIndex < t.length() &&s.charAt(sIndex) != t.charAt(tIndex)){
                tIndex++;
            }
            if(sIndex == s.length()- 1 && tIndex == t.length() - 1){
                return true;
            }
            else if( tIndex == t.length() && sIndex < s.length() ){
                return false;
            } 
            tIndex++;
        }
        return true;
    }
}