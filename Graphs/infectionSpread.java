import java.util.ArrayDeque;
import java.util.ArrayList;

public class infectionSpread {
    
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
        AddEdge(L, 0, 3, 10);
        AddEdge(L, 1, 2, 10);
        AddEdge(L, 2, 3, 10);
        AddEdge(L, 3, 4, 10);
        AddEdge(L, 4, 5, 10);
        AddEdge(L, 4, 6, 10);
        AddEdge(L, 5, 6, 10);
        getTime(L, V);
    }

    private static class Pair{
        int Node, Time;
        Pair(int Node, int Time){
            this.Node = Node;
            this.Time = Time;
        }
    }
    
    private static int bfs(ArrayList<ArrayList<Edge>> L, int V, boolean[] Arr, int Node, int Time) {
        ArrayDeque<Pair> Q = new ArrayDeque<>();
        String Path = Integer.toString(Node);
        
        int NodeCount = 0;
        int TempTime = 1;

        Q.add(new Pair(Node, TempTime));
        Arr[Node] = true; NodeCount++;

        while(TempTime <= Time){
            Pair TempPair = Q.poll();

            if(TempPair.Time == Time){
                System.out.print(Path + " ");
                return NodeCount;
            }

            for(Edge E: L.get(TempPair.Node)){
                if(!Arr[E.v]){
                    Q.add(new Pair(E.v, (TempPair.Time + 1)));
                    Arr[E.v] = true; Path += " -> "; Path += E.v;
                    TempTime = (TempPair.Time + 1); NodeCount++;
                }
            }
        } return -1;
    }

    private static void getTime(ArrayList<ArrayList<Edge>> L, int V) {
        int Node = 6; int Time = 3;
        boolean[] Arr = new boolean[V];
        System.out.println("(" + bfs(L, V, Arr, Node, Time) + ")");
    }

    private static void AddEdge(ArrayList<ArrayList<Edge>> L, int u, int v, int w){
        L.get(u).add(new Edge(u, v, w));
        L.get(v).add(new Edge(v, u, w));
    }
}
