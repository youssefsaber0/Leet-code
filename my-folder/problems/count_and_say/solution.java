class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String countAndSayBefore = countAndSay(n - 1);
        String curCount = countAndSay(countAndSayBefore);
        System.out.println(curCount);
        return curCount;
    }
    String countAndSay(String str){
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            int j = 1;
            while(i + j < n){
                if(str.charAt(i) == str.charAt(i+j)){
                    j++;
                }
                else{
                    break;
                }
            }
   
            sb.append(j);
            sb.append(str.charAt(i));
            i = i+j -1 ;
        }
        return sb.toString();
    }
}