import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimAlgoMST {

    private static class Edge{
        int u, v, w;
        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Edge>> L = new ArrayList<>();
        for(int i=0; i<V; i++){
            L.add(new ArrayList<Edge>());
        }
        
        // AddEdge(L, 0, 1, 10);
        // AddEdge(L, 0, 3, 25);
        // AddEdge(L, 1, 2, 10);
        // AddEdge(L, 2, 3, 10);
        // AddEdge(L, 3, 4, 2);
        // AddEdge(L, 4, 5, 3);
        // AddEdge(L, 4, 6, 8);
        // AddEdge(L, 5, 6, 3);
        AddEdge(L, 2, 1, 1);
        AddEdge(L, 2, 3, 1);
        AddEdge(L, 3, 4, 1);
        Prims(L, V);
    }

    private static class Pair implements Comparable<Pair>{
        int Node, Weight;
        Pair(int Node, int Weight){
            this.Node = Node;
            this.Weight = Weight;
        }
        @Override
        public int compareTo(PrimAlgoMST.Pair o) {
            return (this.Weight - o.Weight);
        }
    }

    private static void bfs(ArrayList<ArrayList<Edge>> L, int V, boolean[] Arr, int Source) {
        PriorityQueue<Pair> Q = new PriorityQueue<>();
        Q.add(new Pair(Source, 0));
        String Path = Integer.toString(Source); int W = 0;

        while(!Q.isEmpty()){
            Pair P = Q.poll();
            if(Arr[P.Node]){
                continue;
            } if(P.Node != Source){
                Path += " -> "; Path += P.Node; W+= P.Weight;
            } Arr[P.Node] = true;

            for(Edge E: L.get(P.Node)){
                if(!Arr[E.v]){
                    Q.add(new Pair(E.v, E.w));
                }
            }
        } System.out.println(Path + " (" + W + ")");
    }

    private static void Prims(ArrayList<ArrayList<Edge>> L, int V) {
        boolean[] Arr = new boolean[V]; int S = 2;
        bfs(L, V, Arr, S);
    }

    private static void AddEdge(ArrayList<ArrayList<Edge>> L, int u, int v, int w){
        L.get(u).add(new Edge(u, v, w));
        L.get(v).add(new Edge(v, u, w));
    }
}
