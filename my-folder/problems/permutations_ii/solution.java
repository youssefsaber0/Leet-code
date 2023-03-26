class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> allIn = new HashMap<>();
        for(int i=0; i < nums.length; i++){
            allIn.put(nums[i], allIn.getOrDefault(nums[i], 0)+1);
        }
        backtrack(list, new ArrayList<>(), nums, allIn);
        return list;
    }

    private void backtrack(List<List<Integer>> list ,           List<Integer> tempList, int [] nums, Map<Integer, Integer> allIn ){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
            return;
        }
        for(Integer i : allIn.keySet()){
            int count = allIn.get(i);
            if(count != 0){
                tempList.add(i); 
                allIn.put(i, count - 1);
                backtrack(list, tempList, nums, allIn);
                tempList.remove(tempList.size() - 1);
                allIn.put(i, count);
            }

        }
    }

}