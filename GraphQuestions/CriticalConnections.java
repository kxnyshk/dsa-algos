import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnections {

    // https://leetcode.com/problems/critical-connections-in-a-network/
    // LeetCode solution -> class Solution {..}

    class Solution {

        private List<List<Integer>> Res = new ArrayList<>();
        private List<List<Integer>> L = new ArrayList<>();
        
        private boolean[] Arr;
        private int[] Lev, Low;
        private int depth = 0;
        
        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
            Arr = new boolean[n]; Lev = new int[n]; Low = new int[n];
            buildGraph(n, connections); 
            dfs(0, -1); return Res;
            
        }
        
        void dfs(int Node, int Parent){
            Arr[Node] = true;
            Lev[Node] = Low[Node] = depth++;
            
            for(int v: L.get(Node)){
                if(v == Parent){
                    continue;
                } if(Arr[v]){
                    Low[Node] = Math.min(Low[Node], Low[v]);
                } else{
                    dfs(v, Node);
                    Low[Node] = Math.min(Low[Node], Low[v]);
                    if(Lev[Node] < Low[v]){
                        Res.add(Arrays.asList(Node, v));
                    }
                }
            }
        }
        
        void buildGraph(int n, List<List<Integer>> connections){
            for(int i=0; i<n; i++){
                L.add(new ArrayList<>());
            }
            for(List<Integer> tempL: connections){
                L.get(tempL.get(0)).add(tempL.get(1));
                L.get(tempL.get(1)).add(tempL.get(0));
            }
        }
    }   
}