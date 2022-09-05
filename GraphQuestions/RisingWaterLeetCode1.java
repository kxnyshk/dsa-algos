import java.util.PriorityQueue;

public class RisingWaterLeetCode1 {

    // https://leetcode.com/problems/swim-in-rising-water/
    // LeetCode solution -> class Solution {..}

    class Solution {

        public int swimInWater(int[][] grid) {
            return Dijkstra(grid);
        }
        
        private static class Pair implements Comparable<Pair>{
            int i, j, Level;
            Pair(int i, int j, int Level){
                this.i = i; this.j = j; this.Level = Level;
            } @Override
            public int compareTo(Pair o) {
                return (this.Level - o.Level);
            }
        }
    
        private static int Dijkstra(int[][] grid) {
            boolean[][] Arr = new boolean[grid.length][grid[0].length];
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.add(new Pair(0, 0, grid[0][0]));
    
            while(!pq.isEmpty()){
                Pair p = pq.poll();
                if(Arr[p.i][p.j]){
                    continue;
                } Arr[p.i][p.j] = true;
    
                if((p.i == (grid.length - 1)) && (p.j == (grid[0].length - 1))){
                    return p.Level;
                }
    
                addEdge(grid, Arr, pq, p.i, p.j, (p.i-1), p.j, p); addEdge(grid, Arr, pq, p.i, p.j, p.i, (p.j+1), p);
                addEdge(grid, Arr, pq, p.i, p.j, (p.i+1), p.j, p); addEdge(grid, Arr, pq, p.i, p.j, p.i, (p.j-1), p);
            }  return -1;
        }
    
        private static void addEdge(int[][] grid, boolean[][] Arr, PriorityQueue<Pair> pq, int prevI, int prevJ, int i, int j, Pair p) {
            if((i < 0) || (j < 0) || (i >= grid.length) || (j >= grid[0].length) || Arr[i][j]){
                return;
            } pq.add(new Pair(i, j, Math.max(grid[i][j], p.Level)));
        }
    }
}