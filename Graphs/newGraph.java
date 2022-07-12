import java.util.ArrayList;

public class newGraph {

    private static class Edge{
        int u, v, w;
        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    
    public static void main(String[] args) {
        
        int V = 5;
        ArrayList<ArrayList<Edge>> L = new ArrayList<>();
        for(int i=0; i<V; i++){
            L.add(new ArrayList<Edge>());
        }

        AddEdge(L, 0, 1, 10);
        AddEdge(L, 0, 4, 15);
        AddEdge(L, 1, 2, 20);
        AddEdge(L, 1, 3, 25);
        AddEdge(L, 1, 4, 30);
        AddEdge(L, 2, 3, 35);
        AddEdge(L, 3, 4, 40);
        PrintGraph(L, V);
    }

    private static void AddEdge(ArrayList<ArrayList<Edge>> L, int u, int v, int w){
        L.get(u).add(new Edge(u, v, w));
        L.get(v).add(new Edge(v, u, w));
        System.out.println("Adding Edge: " + u + " -> " + v + " (" + w + ")");
    }

    private static void PrintGraph(ArrayList<ArrayList<Edge>> L, int V){
        System.out.println();
        for(int i=0; i<V; i++){
            for(int j=0; j<L.get(i).size(); j++){
                System.out.println(L.get(i).get(j).u + " -> " + L.get(i).get(j).v + " (" + L.get(i).get(j).w + ")");
            } System.out.println();
        }
    }
}