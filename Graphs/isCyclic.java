import java.util.ArrayDeque;
import java.util.ArrayList;

public class isCyclic{

    // Cyclic Component detection using BFS

    private static class Edge{
        int u, v, w;
        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    } 

    public static void main(String[] args) {
        int V = 8;
        ArrayList<ArrayList<Edge>> L = new ArrayList<>();
        for(int i=0; i<V; i++){
            L.add(new ArrayList<Edge>());
        }
        
        AddEdge(L, 0, 1, 10);
        AddEdge(L, 0, 2, 10);
        AddEdge(L, 1, 3, 10);
        AddEdge(L, 2, 3, 10);
        AddEdge(L, 4, 5, 10);
        AddEdge(L, 4, 6, 10);
        AddEdge(L, 5, 6, 10);
        AddEdge(L, 4, 7, 10);
        checkCycle(L, V);
    }

    private static class Pair{
        int Node, Parent;
        Pair(int Node, int Parent){
            this.Node = Node;
            this.Parent = Parent;
        }
    }

    private static void bfs(ArrayList<ArrayList<Edge>> L, int V, int Source, boolean[] Arr, String Path){
        ArrayDeque<Pair> Q = new ArrayDeque<>();
        ArrayDeque<String> P = new ArrayDeque<>();
        
        Q.add(new Pair(Source, -1)); Arr[Source] = true;

        while(!Q.isEmpty()){
            int TempNode = Q.peek().Node;
            int TempParent = Q.peek().Parent;
            Q.remove();
            
            for(Edge E: L.get(TempNode)){
                if(!Arr[E.v]){
                    Q.add(new Pair(E.v, TempNode));
                    Arr[E.v] = true;
                    Path += " -> "; Path += E.v;
                } else if((Arr[E.v]) && (E.v != TempParent)){
                    boolean found = false;
                    for(String X: P){
                        if(X == Path){
                            found = true; break;
                        }
                    } if(!found){
                        System.out.println(Path);
                        P.add(Path);
                    }
                    
                }
            }
        }
    }

    private static void checkCycle(ArrayList<ArrayList<Edge>> L, int V){
        boolean[] Arr = new boolean[V];
        for(int i=0; i<V; i++){
            String Path = Integer.toString(i);
            if(!Arr[i]){
                bfs(L, V, i, Arr, Path);
            }
        }
    }

    private static void AddEdge(ArrayList<ArrayList<Edge>> L, int u, int v, int w){
        L.get(u).add(new Edge(u, v, w));
        L.get(v).add(new Edge(v, u, w));
    }
}