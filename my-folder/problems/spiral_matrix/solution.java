class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
       int n = matrix.length,m = matrix[0].length;
        int state = 0;
        int minRow = 0;
        int maxCol = matrix[0].length-1;
        int minCol = 0;
        int maxRow = matrix.length-1;
        int i=0,j=0;
        List<Integer> ans =new ArrayList<>();
        while(ans.size() != n * m){
            ans.add(matrix[i][j]);
            if(state == 0){
                j++;
                if(j > maxCol){
                    j--;
                    i++;
                    state = 1;
                    minRow++;
                }
            }
            else if(state == 1){
                i++;
                if(i > maxRow){
                    i--;
                    j--;
                    maxCol--;;
                    state = 2;
                }
            }
            else if(state == 2){
                j--;
                if(j < minCol){
                    j++;
                    i--;
                    maxRow--;;
                    state = 3;
                } 
            }
            else if(state == 3){
                i--;
                if(i < minRow){
                    i++;
                    j++;
                                        minCol++;;
                    state = 0;
                } 
            }
            
        }
        return ans;
    }
}