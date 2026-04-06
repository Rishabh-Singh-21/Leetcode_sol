class Solution {
    public static boolean issafe(char board[][],int row,int col){
        for(int i=row-1;i>=0;i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0&&j<board.length;i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true; 
    }
    public static void nqueens(char board[][],int row,List<List<String>> allBoards){
        if(row == board.length){
            List<String> newBoard = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                newBoard.add(new String(board[i]));
            }
            allBoards.add(newBoard);
            return;
        }
        for(int j =0;j<board.length;j++){
            if(issafe(board,row,j)){
                board[row][j] = 'Q';
                nqueens(board,row+1,allBoards);
                board[row][j] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char [][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i],'.');
        }
        nqueens(board,0,allBoards);
        return allBoards;
    }
}