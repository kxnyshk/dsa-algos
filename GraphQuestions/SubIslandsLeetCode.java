public class SubIslandsLeetCode {

    // https://leetcode.com/problems/count-sub-islands/
    
    public static void main(String[] args) {
        int[][] grid1 = {{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
        int[][] grid2 = {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
        System.out.println(SubIslands(grid1, grid2));
    }

    private static boolean flag = false;

    private static void Recursive(int[][] grid1, int[][] grid2, boolean[][] Arr, int i, int j) {
        if((i < 0) || (j < 0) || (i >= grid2.length) || (j >= grid2[0].length) || Arr[i][j] || (grid2[i][j] != 1)){
            return;
        } if(grid1[i][j] != 1){
            flag = true; return;
        } Arr[i][j] = true;
        Recursive(grid1, grid2, Arr, i, (j-1)); Recursive(grid1, grid2, Arr, (i-1), j);
        Recursive(grid1, grid2, Arr, i, (j+1)); Recursive(grid1, grid2, Arr, (i+1), j);
    }

    private static int SubIslands(int[][] grid1, int[][] grid2) {
        int count = 0; boolean[][] Arr = new boolean[grid2.length][grid2[0].length];
        for(int i=0; i<grid2.length; i++){
            for(int j=0; j<grid2[0].length; j++){
                if((!Arr[i][j]) && (grid2[i][j] == 1)){
                    Recursive(grid1, grid2, Arr, i, j);
                    if(!flag){
                        count++;
                    } flag = false;
                }
            }
        } return count;
    }
}