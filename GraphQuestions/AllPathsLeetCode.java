import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPathsLeetCode {

    // https://leetcode.com/problems/all-paths-from-source-to-target/
    
    public static void main(String[] args) {
        int[][] graph = {{4,3,11,5,7,8,10,2,1,6},{2,9,3,11,10,6,7,4,5},{10,7,9,4,3,6,11,5},{9,4,11,6,8,10,7,5},{5,7,6,9,8,11,10},{8,7,11,9,10,6},{10,7,11,9,8},{9,10,11,8},{10,9},{11,10},{11},{}};
        System.out.println(AllPaths(graph).toString());
    }

    private static List<List<Integer>> L = new ArrayList<>();

    private static List<List<Integer>> dfs(int[][] graph, boolean[] Arr, int Source, int Destination, String Path) {
        if(Source == Destination){
            addPath(Path, L); return L;
        } Arr[Source] = true;

        for(int x: graph[Source]){
            if(!Arr[x]){
                dfs(graph, Arr, x, Destination, (Path + " " + x));
            }
        } Arr[Source] = false; return L;
    }

    private static void addPath(String Path, List<List<Integer>> L) {
        String[] Arr = Path.split(" ");
        List<String> StrL = Arrays.asList(Arr);

        List<Integer> IntL = new ArrayList<>();
        for(String s: StrL){
            IntL.add(Integer.valueOf(s));
        } L.add(IntL);
    }

    private static List<List<Integer>> AllPaths(int[][] graph) {
        List<Integer> tempL = new ArrayList<>(); tempL.add(0);
        if((graph == null) || (graph.length < 2)){
            return L;
        } boolean[] Arr = new boolean[graph.length]; L.clear();
        return dfs(graph, Arr, 0, (graph.length - 1), "0");
    }
}