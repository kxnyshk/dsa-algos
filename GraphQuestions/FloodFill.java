import java.util.Arrays;

public class FloodFill {

    // https://leetcode.com/problems/flood-fill/
    
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;
        System.out.println(Arrays.deepToString(Fill(image, sr, sc, color)));
    }

    private static void dfs(int[][] image, int sr, int sc, int color, boolean[][] Arr, int og) {
        if((sr < 0) || (sc < 0) || (sr >= image.length) || (sc >= image[0].length) || Arr[sr][sc] || (image[sr][sc] != og)){
            return;
        } image[sr][sc] = color; Arr[sr][sc] = true;

        dfs(image, sr, (sc-1), color, Arr, og);
        dfs(image, (sr-1), sc, color, Arr, og);
        dfs(image, sr, (sc+1), color, Arr, og);
        dfs(image, (sr+1), sc, color, Arr, og);
    }

    private static int[][] Fill(int[][] image, int sr, int sc, int color) {
        boolean[][] Arr = new boolean[image.length][image[0].length];
        int og = image[sr][sc]; dfs(image, sr, sc, color, Arr, og);
        return image;
    }
}