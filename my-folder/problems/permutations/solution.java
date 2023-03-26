class Solution {
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    HashSet<Integer> allIn = new HashSet<>();
    backtrack(list, new ArrayList<>(), nums, allIn);
    return list;
}

private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, HashSet<Integer> allIn){
    if(tempList.size() == nums.length){
        list.add(new ArrayList<>(tempList));
        return;
    }
    for(int i = 0; i < nums.length; i++){
        if(!allIn.contains(nums[i])){
            tempList.add(nums[i]); 
            allIn.add(nums[i]);
            backtrack(list, tempList, nums, allIn);
            tempList.remove(tempList.size() - 1);
            allIn.remove(nums[i]);
        }

    }
}
}