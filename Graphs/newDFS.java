import java.util.ArrayList;

public class newDFS {

    private static class Edge{
        int u, v, w;
        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    } 
    
    public static void main(String[] args) {
        int V = 8;
        ArrayList<ArrayList<Edge>> L = new ArrayList<>();
        for(int i=0; i<V; i++){
            L.add(new ArrayList<Edge>());
        }
        
        AddEdge(L, 0, 1, 10);
        AddEdge(L, 0, 2, 10);
        AddEdge(L, 0, 3, 10);
        AddEdge(L, 1, 4, 10);
        AddEdge(L, 2, 5, 10);
        AddEdge(L, 3, 6, 10);
        AddEdge(L, 4, 7, 10);
        AddEdge(L, 5, 7, 10);
        AddEdge(L, 6, 7, 10);
        dfsTraversal(L, V);
    }
    
    private static void Recursive(ArrayList<ArrayList<Edge>> L, int V, int Source, boolean[] Arr){
        if(Level >= V){
            System.out.println(); return; 
        } Arr[Source] = true;
        
        for(Edge E : L.get(Source)){
            if((!Arr[E.v]) && (Level < V)){
                System.out.print(" -> " + E.v); ++Level;
                Recursive(L, V, E.v, Arr);
            }
        }
    }
    
    private static int Level = 1;
    private static void dfsTraversal(ArrayList<ArrayList<Edge>> L, int V){
        for(int i=0; i<V; i++){
            boolean[] Arr = new boolean[V];
            System.out.print(i);
            Recursive(L, V, i, Arr); Level = 1;
        }
    }

    private static void AddEdge(ArrayList<ArrayList<Edge>> L, int u, int v, int w){
        L.get(u).add(new Edge(u, v, w));
        L.get(v).add(new Edge(v, u, w));
    }
}