public class BattleshipsLeetCode {

    // https://leetcode.com/problems/battleships-in-a-board/
    
    public static void main(String[] args) {
        char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        System.out.println(CountBattleShips(board));
    }

    private static int CountBattleShips(char[][] board) {
        int count = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 'X'){
                    dfs(board, i, j); count++;
                }
            }
        } return count;
    }

    private static int[][] XY = {{0,-1},{-1,0},{0,1},{1,0}};

    private static void dfs(char[][] board, int i, int j) {
        if((i < 0) || (j < 0) || (i >= board.length) || (j >= board[0].length) || (board[i][j] != 'X')){
            return;
        } board[i][j] = '-';

        for(int k=0; k<XY.length; k++){
            int x = (i + XY[k][0]), y = (j + XY[k][1]);
            dfs(board, x, y);
        }
    }
}