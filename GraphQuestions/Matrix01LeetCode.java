import java.util.ArrayDeque;
import java.util.Arrays;

public class Matrix01LeetCode {

    // https://leetcode.com/problems/01-matrix/
    
    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        System.out.println(Arrays.deepToString(Matrix(mat)));
    }

    private static class Pair{
        int i, j, distance;
        Pair(int i, int j, int distance){
            this.i = i;
            this.j = j;
            this.distance = distance;
        }
    }

    private static int[][] Matrix(int[][] mat) {
        boolean[][] Arr = new boolean[mat.length][mat[0].length];
        int[][] Res = new int[mat.length][mat[0].length];
        ArrayDeque<Pair> q = new ArrayDeque<>();

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 0){
                    Res[i][j] = 0; Arr[i][j] = true;
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        while(!q.isEmpty()){
            Pair p = q.poll();

            QueueAdd(mat, Res, Arr, q, p, p.i, (p.j - 1)); QueueAdd(mat, Res, Arr, q, p, (p.i - 1), p.j);
            QueueAdd(mat, Res, Arr, q, p, p.i, (p.j + 1)); QueueAdd(mat, Res, Arr, q, p, (p.i + 1), p.j);
        } return Res;
    }

    private static void QueueAdd(int[][] mat, int[][] Res, boolean[][] Arr, ArrayDeque<Pair> q, Pair p, int i, int j) {
        if((i < 0) || (j < 0) || (i >= mat.length) || (j >= mat[0].length) || Arr[i][j]){
            return;
        } Arr[i][j] = true; Res[i][j] = (p.distance + 1);
        q.add(new Pair(i, j, (p.distance + 1)));
    }
}