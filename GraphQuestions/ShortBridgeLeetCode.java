import java.util.ArrayDeque;

public class ShortBridgeLeetCode {

    // https://leetcode.com/problems/shortest-bridge/
    
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
        System.out.println(ShortestBridge(grid));
    }

    private static class Pair{
        int i, j, flips;
        Pair(int i, int j, int flips){
            this.i = i;
            this.j = j;
            this.flips = flips;
        }
    }

    private static int bfs(int[][] grid, boolean[][] Arr, ArrayDeque<Pair> q) {
        int[] X = {0, -1, 0, 1}, Y = {-1, 0, 1, 0};
        
        while(!q.isEmpty()){
            Pair p = q.poll();

            for(int k=0; k<X.length; k++){
                int x = (p.i + X[k]), y = (p.j + Y[k]);
                if((x >= 0) && (y >= 0) && (x < grid.length) && (y < grid[0].length) && !Arr[x][y]){
                    if(grid[x][y] == 1){
                        return p.flips;
                    } q.add(new Pair(x, y, (p.flips + 1))); Arr[x][y] = true;
                }
            }
        } return -1;
    }

    private static int ShortestBridge(int[][] grid) {
        boolean[][] Arr = new boolean[grid.length][grid[0].length];
        ArrayDeque<Pair> q = new ArrayDeque<>();
        boolean flag = false;

        for(int i=0; i<grid.length && !flag; i++){
            for(int j=0; j<grid[0].length && !flag; j++){
                if(grid[i][j] == 1){
                    dfs(grid, Arr, q, i, j); flag = true;
                }
            }
        } return bfs(grid, Arr, q);
    }

    private static void dfs(int[][] grid, boolean[][] Arr, ArrayDeque<Pair> q, int i, int j) {
        if((i < 0) || (j < 0) || (i >= grid.length) || (j >= grid[0].length) || Arr[i][j] || (grid[i][j] != 1)){
            return;
        } Arr[i][j] = true; q.add(new Pair(i, j, 0));
        dfs(grid, Arr, q, (i - 1), j); dfs(grid, Arr, q, i, (j - 1));
        dfs(grid, Arr, q, (i + 1), j); dfs(grid, Arr, q, i, (j + 1));
    }
}