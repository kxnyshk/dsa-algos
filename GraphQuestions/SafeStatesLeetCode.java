import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SafeStatesLeetCode {

    // https://leetcode.com/problems/find-eventual-safe-states/

    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(SafeStates(graph).toString());
    }

    private static Map<Integer, Boolean> Map = new HashMap<Integer, Boolean>();

    private static List<Integer> SafeStates(int[][] graph) {
        List<Integer> L = new ArrayList<>();
        Map.clear(); L.clear();

        for(int i=0; i<graph.length; i++){
            if(dfs(graph, i)){
                L.add(i);
            }
        } return L;
    }

    private static boolean dfs(int[][] graph, int Node) {
        if(Map.containsKey(Node)){
            return Map.get(Node);
        } if(graph[Node].length == 0){
            Map.put(Node, true); return true;
        }

        Map.put(Node, false);
        for(int i=0; i<graph[Node].length; i++){
            if(!dfs(graph, graph[Node][i])){
                return false;
            }
        } Map.put(Node, true); return true;
    }
}