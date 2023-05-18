class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] array = new int[n];
        for(List<Integer> edge:edges){
            array[edge.get(1)]++;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n;i++){
            if(array[i] == 0){
                ans.add(i);
            }
        }
        return ans;
    }
}