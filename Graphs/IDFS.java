import java.util.ArrayList;
import java.util.Stack;


public class IDFS {

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
        AddEdge(L, 0, 3, 25);
        AddEdge(L, 1, 2, 10);
        AddEdge(L, 2, 3, 10);
        AddEdge(L, 3, 4, 2);
        AddEdge(L, 4, 5, 3);
        AddEdge(L, 4, 6, 8);
        AddEdge(L, 5, 6, 3);
        IterativeDepth(L, V);
    }

    private static void bfs(ArrayList<ArrayList<Edge>> L, int V, boolean[] Arr, Stack<Integer> St, int Source, int Destination) {
        String Path = Integer.toString(Source);
        St.add(Source);

        while(!St.isEmpty()){
            int Temp = St.pop();
            if(Temp != Source){
                Path += " -> "; Path += Temp;
            } if(Temp == Destination){
                System.out.println(Path); return;
            } Arr[Temp] = true;

            for(Edge E: L.get(Temp)){
                if(!Arr[E.v]){
                    St.add(E.v);
                }
            }
        }
    }

    private static void IterativeDepth(ArrayList<ArrayList<Edge>> L, int V) {
        boolean[] Arr = new boolean[V];
        Stack<Integer> St = new Stack<>();
        int S = 0; int D = 6;
        bfs(L, V, Arr, St, S, D);
    }

    private static void AddEdge(ArrayList<ArrayList<Edge>> L, int u, int v, int w){
        L.get(u).add(new Edge(u, v, w));
        L.get(u).add(new Edge(v, u, w));
    }
}
