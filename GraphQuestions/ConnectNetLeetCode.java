import java.util.ArrayList;

public class ConnectNetLeetCode {

    // https://leetcode.com/problems/number-of-operations-to-make-network-connected/
    
    public static void main(String[] args) {
        int n = 4; int[][] Arr = {{0,1},{0,2},{1,2}};
        ArrayList<ArrayList<Integer>> L = new ArrayList<>();
        
        int i=0; while(i < n){
            L.add(new ArrayList<>()); i++;
        } int j=0; while(j < Arr.length){
            int u = Arr[j][0], v = Arr[j][1];
            L.get(u).add(v); L.get(v).add(u); j++;
        } System.out.println(L.toString());
        
        if((L == null) || (L.size() < 0) || (n <= 0) || (L.size() < (n - 1))){
            System.out.println(-1);
        } else {
            System.out.println(ConnectedComponents(L, n));
        }
    }

    private static void dfs(ArrayList<ArrayList<Integer>> L, boolean[] Arr, int Node) {
        if(Arr[Node]){
            return;
        } Arr[Node] = true;

        for(int E: L.get(Node)){
            if(!Arr[E]){
                dfs(L, Arr, E);
            }
        }
    }

    private static int ConnectedComponents(ArrayList<ArrayList<Integer>> L, int n) {
        int count = 0; boolean[] Arr = new boolean[n];

        for(int i=0; i<n; i++){
            if(!Arr[i]){
                dfs(L, Arr, i); count++;
            }
        } return (count - 1);
    }
}
