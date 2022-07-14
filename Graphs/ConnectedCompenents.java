import java.util.ArrayList;

public class ConnectedCompenents {

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
        AddEdge(L, 2, 3, 10);
        AddEdge(L, 4, 5, 10);
        AddEdge(L, 4, 6, 10);
        AddEdge(L, 5, 6, 10);
        AllConnectedComponents(L, V);
    }

    private static ArrayList<Integer> AddComponent(ArrayList<ArrayList<Edge>> L, int V, int Node, boolean[] Arr, ArrayList<Integer> Components) {
        if(Arr[Node]){return Components;} 
        Components.add(Node); 
        Arr[Node] = true;
        
        for(Edge E: L.get(Node)){
            if(!Arr[E.v]){
                AddComponent(L, V, E.v, Arr, Components);
            }
        } return Components;
    }

    private static void AllConnectedComponents(ArrayList<ArrayList<Edge>> L, int V) {
        ArrayList<ArrayList<Integer>> ConnectedComponents = new ArrayList<>();
        boolean[] Arr = new boolean[V];
        for(int i=0; i<V; i++){
            ArrayList<Integer> Components = new ArrayList<>();
            Components = AddComponent(L, V, i, Arr, Components);
            if(!Components.isEmpty()){
                ConnectedComponents.add(Components);
            }
        } System.out.println(ConnectedComponents.toString());
    }

    private static void AddEdge(ArrayList<ArrayList<Edge>> L, int u, int v, int w){
        L.get(u).add(new Edge(u, v, w));
        L.get(v).add(new Edge(v, u, w));
    }
}