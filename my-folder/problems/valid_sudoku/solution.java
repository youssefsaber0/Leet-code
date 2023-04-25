class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] col =new int[9][9];
        int[][] row =new int[9][9];
        int[][] box =new int[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                row[i][board[i][j] - '1']++;
                if(row[i][board[i][j] - '1'] > 1){
                    return false;
                }
                col[j][board[i][j] - '1']++;
                if(col[j][board[i][j] - '1'] > 1){
                    return false;
                }
                int boxN = (i / 3) * 3 + j / 3;
                box[boxN][board[i][j] - '1']++;
                if(box[boxN][board[i][j] - '1'] > 1){
                    return false;
                }
            }
        }
        return true;
    }
}