import java.util.PriorityQueue;
import java.util.ArrayList;

public class MaxPathLeetCode {

    // https://leetcode.com/problems/path-with-maximum-probability/

    private static class Edge{
        int v; double w;
        Edge(int v, double w){
            this.v = v; this.w = w;
        }
    }
    
    public static void main(String[] args) {
        int n = 3; int[][] edges = {{0,1}}; double[] succProb = {0.5}; 
        int start = 0, end = 2;

        ArrayList<ArrayList<Edge>> L = new ArrayList<>();
        createGraph(L, n, edges, succProb);

        System.out.println(MaxPath(L, n, start, end));
    }

    private static class Pair implements Comparable<Pair>{
        int Node; double Weight;
        Pair(int Node, double Weight){
            this.Node = Node; this.Weight = Weight;
        }
        @Override
        public int compareTo(Pair o) {
            return Double.compare(o.Weight, this.Weight); // (- this.Weight + o.Weight);
        }
    }

    private static double Dijkstra(ArrayList<ArrayList<Edge>> L, int n, boolean[] Arr, int start, int end) {
        PriorityQueue<Pair> Q = new PriorityQueue<>();
        double W = 0; Q.add(new Pair(start, (double) 1));

        while(!Q.isEmpty()){
            Pair T = Q.poll();
            if(Arr[T.Node]){
                continue;
            } Arr[T.Node] = true; // System.out.println("NodePoll: " + T.Node);

            if(T.Node == end){
                W = T.Weight; break;
            }

            for(Edge E: L.get(T.Node)){
                if(!Arr[E.v]){
                    Q.add(new Pair(E.v, (E.w * T.Weight)));
                    // System.out.println("NodeAdd: " + E.v + " " + (E.w * T.Weight));
                }
            }
        } return (double) W;
    }

    private static double MaxPath(ArrayList<ArrayList<Edge>> L, int n, int start, int end) {
        if((L == null) || (L.size() <= 0) || (n <= 0)){
            return (double) 0;
        } boolean[] Arr = new boolean[n];
        return (double) Dijkstra(L, n, Arr, start, end);
    }

    private static void createGraph(ArrayList<ArrayList<Edge>> L, int n, int[][] edges, double[] succProb) {
        for(int i=0; i<n; i++){
            L.add(new ArrayList<Edge>());
        }
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0], v = edges[i][1]; double w = succProb[i];
            L.get(u).add(new Edge(v, w)); L.get(v).add(new Edge(u, w));
        }
    }
}
