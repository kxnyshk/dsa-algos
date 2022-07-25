import java.util.ArrayDeque;
import java.util.ArrayList;

public class bfs{

    // https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
    // Expected Time Complexity: O(V + E)
    // Expected Auxiliary Space: O(V)

    public static void main(String[] args) {
        int V = 8;
        ArrayList<ArrayList<Integer>> L = new ArrayList<>();
        for(int i=0; i<V; i++){
            L.add(new ArrayList<>());
        }

        AddEdge(L, 0, 4);
        AddEdge(L, 0, 6);
        AddEdge(L, 0, 7);
        AddEdge(L, 1, 6);
        AddEdge(L, 2, 5);
        AddEdge(L, 3, 6);
        AddEdge(L, 5, 6);
        System.out.println(BreadthFirst(L, V).toString());
    }

    private static ArrayList<Integer> Recursive(ArrayList<ArrayList<Integer>> L, int V, boolean[] Arr, ArrayList<Integer> AL, int Node) {
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        Q.add(Node);

        while(!Q.isEmpty()){
            int T = Q.poll();
            if(Arr[T]){
                continue;
            } Arr[T] = true; AL.add(T);

            for(int E: L.get(T)){
                if(!Arr[E]){
                    Q.add(E);
                }
            }
        } return AL;
    }

    private static ArrayList<Integer> BreadthFirst(ArrayList<ArrayList<Integer>> L, int V) {
        ArrayList<Integer> AL = new ArrayList<>();
        if((V <= 0) || (L.size() <= 0) || (L == null)){
            return AL;
        } boolean[] Arr = new boolean[V];
        return Recursive(L, V, Arr, AL, 0);
    }

    private static void AddEdge(ArrayList<ArrayList<Integer>> L, int u, int v){
        L.get(u).add(v);
        L.get(v).add(u);
    }
}