public class NumOfIslands {

    // https://leetcode.com/problems/number-of-islands/
    // https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1
    // LeetCode/Gfg solution -> class Solution {..}
    
    class Solution {
    
        boolean[][] Arr;
        int Count = 0;
        
        public int numIslands(char[][] grid) {
            Arr = new boolean[grid.length][grid[0].length];
            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[0].length; j++){
                    if((!Arr[i][j]) && (grid[i][j] == '1')){
                        dfs(grid, i, j); Count++;
                    }
                }
            } return Count++;
        }
        
        void dfs(char[][] grid, int r, int c){
            if((r < 0) || (c < 0) || (r >= grid.length) || (c >= grid[0].length) || (grid[r][c] != '1') || (Arr[r][c])){
                return;
            } Arr[r][c] = true;
            dfs(grid, (r-1), c); dfs(grid, r, (c-1));
            dfs(grid, (r+1), c); dfs(grid, r, (c+1));
        }
    }
}