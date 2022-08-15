public class IncPathDFSLeetCode {

    // https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
    // using DFS -> 10 ms
    
    public static void main(String[] args) {
        int[][] matrix = {{7,6,1,1},{2,7,6,0},{1,3,5,1},{6,6,3,2}};
        System.out.println(LongestPath(matrix));
    }

    private static int LongestPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int path = -1;

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                dp[i][j] = dfs(matrix, dp, i, j, -1);
                path = Math.max(path, dp[i][j]);
                System.out.println(i + " " + j + " " + dp[i][j]);
            }
        } return path;
    }

    private static int dfs(int[][] matrix, int[][] dp, int i, int j, int prev) {
        if((i <  0) || (j < 0) || (i >= matrix.length) || (j >= matrix[0].length) || (matrix[i][j] <= prev)){
            return 0;
        } if(dp[i][j] != 0){
            return dp[i][j];
        }

        int path = 1;
        path = Math.max(path, (1 + (dfs(matrix, dp, (i - 1), j, matrix[i][j]))));
        path = Math.max(path, (1 + (dfs(matrix, dp, (i + 1), j, matrix[i][j]))));
        path = Math.max(path, (1 + (dfs(matrix, dp, i, (j - 1), matrix[i][j]))));
        path = Math.max(path, (1 + (dfs(matrix, dp, i, (j + 1), matrix[i][j]))));
        return dp[i][j] = path;
    }
}