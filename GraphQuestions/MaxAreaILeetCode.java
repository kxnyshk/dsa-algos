public class MaxAreaILeetCode {

    // https://leetcode.com/problems/max-area-of-island/
    
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(MaxArea(grid));
    }

    private static int Recursive(int[][] grid, boolean[][] Arr, int i, int j) {
        if((i < 0) || (j < 0) || (i >= grid.length) || (j >= grid[0].length) || Arr[i][j] || (grid[i][j] != 1)){
            return count;
        } Arr[i][j] = true; count++;
        
        Recursive(grid, Arr, i, (j-1)); Recursive(grid, Arr, (i-1), j);
        Recursive(grid, Arr, i, (j+1)); Recursive(grid, Arr, (i+1), j);
        return count;
    }

    private static int count;

    private static int MaxArea(int[][] grid) {
        int maxArea = 0;
        boolean[][] Arr = new boolean[grid.length][grid[0].length];
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                count = 0; Recursive(grid, Arr, i, j);
                maxArea = Math.max(maxArea, count);
            }
        } return maxArea;
    }
}