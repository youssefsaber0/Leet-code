class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // int[] array = new int[2 * 100000 + 1];
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();   
        for(int i = 0; i< nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        for(int i = 0; i < nums.length; i++){
            if((i > 0 && nums[i - 1] ==nums[i])){
                continue;
            }
            if( nums[i] > 0){
                break;
            }
            freq.put(nums[i], freq.get(nums[i]) - 1);
            for(int j = nums.length - 1; j > i; j--){
                int target = 0 - nums[i] - nums[j];
                // System.out.println(freq);
                //                                 System.out.println( nums[i]);
                //                 System.out.println( nums[j]);

                //                 System.out.println(target > nums[j]);
                //                 System.out.println(nums[i] <target);

                if( (j < nums.length - 1 && nums[j] == nums[j+1])||target > nums[j]||nums[i] > target){
                    continue;
                }
                if((nums[i] <0 && nums[j] < 0) || (nums[i] > 0 && nums[j] > 0)){
                    break;
                }
                freq.put(nums[j], freq.get(nums[j]) - 1);
                if(freq.getOrDefault(target, 0) != 0){
                    ans.add(Arrays.asList(nums[i], target, nums[j]));
                }
                freq.put(nums[j], freq.get(nums[j]) + 1);
            }
        }
        return ans;
    }
}