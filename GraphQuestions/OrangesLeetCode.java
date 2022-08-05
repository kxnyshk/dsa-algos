import java.util.ArrayDeque;

public class OrangesLeetCode {

    // https://leetcode.com/problems/rotting-oranges/
    
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(bfs(grid));
    }

    private static class Pair{
        int i, j, distance;
        Pair(int i, int j, int distance){
            this.i = i;
            this.j = j;
            this.distance = distance;
        }
    }

    private static int bfs(int[][] grid) {
        boolean[][] Arr = new boolean[grid.length][grid[0].length];
        ArrayDeque<Pair> pq = new ArrayDeque<>();
        int freshOranges = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    pq.add(new Pair(i, j, 0));
                } else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        } int max = 0; int counter = 0;

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if((Arr[p.i][p.j]) || (grid[p.i][p.j] == 0)){
                continue;
            } Arr[p.i][p.j] = true;

            if(grid[p.i][p.j] == 1){
                counter++;
            } max = Math.max(max, p.distance);

            QueueAdd(grid, Arr, pq, p.i, (p.j - 1), p); QueueAdd(grid, Arr, pq, (p.i - 1), p.j, p);
            QueueAdd(grid, Arr, pq, p.i, (p.j + 1), p); QueueAdd(grid, Arr, pq, (p.i + 1), p.j, p);
        } return (counter == freshOranges) ? max : -1;
    }

    private static void QueueAdd(int[][] grid, boolean[][] Arr, ArrayDeque<Pair> pq, int i, int j,
    Pair p) {
        if((i < 0) || (j < 0) || (i >= grid.length) || (j >= grid[0].length) || Arr[i][j] || (grid[i][j] != 1)){
            return;
        } pq.add(new Pair(i, j, (p.distance + 1)));
    }
}