class Solution {
    public int[][] generateMatrix(int n) {
        int ans[][]= new int[n][n];
        int state = 0;
        int minRow = 0;
        int maxCol = n-1;
        int minCol = 0;
        int maxRow = n-1;
        int i=0,j=0;
        int count=1;
        int max =  n*n;
        while(count <=max){
            ans[i][j]=count++;
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