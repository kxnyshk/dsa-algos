import java.util.PriorityQueue;

public class MinObstacleLeetCode {

    // https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/
    
    public static void main(String[] args) {
        
        int[][] Arr = { {0,1,1},
                        {1,1,0},
                        {1,1,0}, };
        System.out.println(MinObstacle(Arr));
    }

    private static class Pair implements Comparable<Pair>{
        int i, j, Weight;
        Pair(int i, int j, int Weight){
            this.i = i; this.j = j; this.Weight = Weight;
        }
        @Override
        public int compareTo(Pair o) {
            return (this.Weight - o.Weight);
        }
    }

    private static int Djikstra(int[][] Arr, boolean[][] Bool, int i, int j, int Di, int Dj) {
        PriorityQueue<Pair> Q = new PriorityQueue<>();
        int W = 0; Q.add(new Pair(i, j, Arr[i][j]));

        while(!Q.isEmpty()){
            Pair T = Q.poll();
            if(Bool[T.i][T.j]){
                continue;
            } Bool[T.i][T.j] = true; 
            //debug-1 System.out.println("\nIndxPoll: " + T.i + " " + T.j);

            if((T.i == Di) && (T.j == Dj)){
                //debug-2 System.out.println("Weight: " + T.Weight + " Exiting with return");
                W = T.Weight; break;
            }
        
            QueueAdd(Arr, Bool, Q, (T.i-1), T.j, T);
            QueueAdd(Arr, Bool, Q, T.i, (T.j-1), T);
            QueueAdd(Arr, Bool, Q, T.i, (T.j+1), T);
            QueueAdd(Arr, Bool, Q, (T.i+1), T.j, T);
        } return W;
    }

    private static void QueueAdd(int[][] Arr, boolean[][] Bool, PriorityQueue<Pair> Q, int i, int j, Pair T) {
        if((i>=0) && (i<Arr.length) && (j>=0) && (j<Arr[0].length) && !Bool[i][j]){
            //debug-3 System.err.println("QueueAdd: " + i + " " + j);
            Q.add(new Pair(i, j, (T.Weight + Arr[i][j])));
        } else {
            //debug-4 System.out.println("NotAdded: " + i + " " + j);
            return;
        }
    }

    private static int MinObstacle(int[][] Arr) {
        if((Arr == null) || (Arr.length <= 0)){
            return -1;
        } boolean[][] Bool = new boolean[Arr.length][Arr[0].length];
        return Djikstra(Arr, Bool, 0, 0, (Arr.length - 1), (Arr[0].length - 1));
    }
}