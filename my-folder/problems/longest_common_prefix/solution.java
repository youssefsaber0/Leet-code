class Solution {
    String commonTwoString(String str1,String str2){
        StringBuilder strB= new StringBuilder();
        if(str1.length()>str2.length()){
            return commonTwoString(str2, str1);
        }
        int i=0;
        for( i=0;i <str1.length();i++){
            if(str1.charAt(i)==str2.charAt(i)){
                strB.append(str2.charAt(i));
            }
            else{
                break;
            }
        }
        return str1.substring(0, i);
    }
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int length = strs.length; 
        return commonTwoString(strs[0],strs[length-1]);
    }
}