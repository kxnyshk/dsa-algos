public class EnclavesLeetCode {

    // https://leetcode.com/problems/number-of-enclaves/
    
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,1,1,0,1,1,1,0,1},{1,1,1,1,0,1,0,1,1,0,0},{0,1,0,1,1,0,0,0,0,1,0},{1,0,1,1,1,1,1,0,0,0,1},{0,0,1,0,1,1,0,0,1,0,0},{1,0,0,1,1,1,0,0,0,1,1},{0,1,0,1,1,0,0,0,1,0,0},{0,1,1,0,1,0,1,1,1,0,0},{1,1,0,1,1,1,0,0,0,0,0},{1,0,1,1,0,0,0,1,0,0,1}};
        System.out.println(NumOfEnclaves(grid));
    }

    private static boolean flag = false;
    private static int counter = 0;

    private static void Recursive(int[][] grid, boolean[][] Arr, int i, int j) {
        if((i < 0) || (j < 0) || (i >= grid.length) || (j >= grid[0].length) || Arr[i][j] || (grid[i][j] != 1)){
            return;
        } if(((i == 0) || (i == (grid.length - 1))) && !Arr[i][j] && (grid[i][j] == 1)){
            flag = true; return;
        } if(((j == 0) || (j == (grid[0].length - 1))) && !Arr[i][j] && (grid[i][j] == 1)){
            flag = true; return;
        } Arr[i][j] = true; counter++;
        Recursive(grid, Arr, i, (j-1)); Recursive(grid, Arr, (i-1), j);
        Recursive(grid, Arr, i, (j+1)); Recursive(grid, Arr, (i+1), j);
    }

    private static int NumOfEnclaves(int[][] grid) {
        int count = 0; boolean[][] Arr = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if((!Arr[i][j]) && (grid[i][j] == 1)){
                    Recursive(grid, Arr, i, j);
                    if(!flag){
                        count += counter;
                    } flag = false; counter = 0;
                }
            }
        } return count;
    }
}