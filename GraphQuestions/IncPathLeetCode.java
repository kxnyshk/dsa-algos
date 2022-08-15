import java.util.PriorityQueue;

public class IncPathLeetCode {

    // https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
    // using Dijkstra -> TLE solution.
    // refer to <<IncPathDFSLeetCode.java>> for better solution.
    
    public static void main(String[] args) {
        int[][] matrix = {{7,6,1,1},{2,7,6,0},{1,3,5,1},{6,6,3,2}};
        System.out.println(LongestPath(matrix));
    }

    private static class Pair implements Comparable<Pair>{
        int i, j, length;
        Pair(int i, int j, int length){
            this.i = i;
            this.j = j;
            this.length = length;
        }
        @Override
        public int compareTo(Pair o) {
            return (o.length - this.length);
        }
    }

    private static int Dijkstra(int[][] matrix, int i, int j) {
        int[][] XY = {{0,-1},{-1,0},{0,1},{1,0}};
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(i, j, 1));

        int path = -1;
        while(!pq.isEmpty()){
            Pair p = pq.poll();

            path = Math.max(path, p.length);
            for(int k=0; k<XY.length; k++){
                int x = (p.i + XY[k][0]), y = (p.j + XY[k][1]);
                if((x >= 0) && (y >= 0) && (x < matrix.length) && (y < matrix[0].length) && (matrix[x][y] > matrix[p.i][p.j])){
                    pq.add(new Pair(x, y, (p.length + 1)));
                }
            }
        } return path;
    }

    private static int LongestPath(int[][] matrix) {
        int path = -1;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                int temp = Dijkstra(matrix, i, j);
                path = Math.max(path, temp);
            }
        } return path;
    }
}