import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgo {

    private static class Edge{
        int u, v, w;
        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    
    public static void main(String[] args) {
        int V = 7;
        ArrayList<ArrayList<Edge>> L = new ArrayList<>();
        for(int i=0; i<V; i++){
            L.add(new ArrayList<Edge>());
        }
        
        AddEdge(L, 0, 1, 10);
        AddEdge(L, 0, 3, 25);
        AddEdge(L, 1, 2, 10);
        AddEdge(L, 2, 3, 10);
        AddEdge(L, 3, 4, 2);
        AddEdge(L, 4, 5, 3);
        AddEdge(L, 4, 6, 8);
        AddEdge(L, 5, 6, 3);
        Djikstra(L, V);
    }

    private static class Pair implements Comparable<Pair>{
        int Node, Weight; String Path;
        Pair(int Node, int Weight, String Path){
            this.Node = Node;
            this.Weight= Weight;
            this.Path = Path;
        }
        @Override
        public int compareTo(Pair o) {
            return (this.Weight - o.Weight);
        }
    }
    
    private static void bfs(ArrayList<ArrayList<Edge>> L, int V, boolean[] Arr, int Source, int Destination, String Path, int Weight) {
        PriorityQueue<Pair> Q = new PriorityQueue<>();
        
        Q.add(new Pair(Source, Weight, Integer.toString(Source)));

        while(!Q.isEmpty()){
            Pair P = Q.poll();
            if(Arr[P.Node]){
                continue;
            }
            System.out.print(P.Node + " ");
            System.out.print(P.Weight + " ");
            System.out.println(P.Path);
            Path += " -> "; Path += P.Node;
            Arr[P.Node] = true;

            if(P.Node == Destination){
                System.out.println(P.Path + " (" + P.Weight + ")");
                return;
            }

            for(Edge E: L.get(P.Node)){
                if(!Arr[E.v]){
                    Q.add(new Pair(E.v, (P.Weight + E.w), (P.Path + " -> " + E.v)));
                }
            }
        }
    }

    private static void Djikstra(ArrayList<ArrayList<Edge>> L, int V) {
        boolean[] Arr = new boolean[V];
        int S = 0; int D = 6; int W = 0;
        String Path = Integer.toString(0);
        bfs(L, V, Arr, S, D, Path, W);
    }

    private static void AddEdge(ArrayList<ArrayList<Edge>> L, int u, int v, int w){
        L.get(u).add(new Edge(u, v, w));
        L.get(v).add(new Edge(v, u, w));
    }
}
