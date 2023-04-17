class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        List<Boolean> ans =new ArrayList<>();
        int max = candies[0];
        for(int i = 1;i < n; i++){
            max = Math.max(candies[i], max);
        }
        for(int i = 0;i < n; i++){
            if(candies[i] + extraCandies >= max){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }
        return ans;
    }
}