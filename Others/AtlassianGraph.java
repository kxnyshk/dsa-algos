import java.util.PriorityQueue;
import java.util.ArrayList;

public class AtlassianGraph {

    // [1/4] A Graph question of my Atlassian on-Campus Online Assesment Coding round.

    // Prompt: A Weighted graph is given, find the smallest path that may exist between 
    // Node [1] & Node [V]. While traversing you may add an extra weighted edge [of only
    // weight 1] between Nodes that aren't pre connected together as per the question. No 
    // self edges allowed.

    private static class Edge{
        int v, w;
        Edge(int v, int w){
            this.v = v; this.w = w;
        }
    }
    
    public static void main(String[] args) {
        double startTime = System.nanoTime();
        int V = 7; boolean[][] Arr = new boolean[V + 1][V + 1];
        ArrayList<ArrayList<Edge>> L = new ArrayList<>();
        for(int i=0; i<(V + 1); i++){
            L.add(new ArrayList<Edge>());
        }
        
        AddEdge(L, Arr, 1, 2, 3);       // adding given edges
        AddEdge(L, Arr, 1, 3, 2);       // adding given edges
        AddEdge(L, Arr, 1, 7, 6);       // adding given edges
        AddEdge(L, Arr, 2, 4, 1);       // adding given edges
        AddEdge(L, Arr, 2, 6, 4);       // adding given edges
        AddEdge(L, Arr, 3, 5, 2);       // adding given edges
        AddEdge(L, Arr, 4, 7, 2);       // adding given edges
        AddNonConnectedEdges(L, Arr);

        int Path = Dijkstra(L, V);
        double endTime = System.nanoTime();
        System.out.println(Path);

        double duration = ((endTime - startTime) / Math.pow(10, 6));
        System.out.println("Execution Time: " + duration + " ms");
    }

    private static class Pair implements Comparable<Pair>{
        int Node, Path;
        Pair(int Node, int Path){
            this.Node = Node; this.Path = Path;
        }
        @Override
        public int compareTo(Pair o) {
            return (this.Path - o.Path);
        }
    }

    private static int Dijkstra(ArrayList<ArrayList<Edge>> L, int V){
        boolean[] Arr = new boolean[V + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int Path = -1; pq.add(new Pair(1, 0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(p.Node == V){
                Path = p.Path; break;
            } if(Arr[p.Node]){
                continue;
            } Arr[p.Node] = true;

            for(Edge E: L.get(p.Node)){
                if(!Arr[E.v]){
                    pq.add(new Pair(E.v, (E.w + p.Path)));
                }
            }
        } return Path;
    }

    private static void AddNonConnectedEdges(ArrayList<ArrayList<Edge>> L, boolean[][] Arr) {
        for(int i=1; i<Arr.length; i++){
            for(int j=(i + 1); j<Arr[0].length; j++){
                if((i != j) && !Arr[i][j]){
                    L.get(i).add(new Edge(j, 1)); Arr[i][j] = true;
                }
            }
        }
    }

    private static void AddEdge(ArrayList<ArrayList<Edge>> L, boolean[][] Arr, int Node, int v, int w) {
        L.get(Node).add(new Edge(v, w)); Arr[Node][v] = true;
    }
}