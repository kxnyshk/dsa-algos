import java.util.HashMap;
import java.util.Map;

public class MinHammingDistance {

    // https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/
    // LeetCode solution -> class Solution {..}
    
    class Solution {
    
        Map<Integer, Map<Integer, Integer>> Map = new HashMap<>();
        int HamDistance = 0;
        int[] Roots;
        int[] Par; 
        
        public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
            // initialize the arrays
            Roots = new int[source.length];
            Par = new int[source.length];
            
            // build the Parent Array
            for(int i=0; i<Par.length; i++){
                Par[i] = i;
            }
            
            // Unionize the allowed swaps given
            for(int[] swap: allowedSwaps){
                union(find(swap[0]), find(swap[1]));
            }
            
            // build a HashMap defining the relationship of 
            // Root Nodes -> their Children Nodes, their Frequency
            for(int i=0; i<source.length; i++){
                int r = find(i); Roots[i] = r; 
                int v = source[i];
                
                if(!Map.containsKey(r)){
                    Map.put(r, new HashMap<>());
                } Map<Integer, Integer> tempMap = Map.get(r);
                tempMap.put(v, (tempMap.getOrDefault(v, 0) + 1));
            }
            
            // check conditions for Hamming distances
            for(int i=0; i<target.length; i++){
                int r = Roots[i]; int v = target[i]; 
                Map<Integer, Integer> tempMap = Map.get(r);
                
                if(tempMap.getOrDefault(v, 0) == 0){
                    HamDistance++;
                } else{
                    tempMap.put(v, (tempMap.get(v) - 1));
                }
            } 
            
            return HamDistance;
        }
        
        int find(int Node){
            if(Node == Par[Node]){
                return Node;
            } return Par[Node] = find(Par[Node]);
        }
        
        void union(int N1, int N2){
            if(N1 != N2){
                Par[N2] = N1;
            }
        }
    }
}