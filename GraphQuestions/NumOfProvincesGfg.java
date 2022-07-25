import java.util.ArrayList;
// import java.util.Arrays;

public class NumOfProvincesGfg {

    // https://practice.geeksforgeeks.org/problems/number-of-provinces/1
    // Expected Time Complexity: O(V2)
    // Expected Auxiliary Space: O(V)
    
    public static void main(String[] args) {
        int[][] Arr = {{1,0,1},{0,1,0},{1,0,1}};
        ArrayList<ArrayList<Integer>> L = new ArrayList<>();

        for(int i=0; i<Arr.length; i++){
            L.add(new ArrayList<>());
            for(int x: Arr[i]){
                L.get(i).add(x);
            }
        } System.out.println(ConnectedComponents(L));
        // System.out.println(L.toString()); 
    }

    private static void dfs(ArrayList<ArrayList<Integer>> L, boolean[] Arr, int Node) {
        if(Arr[Node]){
            return;
        } Arr[Node] = true;

        for(int i=0; i<L.get(Node).size(); i++){
            int E = L.get(Node).get(i);
            if((!Arr[i]) && (E == 1) && (Node != i)){
                dfs(L, Arr, i);
                // System.out.println((Node + 1) + " " + (i + 1));
            }
        }
    }

    private static int ConnectedComponents(ArrayList<ArrayList<Integer>> L) {
        if((L.size() <= 0) || (L == null)){
            return 0;
        } int count = 0; 
        boolean[] Arr = new boolean[L.size()];
        for(int i=0; i<L.size(); i++){
            if(!Arr[i]){
                dfs(L, Arr, i); count++;
                // System.out.println(Arrays.toString(Arr));
            }
        } return count;
    }
}
