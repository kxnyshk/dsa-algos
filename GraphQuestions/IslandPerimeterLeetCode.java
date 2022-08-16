import java.util.ArrayDeque;

public class IslandPerimeterLeetCode {

    // https://leetcode.com/problems/island-perimeter/
    
    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(IslandPerimeter(grid));

    }

    private static class Pair{
        int i, j;
        Pair(int i, int j){
            this.i = i; this.j = j;
        }
    }

    private static int IslandPerimeter(int[][] grid) {
        boolean[][] Arr = new boolean[grid.length][grid[0].length];
        ArrayDeque<Pair> q = new ArrayDeque<>();

        boolean flag = false;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    q.add(new Pair(i, j)); flag = true; break;
                }
            } if(flag){break;}
        } return dfs(grid, Arr, q);
    }

    private static int dfs(int[][] grid, boolean[][] Arr, ArrayDeque<Pair> q) {
        int[][] XY = {{0,-1},{-1,0},{0,1},{1,0}};
        int count = 0;

        while(!q.isEmpty()){
            Pair p = q.poll();
            if(Arr[p.i][p.j]){
                continue;
            } Arr[p.i][p.j] = true;

            int tempCount = 4;
            for(int k=0; k<XY.length; k++){
                int x = (p.i + XY[k][0]), y = (p.j + XY[k][1]);
                if(valid(grid, x, y)){
                    if(!Arr[x][y]){
                        q.add(new Pair(x, y));
                    } tempCount--; 
                }
            } count += tempCount;
        } return count;
    }

    private static boolean valid(int[][] grid, int i, int j) {
        if((i < 0) || (j < 0) || (i >= grid.length) || (j >= grid[0].length) || (grid[i][j] != 1)){
            return false;
        } return true;
    }
}