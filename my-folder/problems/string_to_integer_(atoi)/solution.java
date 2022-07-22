class Solution {
    public int myAtoi(String s) {
    int i=0;
        boolean flag=false;
    if(s.length()==0)
        return 0;
    while(i<s.length()&&s.charAt(i)==' '){
        i++;
    }
        if(i<s.length()&&(s.charAt(i)=='-'||s.charAt(i)=='+')){
           if(s.charAt(i)=='-') flag=true;
            i++;
        }
        int j=0;
        long ans=0;
    while(i<s.length()&&s.charAt(i)>=48&&s.charAt(i)<=57){
        ans=ans*10+(s.charAt(i)-48);
        if(ans>0)
            j++;
        i++;
        if(j>10){
            break;
        }
    }
    if(flag){
        ans=ans*-1;
    }
     if(ans>Integer.MAX_VALUE){
                         System.out.println(ans);

         return Integer.MAX_VALUE;
         
     }
    if(ans<Integer.MIN_VALUE){
                  return Integer.MIN_VALUE;

     }
    return (int)ans;
    }
}