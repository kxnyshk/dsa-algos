import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    
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
        AddEdge(L, 4, 3, 2);
        AddEdge(L, 4, 5, 3);
        AddEdge(L, 4, 6, 8);
        AddEdge(L, 5, 6, 3);
        SortTopological(L, V);
    }

    private static void dfs(ArrayList<ArrayList<Edge>> L, int V, boolean[] Arr, Stack<Integer> St, int Node) {
        Arr[Node] = true;
        for(Edge E: L.get(Node)){
            if(!Arr[E.v]){
                dfs(L, V, Arr, St, E.v);
            }
        } St.add(Node);
    }

    private static void SortTopological(ArrayList<ArrayList<Edge>> L, int V) {
        boolean[] Arr = new boolean[V];
        Stack<Integer> St = new Stack<>();
        for(int i=0; i<V; i++){
            if(!Arr[i]){
                dfs(L, V, Arr, St, i);
            }
        } while(!St.isEmpty()){
            System.out.print(St.pop() + " ");
        }
    }

    private static void AddEdge(ArrayList<ArrayList<Edge>> L, int u, int v, int w){
        L.get(u).add(new Edge(u, v, w));
    }
}
