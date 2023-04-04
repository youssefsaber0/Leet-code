class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return helper(matrix,target);
    }
    boolean helper(int[][] matrix,int target){
        int row = 0;
        int col = matrix[0].length - 1;
        // binary search approach on matrix
        // increase row & decrease column respectively
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target) return true;
            if(matrix[row][col] < target){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }
}