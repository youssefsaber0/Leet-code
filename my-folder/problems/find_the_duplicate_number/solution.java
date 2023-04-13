class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> freq = new HashSet<>();
        for(int i : nums){
            if(freq.contains(i)){
                return i;
            }
            else{
                freq.add(i);
            }
        }
        return -1;
    }
}