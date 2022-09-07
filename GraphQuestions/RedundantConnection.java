public class RedundantConnection{

    // https://leetcode.com/problems/redundant-connection/
    // LeetCode solution -> class Solution {..}

    class Solution {
        
        int[] Par;
        public int[] findRedundantConnection(int[][] edges) {
            Par = new int[edges.length + 1];
            for(int i=0; i<Par.length; i++){
                Par[i] = i;
            }
            
            for(int[] E: edges){
                int f1 = find(E[0]); int f2 = find(E[1]);
                if(f1 == f2){
                    return E;
                } union(f1, f2);
            } return null;
        }
        
        int find(int Node){
            if(Node == Par[Node]){
                return Node;
            } return Par[Node] = find(Par[Node]);
        }
        
        void union(int N1, int N2){
            Par[N2] = N1;
        }
    }
}