import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class isBipartite {

    // Bipartite detection using BFS

    private static class Edge{
        int u, v, w;
        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    } 
    
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Edge>> L = new ArrayList<>();
        for(int i=0; i<V; i++){
            L.add(new ArrayList<Edge>());
        }
        
        AddEdge(L, 0, 1, 10);
        AddEdge(L, 0, 2, 10);
        AddEdge(L, 1, 3, 10);
        checkBipartite(L, V);
    }

    private static class Pair{
        int Node, Level; String Path;
        Pair(int Node, int Level, String Path){
            this.Node = Node;
            this.Level = Level;
            this.Path = Path;
        }
    }
    
    private static void bfs(ArrayList<ArrayList<Edge>> L, int V, int[] Arr, int Node, int Level, String Path) {
        ArrayDeque<Pair> Q = new ArrayDeque<>();

        Q.add(new Pair(Node, Level, Path));
        while(!Q.isEmpty()){
            Pair Temp = Q.poll();

            if(Arr[Temp.Node] == -1){
                Arr[Temp.Node] = Temp.Level;
            } else if((Arr[Temp.Node] != -1) && (Temp.Level != Arr[Temp.Node])){
                System.out.println(Path.substring(0, (Path.length() - 5)) + " (Non Bipartite)");
                return;
            }

            for(Edge E: L.get(Temp.Node)){
                if(Arr[E.v] == -1){
                    Q.add(new Pair(E.v, (Temp.Level + 1), (Temp.Path + " -> " + E.v)));
                    Path += " -> "; Path += E.v;
                }
            }
        } if(Path.charAt(Path.length() - 1) == Path.charAt(Path.length() - 6)){
            System.out.println(Path.substring(0, (Path.length() - 5)) + " (Bipartite)");
        } else{
            System.out.println(Path + " (Bipartite)");
        }
        
    }

    private static void checkBipartite(ArrayList<ArrayList<Edge>> L, int V) {
        int[] Arr = new int[V];
        Arrays.fill(Arr, -1);
        bfs(L, V, Arr, 0, 0, "0");
    }

    private static void AddEdge(ArrayList<ArrayList<Edge>> L, int u, int v, int w){
        L.get(u).add(new Edge(u, v, w));
        L.get(v).add(new Edge(v, u, w));
    }
}
