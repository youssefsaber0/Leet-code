class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>[] arr = new ArrayList[target + 1];
        for(int c:candidates){
            if(c <= target){
            List<Integer> list = new ArrayList<>();
            arr[c] = new ArrayList<>();
            list.add(c);
            arr[c].add(list);
            }
        }
        for(int i = 1; i < target+1; i++){
            if(arr[i]==null)
                arr[i] = new ArrayList();
            for(int c:candidates ){
                if(c >= i){
                    break;
                }
                else if( arr[i-c] != null){
        
                    List<List<Integer>> list = arr[i-c];
                    for(List<Integer> l :list){
                        List<Integer> newL = new ArrayList<>(l);
                        newL.add(c);
                        arr[i].add(newL);
                    }
                }
            }
        }
        List<List<Integer>> list = arr[target];
        Set<String> hash_Set = new HashSet<String>();
         List<List<Integer>> ans = new ArrayList<>();
         StringBuilder sb = new StringBuilder();
        for(List<Integer> l:list){
            sb.setLength(0);
            Collections.sort(l);
            for(Integer i: l){
                sb.append("1"+ i);
            }
            if(! hash_Set.contains(sb.toString())){
                ans.add(l);
                hash_Set.add(sb.toString());
            }
        }
        return ans;
    }
}