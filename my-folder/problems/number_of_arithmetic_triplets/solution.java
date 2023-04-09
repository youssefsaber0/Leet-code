class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
       Set<Integer> hs = new HashSet();
       for(int j:nums){
        hs.add(j);
       }
       int ans = 0;
        for(int j:nums){
            if(hs.contains(-(diff - j))&& hs.contains(diff + j)){
                ans++;
            }
        }
        return ans;
    }
}