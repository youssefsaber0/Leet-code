class Solution {
    int[] credit =new int[]{1,7,30};
    public int mincostTickets(int[] days, int[] costs) {
        Integer dp[] = new Integer[days.length];
        return mincostTickets(days, costs , 0,dp);
    }
    private int mincostTickets(int[] days,int[] costs, int curDay,Integer dp[]){
        if(curDay >= days.length){
            return 0;
        }
        if(dp[curDay] != null){
            return dp[curDay];
        }
        int ans = Integer.MAX_VALUE;int lastPaid = curDay;
        for(int i =0; i<3; i++){
            
            while(lastPaid < days.length && days[curDay] + credit[i] > days[lastPaid])lastPaid++;
            ans = Math.min(ans, mincostTickets(days, costs, lastPaid, dp) + costs[i]);
        }
        dp[curDay] = ans;
        return ans;
    }
}