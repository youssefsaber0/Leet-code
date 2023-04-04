class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = searchRow(matrix,  target, 0, matrix.length - 1);
        if(row < 0 )
            return false;
        int col = searchCol(matrix,  target, row, 0, matrix[0].length - 1);
        if(col < 0 )
            return false;
        return matrix[row][col] == target;
    }
     public int searchRow(int[][] matrix, int target ,int start ,int end){
        if(start > end ){
            return end;
        }
        int mid = (start+end) / 2;
        if(target == matrix[mid][0] )
            return mid;
        if(target > matrix[mid][0]){
          return  searchRow(matrix, target , mid + 1  , end);
        }
        else{
            return  searchRow(matrix, target , start , mid - 1 );
        }
    }
         public int searchCol(int[][] matrix, int target,int row ,int start ,int end){
        if(start >= end ){
            return start;
        }
        int mid = (start+end) / 2;
        if(target == matrix[row][mid] )
            return mid;
        if(target > matrix[row][mid]){
          return  searchCol(matrix, target, row , mid + 1  , end);
        }
        else{
            return  searchCol(matrix, target, row , start , mid - 1 );
        }
    }
}