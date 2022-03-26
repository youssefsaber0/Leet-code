import java.util.ArrayList;

class Solution {
   public int subarraySum(int[] nums, int k) {
    Map<Integer,Integer> prefix = new HashMap<>();
    prefix.put(0,1);
    int sum=0;
    int ans =0;
    for(int i=0;i<nums.length;i++){
        sum +=nums[i];
        if(prefix.containsKey(sum - k)){
            ans+=prefix.get(sum-k);
        }
        if(prefix.containsKey(sum)){
            prefix.put(sum, prefix.get(sum) + 1);            
        }
        else {
                prefix.put(sum,1);
        }
    }
    return ans;
}
        
    
}