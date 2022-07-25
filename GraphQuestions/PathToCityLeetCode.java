import java.util.ArrayList;

public class PathToCityLeetCode {

    // https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/

    public static void main(String[] args) {
        int n = 3; int[][] connections = {{1,2},{2,0}};
        ArrayList<ArrayList<Integer>> L = createGraph(connections, n);
        System.out.println(MinEdges(L, n));
    }

    private static int dfs(ArrayList<ArrayList<Integer>> L, int n, boolean[] Arr, int Node) {
        Arr[Node] = true;
        int Edges = 0;

        for(int E: L.get(Node)){
            if(!Arr[Math.abs(E)]){
                Edges += ((E > 0) ? 1 : 0) + dfs(L, n, Arr, Math.abs(E));
            }
        } return Edges;
    }

    private static int MinEdges(ArrayList<ArrayList<Integer>> L, int n) {
        boolean[] Arr = new boolean[n];
        return dfs(L, n, Arr, 0);
    }

    private static ArrayList<ArrayList<Integer>> createGraph(int[][] connections, int n) {
        ArrayList<ArrayList<Integer>> L = new ArrayList<>();
        for(int i=0; i<n; i++){
            L.add(new ArrayList<Integer>());
        }
        for(int i=0; i<connections.length; i++){
            int u = connections[i][0];
            int v = connections[i][1];
            L.get(u).add(v);
            L.get(v).add((0-u));
        } return L;
    }
}