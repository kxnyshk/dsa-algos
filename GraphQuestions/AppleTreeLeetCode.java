import java.util.ArrayList;

public class AppleTreeLeetCode {

    // https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/

    public static void main(String[] args) {
        int n = 7; int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        boolean[] hasApple = {false,false,true,false,false,true,false};
        
        ArrayList<ArrayList<Integer>> L = createGraph(edges, n);
        System.out.println(MinTime(L, n, hasApple));
    }

    private static int dfs(ArrayList<ArrayList<Integer>> L, int n, boolean[] hasApple, boolean[] Arr, int Node) {
        Arr[Node] = true;
        int T = 0;    
        
        for(int E: L.get(Node)){
            if(!Arr[E]){
                T += dfs(L, n, hasApple, Arr, E);
            }
        } if((Node != 0) && ((hasApple[Node]) || (T > 0))){
            System.out.println(Node);
            T+= 2;
        } return T;
    }

    private static int MinTime(ArrayList<ArrayList<Integer>> L, int n, boolean[] hasApple) {
        if((L.size() <= 0) || (L == null) || (n <= 1) || (hasApple.length <= 0) || (hasApple == null)){
            return 0;
        }
        boolean[] Arr = new boolean[n];
        return dfs(L, n, hasApple, Arr, 0);
    }

    private static ArrayList<ArrayList<Integer>> createGraph(int[][] edges, int n) {
        ArrayList<ArrayList<Integer>> L = new ArrayList<>();
        for(int i=0; i<n; i++){
            L.add(new ArrayList<Integer>());
        }
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            L.get(u).add(v);
            L.get(v).add(u);
        } return L;
    }
}
