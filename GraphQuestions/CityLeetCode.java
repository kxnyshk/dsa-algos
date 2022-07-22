import java.util.ArrayList;
import java.util.PriorityQueue;

public class CityLeetCode {

    // https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
    // Using Dijkstra (BFS). Passing all TCs (54/54).

    private static class Edge{
        int v, w;
        Edge(int v, int w){
            this.v = v; this.w = w;
        }
    }
    
    public static void main(String[] args) {
        int n = 6; int[][] edges = {{0,1,10},{0,2,1},{2,3,1},{1,3,1},{1,4,1},{4,5,10}};
        int distanceThreshold = 20;

        ArrayList<ArrayList<Edge>> L = new ArrayList<>();
        createGraph(n, edges, L);

        System.out.println(Cities(L, n, distanceThreshold));
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

    private static int ReturnCount = 0;

    private static int Dijkstra(ArrayList<ArrayList<Edge>> L, int n, int Limit, boolean[] Arr, int Node,int Weight) {
        PriorityQueue<Pair> Q = new PriorityQueue<>();
        Q.add(new Pair(Node, Weight));
        
        while(!Q.isEmpty()){
            Pair T = Q.poll();
            if((Arr[T.Node]) || (T.Weight > Limit)){
                continue;
            } Arr[T.Node] = true; ReturnCount++;
            System.out.println("\nNodePoll: " + T.Node + " " + T.Weight);

            for(Edge E: L.get(T.Node)){
                if(!Arr[E.v]){
                    Q.add(new Pair(E.v, (E.w + T.Weight)));
                    System.out.println("NodeAdd: " + E.v + " " + (E.w + T.Weight));
                }
            }
        } return (ReturnCount - 1);
    }

    private static int Cities(ArrayList<ArrayList<Edge>> L, int n, int Limit) {
        if((L == null) || (L.size() <= 0) || (n <= 1) || (Limit <= 0)){
            return -1;
        } int Node = -1, Count = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            boolean[] Arr = new boolean[n]; ReturnCount = 0;
            int T = Dijkstra(L, n, Limit, Arr, i, 0);
            System.out.println(T);

            if(T <= Count){
                Count = T; Node = Math.max(Node, i);
                System.out.println("Count: " + Count + " Node: " + Node);
            }
        } return Node;
    }

    private static void createGraph(int n, int[][] edges, ArrayList<ArrayList<Edge>> L) {
        for(int i=0; i<n; i++){
            L.add(new ArrayList<Edge>());
        }
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            L.get(u).add(new Edge(v, w));
            L.get(v).add(new Edge(u, w));
        }
    }
}