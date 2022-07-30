class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.isEmpty()||haystack.equals(needle))
            return 0;
        for(int i=0; i<=haystack.length()-needle.length();i++){
            if(haystack.substring(i,needle.length()+i).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}