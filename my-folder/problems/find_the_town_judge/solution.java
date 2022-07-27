class Solution {
   public int findJudge(int n, int[][] trust) {
        if(trust.length == 0 && n == 1) return 1;
        int[] trustCount = new int[n+1];
        for(int[] trus : trust){
            trustCount[trus[1]]++;
            trustCount[trus[0]]--;
        }
        for(int i=0;i<trustCount.length;i++){
            if(trustCount[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}