class Solution {
        int nNeighbor(int[][] board, int row, int col){
            int neig = 0;
            if(row - 1 >= 0 ){
                if(col - 1 >=0){
                    neig += board[row - 1][col - 1];
                    
                }
                if(col + 1 < board[row].length){
                    neig += board[row - 1][col + 1];
                }
                neig += board[row -1][col];
            }
            if(row + 1 < board.length){
                if(col - 1 >=0){
                    neig += board[row + 1][col - 1];
                }
                if(col + 1 < board[row].length){
                    neig += board[row + 1][col + 1];
                } 
              neig += board[row + 1][col];
            }
            if(col - 1 >= 0){
                neig += board[row][col - 1];
            }
            if(col + 1 < board[0].length){
                neig += board[row][col + 1];
            }
            return neig;
        }
        public void game(int[][] board,int row , int col, int nNeighbors){
           if(nNeighbors < 2){
               board[row][col] = 0;
               return;
           }else if(board[row][col] == 0 && nNeighbors == 3){
               board[row][col] = 1;
               return;
           }
           else if(nNeighbors > 3){
               board[row][col] = 0;
               return;
           }
        }
        public void gameOfLife(int[][] board) {
            int m = board.length;
            int n = board[0].length;
            int[][] oldG = new int[m][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    oldG[i][j] = board[i][j];
                }
            }
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    int neig = nNeighbor(oldG, i, j);
                    game(board, i, j, neig);
                }
            }
        }
    }