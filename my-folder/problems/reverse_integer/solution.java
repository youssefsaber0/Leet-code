class Solution {
    public int reverse(int x) {
        String s=String.valueOf(x);
                StringBuilder str = new StringBuilder(s);
        int i=0;
        int j=s.length()-1;
        if(s.charAt(i)=='-'){
            i++;
        }
        while(i<j){
            char temp=str.charAt(i);
            str.setCharAt(i,str.charAt(j));
            str.setCharAt(j,temp);
            i++;
            j--;
        }
    long number = Long.parseLong(str.toString());
    if((number>Integer.MAX_VALUE)||(number<Integer.MIN_VALUE)){
        return 0;
    }
        return (int)number;
    }
}