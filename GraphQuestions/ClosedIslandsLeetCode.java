public class ClosedIslandsLeetCode {

    // https://leetcode.com/problems/number-of-closed-islands/

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,1,0,1,0,0,1,0},{1,1,0,1,1,0,1,1,1,0},{1,0,1,1,1,0,0,1,1,0},{0,1,1,0,0,0,0,1,0,1},{0,0,0,0,0,0,1,1,1,0},{0,1,0,1,0,1,0,1,1,1},{1,0,1,0,1,1,0,0,0,1},{1,1,1,1,1,1,0,0,0,0},{1,1,1,0,0,1,0,1,0,1},{1,1,1,0,1,1,0,1,1,0}};
        System.out.println(ClosedIslands(grid));
    }

    private static boolean flag = false;

    private static void Recursive(int[][] grid, boolean[][] Arr, int i, int j) {  
        if((i <= 0) || (j <= 0) || (i >= (grid.length - 1)) || (j >= (grid[0].length - 1)) || Arr[i][j] || (grid[i][j] != 0)){
            return;
        } if(((i == 1) && !Arr[i-1][j] && (grid[i-1][j] == 0)) || ((j == 1) && !Arr[i][j-1] && (grid[i][j-1] == 0))){
            flag = true; return;
        } if(((i == (grid.length - 2)) && !Arr[i+1][j] && (grid[i+1][j] == 0)) || ((j == (grid[0].length - 2)) && !Arr[i][j+1] && (grid[i][j+1] == 0))){
            flag = true; return;
        } Arr[i][j] = true;
        Recursive(grid, Arr, i, (j-1)); Recursive(grid, Arr, (i-1), j);
        Recursive(grid, Arr, i, (j+1)); Recursive(grid, Arr, (i+1), j);
    }

    private static int ClosedIslands(int[][] grid) {
        int count = 0;
        boolean[][] Arr = new boolean[grid.length][grid[0].length];
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if((i <= 0) || (j <= 0) || (i >= (grid.length - 1)) || (j >= (grid[0].length - 1)) || Arr[i][j] || (grid[i][j] != 0)){
                    continue;
                } else {
                    Recursive(grid, Arr, i, j);
                    if(!flag){
                        count++;
                    } flag = false;
                }
            }
        } return count;
    }
}