import java.util.PriorityQueue;
import java.util.Collections;
import java.util.ArrayList;

public class KthPathDFS {

    private static class Edge{
        int u, v, w;
        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    
    public static void main(String[] args) {
        int V = 7; int K = 2;
        ArrayList<ArrayList<Edge>> L = new ArrayList<>();
        for(int i=0; i<V; i++){
            L.add(new ArrayList<Edge>());
        }
        
        AddEdge(L, 0, 1, 10);
        AddEdge(L, 0, 3, 40);
        AddEdge(L, 1, 2, 10);
        AddEdge(L, 2, 3, 10);
        AddEdge(L, 3, 4, 2);
        AddEdge(L, 4, 5, 3);
        AddEdge(L, 4, 6, 8);
        AddEdge(L, 5, 6, 3);
        KthPath(L, V, K);
    }

    private static class Pair implements Comparable<Pair>{
        String Path; int Weight;
        Pair(String Path, int Weight){
            this.Path = Path;
            this.Weight = Weight;
        }
        @Override
        public int compareTo(KthPathDFS.Pair o) {
            return (this.Weight - o.Weight);
        }
    }

    private static PriorityQueue<Pair> KthSmall = new PriorityQueue<>(Collections.reverseOrder());
    private static PriorityQueue<Pair> KthLarge = new PriorityQueue<>();

    private static void Recursive(ArrayList<ArrayList<Edge>> L, int Source, int Destination, boolean[] Arr, String Path, int Weight, int K){
        if(Source == Destination){
            if(KthLarge.size() < K){
                KthLarge.add(new Pair(Path, Weight));
            } else if(Weight > KthLarge.peek().Weight){
                    KthLarge.remove(); KthLarge.add(new Pair(Path, Weight));
            } if(KthSmall.size() < K){
                KthSmall.add(new Pair(Path, Weight));
            } else if(Weight < KthSmall.peek().Weight){
                  KthSmall.remove(); KthSmall.add(new Pair(Path, Weight));
            }
        } Arr[Source] = true;

        for(Edge E : L.get(Source)){
            if(!Arr[E.v]){
                Recursive(L, E.v, Destination, Arr, (Path + " -> " + E.v), (Weight + E.w), K);
            }
        } Arr[Source] = false;
    }

    private static void KthPath(ArrayList<ArrayList<Edge>> L, int V, int K){
        boolean[] Arr = new boolean[V]; int S = 0; int D = (V - 1); int W = 0;
        String Path = Integer.toString(S); Recursive(L, S, D, Arr, Path, W, K);
        System.out.println("Kth Small: " + KthSmall.peek().Path + " (" + KthSmall.poll().Weight + ")");
        System.out.println("Kth Large: " + KthLarge.peek().Path + " (" + KthLarge.poll().Weight + ")");
    }

    private static void AddEdge(ArrayList<ArrayList<Edge>> L, int u, int v, int w){
        L.get(u).add(new Edge(u, v, w));
        L.get(v).add(new Edge(v, u, w));
    }
}