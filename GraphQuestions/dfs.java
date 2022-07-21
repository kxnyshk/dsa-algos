import java.util.ArrayList;

public class dfs{

    // https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/0
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
        System.out.println(DepthFirst(L, V).toString());
    }

    private static int Level = 0;

    private static ArrayList<Integer> Recursive(ArrayList<ArrayList<Integer>> L, int V, boolean[] Arr, ArrayList<Integer> AL, int Node) {
        Arr[Node] = true; AL.add(Node); Level++;
        if(Level == V){
            return AL;
        } 

        for(int E: L.get(Node)){
            if(!Arr[E]){
                Recursive(L, V, Arr, AL, E);
            }
        } return AL;
    }

    private static ArrayList<Integer> DepthFirst(ArrayList<ArrayList<Integer>> L, int V) {
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