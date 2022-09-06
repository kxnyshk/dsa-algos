import java.util.HashSet;
import java.util.Set;

public class NumOfProvinces {

    // https://leetcode.com/problems/number-of-provinces/
    // https://practice.geeksforgeeks.org/problems/number-of-provinces/1
    // LeetCode/Gfg solution -> class Solution {..}
    
    class Solution {

        public int findCircleNum(int[][] isConnected) {
            int Count = 0; Set.clear();
            
            for(int i=0; i<isConnected.length; i++){
                if(!Set.contains(i)){
                    Set.add(i);
                    dfs(isConnected, i); Count++;
                }
            } return Count;
        }
        
        private static Set<Integer> Set = new HashSet<>();
        
        private static void dfs(int[][] arr, int Node){
            for(int j=0; j<arr.length; j++){
                if((Node != j) && (arr[Node][j] == 1) && (!Set.contains(j))){
                    Set.add(j); dfs(arr, j);
                }
            }
        }
    }
}