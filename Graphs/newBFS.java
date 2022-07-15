import java.util.ArrayDeque;
import java.util.ArrayList;

public class newBFS {

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
        bfsTraversal(L, V);
    }

    private static void bfs(ArrayList<ArrayList<Edge>> L, int V, int Source, boolean[] Arr){
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        
        Q.add(Source); Arr[Source] = true;
        System.out.print(Source);

        while(!Q.isEmpty()){
            int Temp = Q.poll();
            if(Temp != Source){
                System.out.print(" -> " + Temp);
            }

            for(Edge E: L.get(Temp)){
                if(!Arr[E.v]){
                    Q.add(E.v); Arr[E.v] = true;
                }
            }
        }
    }

    private static void bfsTraversal(ArrayList<ArrayList<Edge>> L, int V){
        for(int i=0; i<V; i++){
            boolean[] Arr = new boolean[V];
            bfs(L, V, i, Arr); System.out.println();
        }
    }

    private static void AddEdge(ArrayList<ArrayList<Edge>> L, int u, int v, int w){
        L.get(u).add(new Edge(u, v, w));
        L.get(v).add(new Edge(v, u, w));
    }
}
