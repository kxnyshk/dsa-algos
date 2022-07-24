import java.util.PriorityQueue;

public class MinPathLeetCode {

    // https://leetcode.com/problems/path-with-minimum-effort/
    
    public static void main(String[] args) {
        int[][] heights = {{3},{3},{7},{2},{9},{9},{3},{7},{10}};
        System.out.println(MinPath(heights));
    }

    private static class Pair implements Comparable<Pair>{
        int i, j, Diff;
        Pair(int i, int j, int Diff){
            this.i = i; this.j = j; this.Diff = Diff;
        }
        @Override
        public int compareTo(Pair o) {
            return (this.Diff - o.Diff);
        }
    }

    private static int Dijkstra(int[][] heights, boolean[][] Arr, int i, int j, int k, int l) {
        PriorityQueue<Pair> Q = new PriorityQueue<>();
        int W = 0; Q.add(new Pair(i, j, 0));
        
        while(!Q.isEmpty()){
            Pair T = Q.poll();
            if(Arr[T.i][T.j]){
                continue;
            } Arr[T.i][T.j] = true; System.out.println("\nNodePoll: " + T.i + "," + T.j + " " + T.Diff);

            W = Math.max(W, T.Diff);
            if((T.i == k) && (T.j == l)){
                System.out.println("Return executed");
                break;
            }

            QueueAdd(Arr, heights, Q, T.i, T.j, (T.i-1), T.j, T);
            QueueAdd(Arr, heights, Q, T.i, T.j, T.i, (T.j-1), T);
            QueueAdd(Arr, heights, Q, T.i, T.j, T.i, (T.j+1), T);
            QueueAdd(Arr, heights, Q, T.i, T.j, (T.i+1), T.j, T);
        } return W;
    }

    private static void QueueAdd(boolean[][] Arr, int[][] heights, PriorityQueue<Pair> Q, int prevI, int prevJ, int i, int j, Pair T) {
        if((i>=0) && (i<heights.length) && (j>=0) && (j<heights[0].length) && !Arr[i][j]){
            Q.add(new Pair(i, j, (Math.abs(heights[i][j] - heights[prevI][prevJ]))));
            System.err.println("QueueAdd: " + i + "," + j + " " + (Math.abs(heights[i][j] - heights[prevI][prevJ])));
        } else {
            System.out.println("NotAdded: " + i + "," + j);
            return;
        }
    }

    private static int MinPath(int[][] heights) {
        if((heights == null) || (heights.length <= 0) || (heights[0].length <= 0)){
            return 0;
        } boolean[][] Arr = new boolean[heights.length][heights[0].length];
        return Dijkstra(heights, Arr, 0, 0, (heights.length - 1), (heights[0].length - 1));
    }
}
