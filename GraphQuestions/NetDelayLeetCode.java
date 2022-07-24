import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.HashSet;

public class NetDelayLeetCode {

    // https://leetcode.com/problems/network-delay-time/

    private static class Edge{
        int v, w;
        Edge(int v, int w){
            this.v = v; this.w = w;
        }
    }
    
    public static void main(String[] args) {
        int[][] times = {{1,2,1}};
        int n = 2, k = 2;

        ArrayList<ArrayList<Edge>> L = new ArrayList<>();
        createGraph(L, n, times);

        System.out.println(NetworkDelay(L, n, k));
    }

    private static class Pair implements Comparable<Pair>{
        int Node, Weight;
        Pair(int Node, int Weight){
            this.Node = Node; this.Weight = Weight;
        }
        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.Weight, o.Weight); // (- this.Weight + o.Weight);
        }
    }

    private static int Dijkstra(ArrayList<ArrayList<Edge>> L, int n, boolean[] Arr, HashSet<Integer> Set, int k) {
        PriorityQueue<Pair> Q = new PriorityQueue<>();
        int maxTime = -1; Q.add(new Pair(k, 0));

        while(!Q.isEmpty()){
            Pair T = Q.poll();
            if(Arr[T.Node]){
                continue;
            } Arr[T.Node] = true; Set.add(T.Node);
            System.out.println("NodePoll: " + T.Node + " " + T.Weight);

            maxTime = Math.max(maxTime, T.Weight);
            for(Edge E: L.get(T.Node)){
                if(!Arr[E.v]){
                    Q.add(new Pair(E.v, (E.w + T.Weight)));
                    System.out.println("NodeAdd: " + E.v + " " + (E.w + T.Weight));
                }
            }
        } if(Set.size() != n){
            return -1;
        } return maxTime;
    }

    private static int NetworkDelay(ArrayList<ArrayList<Edge>> L, int n, int k) {
        if((L == null) || (L.size() <= 0) || (n <= 0)){
            return 0;
        } boolean[] Arr = new boolean[n+1]; HashSet<Integer> Set = new HashSet<>();
        return Dijkstra(L, n, Arr, Set, k);
    }

    private static void createGraph(ArrayList<ArrayList<Edge>> L, int n, int[][] times) {
        for(int i=0; i<=n; i++){
            L.add(new ArrayList<Edge>());
        }
        for(int i=0; i<times.length; i++){
            int u = times[i][0], v = times[i][1], w = times[i][2];
            L.get(u).add(new Edge(v, w)); 
            // L.get(v).add(new Edge(u, w));
        }
    }
}