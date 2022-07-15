import java.util.ArrayDeque;
import java.util.ArrayList;

public class isCyclic{

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
        AddEdge(L, 2, 3, 10);
        AddEdge(L, 4, 5, 10);
        AddEdge(L, 4, 6, 10);
        AddEdge(L, 5, 6, 10);
        AddEdge(L, 4, 7, 10);
        // AddEdge(L, 6, 7, 10);
        checkCycle(L, V);
    }

    private static void bfs(ArrayList<ArrayList<Edge>> L, int V, int Source, boolean[] Arr, String Path){
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        
        Q.add(Source);

        while(!Q.isEmpty()){
            int Temp = Q.poll();
            if(Arr[Temp]){
                System.out.println(Path);
            } if(Temp != Source){
                Path += " -> "; Path += Temp;
            } Arr[Temp] = true; 

            for(Edge E: L.get(Temp)){
                if(!Arr[E.v]){
                    Q.add(E.v);
                }
            }
        }
    }

    private static void checkCycle(ArrayList<ArrayList<Edge>> L, int V){
        boolean[] Arr = new boolean[V];
        for(int i=0; i<V; i++){
            String Path = Integer.toString(i);
            if(!Arr[i]){
                bfs(L, V, i, Arr, Path);
            }
        }
    }

    private static void AddEdge(ArrayList<ArrayList<Edge>> L, int u, int v, int w){
        L.get(u).add(new Edge(u, v, w));
        L.get(v).add(new Edge(v, u, w));
    }
}