import java.util.Arrays;

public class ColorBorderLeetCode {

    // https://leetcode.com/problems/coloring-a-border/

    public static void main(String[] args) {
        int[][] grid = {{1,2,2},{2,1,2},{1,2,3},{3,2,1}};
        int row = 1, col = 1, color = 3;
        System.out.println(Arrays.deepToString(ColorBorder(grid, row, col, color)));
    }
    
    private static int[][] XY = {{0,-1}, {-1,0}, {0, 1}, {1, 0}};
    
    private static int[][] ColorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] Arr = new boolean[grid.length][grid[0].length];
        int[][] Adj = new int[grid.length][grid[0].length];
        int og = grid[row][col];

        dfs(grid, row, col, og, Adj, Arr);
        int count = 0;
        
        for(int  i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if((Adj[i][j] != 0) && (Adj[i][j] != 4)){
                    grid[i][j] = color; count++;
                }
            }
        } if(count == 0){
            grid[row][col] = color;
        } return grid;
    }

    private static void dfs(int[][] grid, int row, int col, int og, int[][] Adj, boolean[][] Arr) {
        Arr[row][col] = true;
        int count = 4;

        for(int i=0; i<XY.length; i++){
            int x = (row + XY[i][0]), y = (col + XY[i][1]);
            if((x < 0) || (y < 0) || (x >= grid.length) || (y >= grid[0].length) || (grid[x][y] != og)){
                count--;
            } else{
                if(!Arr[x][y]){
                    dfs(grid, x, y, og, Adj, Arr);
                }
            }
        } Adj[row][col] = count;
    }
}