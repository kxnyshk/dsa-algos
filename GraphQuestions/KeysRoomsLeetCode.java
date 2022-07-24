import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class KeysRoomsLeetCode {

    // https://leetcode.com/problems/keys-and-rooms/
        
    public static void main(String[] args) {
        int[][] Arr = {{1,3},{3,0,1},{2},{0}};
        List<List<Integer>> L = new ArrayList<>();
        
        for(int i=0; i<Arr.length; i++){
            L.add(new ArrayList<>());
            for(int x: Arr[i]){
                L.get(i).add(x);
            }
        } System.out.println(Solve(L));
        // System.out.println(L.toString());
    }
    
    private static boolean bfs(List<List<Integer>> L, boolean[] Arr, int Node) {
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        HashSet<Integer> Set = new HashSet<>();
        Q.add(Node);
        
        while(!Q.isEmpty()){
            int T = Q.poll();
            if(Arr[T]){
                continue;
            } Arr[T] = true; Set.add(T);

            for(int E: L.get(T)){
                if(!Arr[E]){
                    Q.add(E);
                }
            }
        } return (Set.size() == L.size());
        // System.out.println(Arrays.toString(Arr)); 
        // System.out.println(Set.toString()); 
    }

    private static boolean Solve(List<List<Integer>> L) {
        boolean[] Arr = new boolean[L.size()];
        return bfs(L, Arr, 0);
    }
}