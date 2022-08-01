import java.util.PriorityQueue;

public class ObstaclesLeetCode{

    // https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/

    public static void main(String[] args) {
        int k = 1;
        int[][] grid = {{0,0,0,0,0,0,0,0,0,0},{0,1,1,1,1,1,1,1,1,0},{0,1,0,0,0,0,0,0,0,0},{0,1,0,1,1,1,1,1,1,1},{0,1,0,0,0,0,0,0,0,0},{0,1,1,1,1,1,1,1,1,0},{0,1,0,0,0,0,0,0,0,0},{0,1,0,1,1,1,1,1,1,1},{0,1,0,1,1,1,1,0,0,0},{0,1,0,0,0,0,0,0,1,0},{0,1,1,1,1,1,1,0,1,0},{0,0,0,0,0,0,0,0,1,0}};
        System.out.println(MinSteps(grid, k));
    }

    private static class Pair implements Comparable<Pair>{
        int i, j, k, Steps;
        Pair(int i, int j, int k, int Steps){
            this.i = i; this.j = j; this.k = k; this.Steps = Steps;
        }
        @Override
        public int compareTo(Pair o) {
            return (this.Steps - o.Steps);
        }
    }

    private static int Dijkstra(int[][] grid, int k, boolean[][][] Arr, int i, int j, int l, int m) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(i, j, k, 0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(Arr[p.i][p.j][p.k]){
                continue;
            } Arr[p.i][p.j][p.k] = true; 

            if((p.i == l) && (p.j == m)){
                return p.Steps;
            }

            addEdge(grid, k, Arr, pq, (p.i-1), p.j, p); addEdge(grid, k, Arr, pq, p.i, (p.j+1), p);
            addEdge(grid, k, Arr, pq, (p.i+1), p.j, p); addEdge(grid, k, Arr, pq, p.i, (p.j-1), p);
        } return -1;
    }

    private static void addEdge(int[][] grid, int k, boolean[][][] Arr, PriorityQueue<Pair> pq, int i, int j, Pair p) {
        if((i < 0) || (j < 0) || (i >= grid.length) || (j >= grid[0].length) || Arr[i][j][p.k]){
            return;
        } else if(grid[i][j] == 0){
            pq.add(new Pair(i, j, p.k, (p.Steps + 1)));
        } else if((grid[i][j] == 1) && (p.k > 0)){
            pq.add(new Pair(i, j, (p.k - 1), (p.Steps + 1)));
        }
    }

    private static int MinSteps(int[][] grid, int k) {
        if((grid == null) || (grid.length <= 0) || (grid.length > 40) || (grid[0][0] != 0) || (grid[grid.length - 1][grid[0].length - 1] != 0) || (k <= 0)){
            return -1;
        } boolean[][][] Arr = new boolean[grid.length][grid[0].length][k+1];
        return Dijkstra(grid, k, Arr, 0, 0, (grid.length - 1), (grid[0].length - 1));
    }
}