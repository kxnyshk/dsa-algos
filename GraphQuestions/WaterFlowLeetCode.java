import java.util.ArrayList;
import java.util.List;

public class WaterFlowLeetCode {

    // https://leetcode.com/problems/pacific-atlantic-water-flow/
    
    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(WaterFlow(heights).toString());
    }

    private static boolean Pfc = false;
    private static boolean Atc = false;

    private static void Recursive(int[][] heights, boolean[][] Arr, int i0, int j0, int i1, int j1) {
        if((i1 < 0) || (j1 < 0) || (i1 >= heights.length) || (j1 >= heights[0].length) || Arr[i1][j1]){
            return;
        } if(heights[i1][j1] > heights[i0][j0]){
            return;
        } if((i1 == 0) || (j1 == 0)){
            Pfc = true;
        } if((i1 == (heights.length - 1)) || (j1 == (heights[0].length - 1))){
            Atc = true;
        } Arr[i1][j1] = true;
        Recursive(heights, Arr, i1, j1, i1, (j1-1)); Recursive(heights, Arr, i1, j1, (i1-1), j1);
        Recursive(heights, Arr, i1, j1, i1, (j1+1)); Recursive(heights, Arr, i1, j1, (i1+1), j1);
    }

    private static List<List<Integer>> WaterFlow(int[][] heights) {
        List<List<Integer>> L = new ArrayList<>();
        
        for(int i=0; i<heights.length; i++){
            for(int j=0; j<heights[0].length; j++){
                boolean[][] Arr = new boolean[heights.length][heights[0].length];
                Recursive(heights, Arr, i, j, i, j);
                if(Pfc && Atc){
                    List<Integer> tempL = new ArrayList<>();
                    tempL.add(i); tempL.add(j);
                    L.add(tempL);
                } Pfc = false; Atc = false;
            }
        } return L;
    }
}