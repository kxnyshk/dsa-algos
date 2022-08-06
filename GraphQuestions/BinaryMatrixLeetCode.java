import java.util.PriorityQueue;

public class BinaryMatrixLeetCode {

    // https://leetcode.com/problems/shortest-path-in-binary-matrix/
    
    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(ShortestPath(grid));
    }

    private static class Pair implements Comparable<Pair>{
        int i, j, distance;
        Pair(int i, int j, int distance){
            this.i = i;
            this.j = j;
            this.distance = distance;
        }
        @Override
        public int compareTo(Pair o) {
            return (this.distance - o.distance);
        }
    }

    private static int ShortestPath(int[][] grid) {
        boolean[][] Arr = new boolean[grid.length][grid[0].length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, 1));
        
        int path = -1;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if((Arr[p.i][p.j]) || (grid[p.i][p.j] != 0)){
                continue;
            } Arr[p.i][p.j] = true;

            if((p.i == (grid.length - 1)) && (p.j == (grid[0].length - 1))){
                path = p.distance; break;
            }

            Queueadd(grid, Arr, pq, p, (p.i - 1), (p.j - 1)); Queueadd(grid, Arr, pq, p, (p.i - 1), p.j);
            Queueadd(grid, Arr, pq, p, (p.i - 1), (p.j + 1)); Queueadd(grid, Arr, pq, p, p.i, (p.j - 1));
            Queueadd(grid, Arr, pq, p, (p.i + 1), (p.j - 1)); Queueadd(grid, Arr, pq, p, p.i, (p.j + 1));
            Queueadd(grid, Arr, pq, p, (p.i + 1), (p.j + 1)); Queueadd(grid, Arr, pq, p, (p.i + 1), p.j);
        } return path;
        
    }

    private static void Queueadd(int[][] grid, boolean[][] Arr, PriorityQueue<Pair> pq, Pair p, int i, int j) {
        if((i <  0) || (j < 0) || (i >= grid.length) || (j >= grid[0].length) || Arr[i][j] || (grid[i][j] != 0)){
            return;
        } pq.add(new Pair(i, j, (p.distance + 1)));
    }
}