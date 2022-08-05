import java.util.ArrayDeque;

public class FarLandLeetCode {

    // https://leetcode.com/problems/as-far-from-land-as-possible/

    public static void main(String[] args) {
        int[][] grid = {{1,0,1},{0,0,0},{1,0,1}};
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

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    pq.add(new Pair(i, j, 0));
                }
            }
        } int max = Integer.MIN_VALUE;

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(Arr[p.i][p.j]){
                continue;
            } Arr[p.i][p.j] = true;

            max = Math.max(max, p.distance);
            QueueAdd(grid, Arr, pq, p.i, (p.j - 1), p); QueueAdd(grid, Arr, pq, (p.i - 1), p.j, p);
            QueueAdd(grid, Arr, pq, p.i, (p.j + 1), p); QueueAdd(grid, Arr, pq, (p.i + 1), p.j, p);
        } return (max <= 0) ? -1 : max;
    }

    private static void QueueAdd(int[][] grid, boolean[][] Arr, ArrayDeque<Pair> pq, int i, int j,
    Pair p) {
        if((i < 0) || (j < 0) || (i >= grid.length) || (j >= grid[0].length) || Arr[i][j] || (grid[i][j] != 0)){
            return;
        } pq.add(new Pair(i, j, (p.distance + 1)));
    }
}