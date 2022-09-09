import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RankTransform {

    // https://leetcode.com/problems/rank-transform-of-a-matrix/
    // LeetCode solution -> class Solution {..}
    
    class Solution {
    
        class Pair implements Comparable<Pair>{
            int x, y, v;
            Pair(int x, int y, int v){
                this.x = x; this.y = y; this.v = v;
            } public int compareTo(Pair o){
                return (this.v - o.v);
            }
        }
        
        int[] Rows, Cols;
        Pair[] Maps;
        
        List<Pair> L = new ArrayList<>();
        int tempVar = Integer.MIN_VALUE;
        
        public int[][] matrixRankTransform(int[][] matrix) {
            Rows = new int[matrix.length]; Cols = new int[matrix[0].length];
            Maps = new Pair[(matrix.length)*(matrix[0].length)];
            
            buildMaps(matrix); loop(matrix);
            return matrix;
        }
        
        void func(int[][] Arr){
            int[] Par = new int[Arr.length + Arr[0].length];
            Arrays.fill(Par, -1);
            
            for(Pair p: L){
                int f1 = find(p.x, Par); int f2 = find((p.y + Arr.length), Par);
                union(f1, f2, Par, p);
            }
            for(Pair p: L){
                int max = - Par[find(p.x, Par)];
                Arr[p.x][p.y] = max;
                Rows[p.x] = max; Cols[p.y] = max;
                
            }
        }
        
        int find(int Node, int[] Par){
            if(Par[Node] < 0){
                return Node;
            } return Par[Node] = find(Par[Node], Par);
        }
        
        void union(int N1, int N2, int[] Par, Pair P){
            if(N1 != N2){
                int max = Math.min(Par[N1], Math.min(Par[N2], (- Math.max(Rows[P.x], Cols[P.y]) - 1)));
                Par[N1] = max; Par[N2] = N1;
            }
        }
        
        void loop(int[][] matrix){
            for(int i=0; i<Maps.length; i++){
                if(tempVar != Maps[i].v){
                    func(matrix);
                    tempVar = Maps[i].v; L = new ArrayList<>();
                } L.add(Maps[i]);
            } func(matrix);
        }
        
        void buildMaps(int[][] Arr){
            int k = 0;
            for(int i=0; i<Arr.length; i++){
                for(int j=0; j<Arr[i].length; j++){
                    Maps[k++] = new Pair(i, j, Arr[i][j]);
                }
            }  Arrays.sort(Maps);
        }
    }
}