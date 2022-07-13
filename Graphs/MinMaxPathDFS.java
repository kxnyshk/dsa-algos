import java.util.ArrayList;

public class MinMaxPathDFS {
    
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
        MinMaxPath(L, V);
    }

    private static int MinWeight = Integer.MAX_VALUE;
    private static int MaxWeight = Integer.MIN_VALUE;
    private static String MinPath = "";
    private static String MaxPath = "";

    private static void Recursive(ArrayList<ArrayList<Edge>> L, int Source, int Destination, boolean[] Arr, String Path, int Weight){
        if(Source == Destination){
            if(Weight < MinWeight){
                MinWeight = Weight; MinPath = Path;
            } if(Weight > MaxWeight){
                MaxWeight = Weight; MaxPath = Path;
            } return;
        } Arr[Source] = true;

        for(Edge E : L.get(Source)){
            if(!Arr[E.v]){
                Recursive(L, E.v, Destination, Arr, (Path + " -> " + E.v), (Weight + E.w));
            }
        } Arr[Source] = false;
    }

    private static void MinMaxPath(ArrayList<ArrayList<Edge>> L, int V){
        boolean[] Arr = new boolean[V]; int S = 0; int D = (V - 1); int W = 0;
        String Path = Integer.toString(S); Recursive(L, S, D, Arr, Path, W);
        System.out.println("Min Path: " + MinPath + " (" + MinWeight + ")");
        System.out.println("Max Path: " + MaxPath + " (" + MaxWeight + ")");
    }

    private static void AddEdge(ArrayList<ArrayList<Edge>> L, int u, int v, int w){
        L.get(u).add(new Edge(u, v, w));
        L.get(v).add(new Edge(v, u, w));
    }
}