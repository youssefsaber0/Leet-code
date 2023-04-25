class Solution {

    private int[] rowGuard;
    private int[] columnGuard;
    private int[] squareGuard;
    char[][] boar;
    //[] - row, [] - column
    public void solveSudoku(char[][] board) {
        rowGuard = new int[9];
        columnGuard = new int[9];
        squareGuard = new int[9];boar=board;
        intialGuard(board);
    
        solve(board);
    }
    boolean solve(char[][] board){
        int count = 0;
        int rowS = -1;
        int colS = -1;
        int min = 100;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9;j++){
                if(board[i][j] == '.'){
                    int avilablePosition = numberOfPosition(i,j);
                    if(avilablePosition==0){
                        return false;
                    }
                    if(avilablePosition < min){
                        min = avilablePosition;
                        rowS = i;
                        colS = j;
                    }
                    count++;
                }
            }
        }
        if(count==0){
            return false;
        }

        for(int i = 0; i< 9;i++){
        int locked = lockedPosition(rowS,colS);

            if((locked &(1<<i)) != 0){
                continue;
           }
            board[rowS][colS] = (char) (i + '1');
            if(count == 1)
                return true;
            lockValue(rowS,colS,(char) (i + '1'));
            if(solve(board))
                return true;
            unLock(rowS,colS,(char) (i + '1'));
            board[rowS][colS] = '.';
    }
    return false;
    }
    void intialGuard(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    lockValue(i,j,board[i][j]);
                }
            }   
        }
    }
    void lockValue(int i,int j,char c){
        lockRow(i,j,c);
        lockCol(j,c);
        lockSquare(i,j,c);
    }
    void lockRow(int row,int t,char c){
        rowGuard[row] |= (1 << (c - '1'));
    }
    void lockCol(int col,char c){
        columnGuard[col] |= (1<<(c - '1'));
    }
    void lockSquare(int row, int col, char c){
        int sq = getSquare(row, col);
        squareGuard[sq] |= 1 << ( c - '1');
    }
    int getSquare(int row,int col){
        return row / 3 * 3 + col / 3; 
    }
    void unLock(int row, int col, char c){
        unlockRow(row, c);
        unlockColumn(col, c);
        unlockSquare(row,col, c);
    }
    void unlockRow(int row, char c){
        rowGuard[row] &= ~(1 << (c - '1'));

    }
    void unlockColumn(int col, char c){
        columnGuard[col] &= ~(1<<(c - '1'));
    }
    void unlockSquare(int row, int col, char c){
        int sq = getSquare(row, col);
        squareGuard[sq] &= ~(1 << ( c - '1'));
    }
    int lockedPosition(int row, int col){
        int sq = getSquare(row, col);
        return rowGuard[row] | columnGuard[col] | squareGuard[sq];
    }
    int numberOfPosition(int row,int col) {
        int guards = lockedPosition(row,col);
        int count =0;
        for(int i = 0; i < 9; i++){
            count += (~(guards >> i) & 1);
        }
        return count;
    }
}