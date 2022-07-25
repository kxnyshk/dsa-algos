import java.util.PriorityQueue;

public class RisingWaterLeetCode {

    // https://leetcode.com/problems/swim-in-rising-water/
    // PASS 19/43 TCS. REFER <risingwaterleetcode1.java> FOR CORRECT SOLUTION
    
    public static void main(String[] args) {
        // int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        // int[][] grid = {{0,2},{1,3}};
        // int[][] grid = {{10,12,4,6},{9,11,3,5},{1,7,13,8},{2,0,15,14}};
        int[][] grid = {{9,5,7,2},{0,10,8,15},{1,4,3,12},{6,13,11,14}};
        System.out.println(LeastTime(grid));
    }

    private static class Pair implements Comparable<Pair>{
        int i, j, Level;
        Pair(int i, int j, int Level){
            this.i = i; this.j = j; this.Level = Level;
        }
        @Override
        public int compareTo(Pair o) {
            return (this.Level - o.Level);
        }
    }

    private static Pair dst;

    private static int Dijkstra(int[][] grid, boolean[][] Arr, int i, int j, int k, int l) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int maxTime = Integer.MIN_VALUE; pq.add(new Pair(i, j, grid[i][j]));

        while(!pq.isEmpty()){
            if(pq.contains(dst)){
                System.out.println(true);
                maxTime = Math.max(maxTime, dst.Level); break;
            }
            
            Pair P = pq.poll();
            if(Arr[P.i][P.j]){
                continue;
            } Arr[P.i][P.j] = true; pq.clear();
            
            maxTime = Math.max(maxTime, P.Level);
            System.out.println("\nNodePol: " + grid[P.i][P.j]);
            if((P.i == k) && (P.j == l)){
                break;
            }

            addEdge(grid, Arr, pq, P.i, P.j, (P.i-1), P.j, P); addEdge(grid, Arr, pq, P.i, P.j, P.i, (P.j+1), P);
            addEdge(grid, Arr, pq, P.i, P.j, (P.i+1), P.j, P); addEdge(grid, Arr, pq, P.i, P.j, P.i, (P.j-1), P);
        } return maxTime;
    }

    private static void addEdge(int[][] grid, boolean[][] Arr, PriorityQueue<Pair> pq, int prevI, int prevJ, int i, int j, Pair P) {
        if((i < 0) || (j < 0) || (i >= grid.length) || (j >= grid[0].length) || Arr[i][j]){
            return;
        } Pair p = new Pair(i, j, grid[i][j]); pq.add(p);
        if(grid[i][j] == grid[grid.length - 1][grid[0].length - 1]){
            dst = p;
        } System.out.println("NodeAdd: " + i + "," + j + " " + grid[i][j]);
    }

    private static int LeastTime(int[][] grid) {
        if((grid == null) || (grid.length <= 0)){
            return -1;
        } boolean[][] Arr = new boolean[grid.length][grid[0].length];
        return Dijkstra(grid, Arr, 0, 0, (grid.length - 1), (grid[0].length - 1));
    }
}