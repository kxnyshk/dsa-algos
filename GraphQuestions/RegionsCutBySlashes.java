public class RegionsCutBySlashes {
    
    // https://leetcode.com/problems/regions-cut-by-slashes/
    // LeetCode solution -> class Solution {..}

    class Solution {
    
        int[][] graph;
        int Count = 0;
        
        public int regionsBySlashes(String[] grid) {
            graph = new int[grid.length*3][grid[0].length()*3];
            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[0].length(); j++){
                    if(grid[i].charAt(j) == '/'){
                        graph[i*3][j*3 + 2] = 1;
                        graph[i*3 + 1][j*3 + 1] = 1;
                        graph[i*3 + 2][j*3] = 1;
                    } if(grid[i].charAt(j) == '\\'){
                        graph[i*3][j * 3] = 1;
                        graph[i*3 + 1][j*3 + 1] = 1;
                        graph[i*3 + 2][j*3 + 2] = 1;
                    }
                }
            }
            for(int i=0; i<graph.length; i++){
                for(int j=0; j<graph[i].length; j++){
                    if(graph[i][j] == 0){
                        dfs(graph, i, j); Count++;
                    }
                }
            } return Count;
            
        }
        
        void dfs(int[][] graph, int i, int j){
            if((i<0) || (j<0) || (i>=graph.length) || (j>=graph[0].length) || (graph[i][j] == 1)){
                return;
            } graph[i][j] = 1;
            dfs(graph, (i-1), j); dfs(graph, i, (j-1));
            dfs(graph, (i+1), j); dfs(graph, i, (j+1));
        }
    }
}