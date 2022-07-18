class Solution {
    public int longestPalindrome(String s) {
              char charArray[] = s.toCharArray();
        boolean flag=false;
        if(charArray.length==1){
            return 1;
        }
        int ans=0;
      Arrays.sort(charArray);
        for(int i=0;i<charArray.length;i++){
            if(i==charArray.length-1){
                if(flag==false){
                    ans++;
                  
                }  break;
            }
            if(charArray[i]==charArray[i+1]){
                ans+=2;
                i++;
            }
            else{
                if(flag!=true){
                    ans++;
                }
                flag=true;
            }
        }
        return ans;
    }
   
}