class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] dir = {{0, -1},{0, +1},{+1, 0},{-1, 0}};
        int curInd = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(curInd)){
                    System.out.print(board[i][j]+" ");
                    char temp = board[i][j];
                    board[i][j] = '#';
                    if(dfs(board, word, i, j, curInd+1, dir)){
                        return true;
                    }
                    board[i][j] = temp;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int r, int c, int curInd, int[][] dir){
        if(curInd == word.length()){
            return true;
        }
        for(int i = 0; i< dir.length; i++){
            int nextRow = r + dir[i][0];
            int nextCol = c + dir[i][1];
            System.out.print(nextRow+" "+nextCol+" ");
            if((nextRow >= 0 && nextRow < board.length) &&
                (nextCol >= 0 && nextCol < board[0].length)
                 && board[nextRow][nextCol] == word.charAt(curInd)){
                    System.out.print(board[nextRow][nextCol]+" ");
                    char temp = board[nextRow][nextCol];
                    board[nextRow][nextCol] = '#';
                    if(dfs(board, word, nextRow, nextCol, curInd+1, dir)){
                        return true;
                    }
                    board[nextRow][nextCol] =temp;
            }
        }
        return false;
    }
}
