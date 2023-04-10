class Solution {
    void transpose(int[][] matrix){
         for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
    void reverseRow(int[][] matrix,int row){
        int i = 0;
        int j = matrix[0].length - 1;
        while(i < j){
            int temp = matrix[row][i];
            matrix[row][i] = matrix[row][j];
            matrix[row][j] = temp;
            i++;
            j--;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
       transpose(matrix);
       for(int i = 0; i < n; i++){
           reverseRow(matrix, i);
       }

    }
}