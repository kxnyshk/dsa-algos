import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class isBipartiteGfg {

    // https://practice.geeksforgeeks.org/problems/bipartite-graph/1
    
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> L = new ArrayList<>();
        for(int i=0; i<V; i++){
            L.add(new ArrayList<Integer>());
        }

        AddEdge(L, 0, 2); AddEdge(L, 1, 2);
        AddEdge(L, 1, 3); AddEdge(L, 2, 3);

        boolean flag = checkBipartite(L, V);
        System.out.println(flag);
    }

    private static class Pair{
        int Node, Level;
        Pair(int Node, int Level){
            this.Node = Node; this.Level = Level;
        }
    }

    private static boolean bfs(ArrayList<ArrayList<Integer>> L, int V, int[] Arr, int Node) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(Node, 0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            if((Arr[p.Node] != -1) && (Arr[p.Node] != p.Level)){
                return false;
            } if(Arr[p.Node] == -1){
                Arr[p.Node] = p.Level;
            }
            
            for(int E: L.get(p.Node)){
                if(Arr[E] == -1){
                    q.add(new Pair(E, (p.Level + 1)));
                }
            }

        } return true;
    }

    private static boolean checkBipartite(ArrayList<ArrayList<Integer>> L, int V){
        int[] Arr = new int[V]; Arrays.fill(Arr, -1); 
        for(int i=0; i<V; i++){
            if(Arr[i] == -1){
                boolean check = bfs(L, V, Arr, i);
                if(!check){
                    return false;
                }
            }
        } return true;
    }

    private static void AddEdge(ArrayList<ArrayList<Integer>> L, int i, int j) {
        L.get(i).add(j); L.get(j).add(i);
    }
}