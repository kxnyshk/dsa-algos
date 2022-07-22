import java.util.PriorityQueue;
import java.util.ArrayList;

public class Dijkstra {
    
    private static class Edge{
        int v, w;
        Edge(int v, int w){
            this.v = v; this.w = w;
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
        ShortestWeightedPath(L, V);
    }

    private static class Pair implements Comparable<Pair>{
        int Node, Weight;
        Pair(int Node, int Weight){
            this.Node = Node; this.Weight = Weight;
        }
        @Override
        public int compareTo(Pair o) {
            return (this.Weight - o.Weight);
        }
    }

    private static void bfs(ArrayList<ArrayList<Edge>> L, int V, boolean[] Arr, int Source, int Destination) {
        PriorityQueue<Pair> Q = new PriorityQueue<>();
        Q.add(new Pair(Source, 0));

        while(!Q.isEmpty()){
            Pair T = Q.poll();
            if(Arr[T.Node]){
                continue;
            } Arr[T.Node] = true; System.out.println(T.Node + " " + T.Weight);

            if(T.Node == Destination){
                return;
            }

            for(Edge E: L.get(T.Node)){
                if(!Arr[E.v]){
                    Q.add(new Pair(E.v, (E.w + T.Weight)));
                }
            }
        }
    }

    private static void ShortestWeightedPath(ArrayList<ArrayList<Edge>> L, int V) {
        boolean[] Arr = new boolean[V]; int D = (V - 1);
        bfs(L, V, Arr, 0, D);
    }

    private static void AddEdge(ArrayList<ArrayList<Edge>> L, int Node, int v, int w) {
        L.get(Node).add(new Edge(v, w));
        L.get(v).add(new Edge(Node, w));
    }
}