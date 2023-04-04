class Solution {
    public int partitionString(String s) {
      int ans = 0, partition = 0, i=0;
      while(i < s.length()){
        int val = s.charAt(i) -'a';
        if((partition & 1<< val) != 0){
          ans++;
          partition  = 0;
        }
        partition = partition | 1<< val;
        i++; 
      }
      return ans + 1;
    }
}