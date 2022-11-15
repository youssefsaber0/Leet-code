class Solution {
//     function intialize memorized array
    public int min_Cost(List<Integer> cuts, int i, int j, int mem[][]){
        if(j-i <=1){
            return 0;
        }
        else if(mem[i][j]!=Integer.MAX_VALUE){
            return mem[i][j];
        }
        else{
            for(int k=i+1; k<j; k++){
                mem[i][j]=Math.min(mem[i][j],min_Cost(cuts,i,k,mem)+min_Cost(cuts,k,j,mem)+cuts.get(j)-cuts.get(i));
            }
        }
        return mem[i][j];
    }
    public int minCost(int n, int[] cuts) {
        List<Integer> list=Arrays.stream(cuts)
      .boxed()
      .collect(Collectors.toList());
        list.add(0);
        list.add(n);
        Collections.sort(list);
        int mim[][]=new int[list.size()][list.size()];
        for (int i=0; i<(mim.length); i++ ) {
            for (int j=0;j<mim[i].length;j++){
                mim[i][j]=Integer.MAX_VALUE;
            }
        }
        return min_Cost(list, 0, list.size()-1, mim);
    }
}