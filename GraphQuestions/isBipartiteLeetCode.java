import java.util.ArrayDeque;
import java.util.Arrays;

public class isBipartiteLeetCode {

    // https://leetcode.com/problems/is-graph-bipartite/
    
    public static void main(String[] args) {
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        boolean flag = checkBipartite(graph);
        System.out.println(flag);
    }

    private static class Pair{
        int Node, Level;
        Pair(int Node, int Level){
            this.Node = Node; this.Level = Level;
        }
    }

    private static boolean bfs(int[][] graph, int[] Arr, int Node) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(Node, 0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            if((Arr[p.Node] != -1) && (Arr[p.Node] != p.Level)){
                return false;
            } if(Arr[p.Node] == -1){
                Arr[p.Node] = p.Level;
            }

            for(int E: graph[p.Node]){
                if(Arr[E] == -1){
                    q.add(new Pair(E, (p.Level + 1)));
                }
            }
        } return true;
    }

    private static boolean checkBipartite(int[][] graph) {
        int[] Arr = new int[graph.length]; Arrays.fill(Arr, -1);
        for(int i=0; i<graph.length; i++){
            if(Arr[i] == -1){
                boolean flag = bfs(graph, Arr, i);
                if(!flag){
                    return false;
                }
            }
        } return true;
    }
}