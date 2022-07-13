import java.util.ArrayList;

public class allDFS {

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
        AddEdge(L, 0, 3, 40);
        AddEdge(L, 1, 2, 10);
        AddEdge(L, 2, 3, 10);
        AddEdge(L, 3, 4, 2);
        AddEdge(L, 4, 5, 3);
        AddEdge(L, 4, 6, 8);
        AddEdge(L, 5, 6, 3);
        dfsPaths(L, V);
    }

    private static int Weight = 0;

    private static void Recursive(ArrayList<ArrayList<Edge>> L, int Source, int Destination, boolean[] Arr, String Path, int W){
        if(Source == Destination){
            System.out.println(Path + " (" + W + ")"); 
            return;
        } Arr[Source] = true;

        for(Edge E : L.get(Source)){
            if(!Arr[E.v]){
                Recursive(L, E.v, Destination, Arr, (Path + " -> " + E.v), (W + E.w));
            }
        } Arr[Source] = false;
    }

    private static void dfsPaths(ArrayList<ArrayList<Edge>> L, int V){
        boolean[] Arr = new boolean[V]; int S = 0; int D = (V - 1); 
        String Path = Integer.toString(S); Recursive(L, S, D, Arr, Path, Weight);
    }

    private static void AddEdge(ArrayList<ArrayList<Edge>> L, int u, int v, int w){
        L.get(u).add(new Edge(u, v, w));
        L.get(v).add(new Edge(v, u, w));
    }
}