import java.util.ArrayList;
import java.util.HashSet;

public class HamiltonianPathOrCycle {

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
        AddEdge(L, 2, 5, 10);
        AddEdge(L, 3, 4, 10);
        AddEdge(L, 4, 5, 10);
        AddEdge(L, 4, 6, 10);
        AddEdge(L, 5, 6, 10);
        Hamiltonian(L, V);
    }

    private static void Recursive(ArrayList<ArrayList<Edge>> L, int Source, int V, HashSet<Integer> Set, String Path, int RootNode) {
        if(Set.size() == (V - 1)){
            System.out.print(Path); 
            boolean flag = false;
            for(Edge E: L.get(Source)){
                if(E.v == RootNode){
                    System.out.println(" -> * (Cycle)"); 
                    flag = true; break;
                }
            } if(!flag){
                System.err.println(" -> . (Path)");
            }  return;
        } Set.add(Source);

        for(Edge E : L.get(Source)){
            if(!Set.contains(E.v)){
                Recursive(L, E.v, V, Set, (Path + " -> " + E.v), RootNode);
            }
        } Set.remove(Source);
    }

    private static void Hamiltonian(ArrayList<ArrayList<Edge>> L, int V){
        HashSet<Integer> Set = new HashSet<>(); int S = 0;
        String Path = Integer.toString(S); Recursive(L, S, V, Set, Path, S);
    }

    private static void AddEdge(ArrayList<ArrayList<Edge>> L, int u, int v, int w){
        L.get(u).add(new Edge(u, v, w));
        L.get(v).add(new Edge(v, u, w));
    }
}
