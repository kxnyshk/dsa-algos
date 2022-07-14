public class countIslands {
    
    public static void main(String[] args) {
        int[][] Arr =  {{0,0,1,1,1,1,1,1},
                        {0,0,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,0},
                        {1,1,0,0,0,1,1,0},
                        {1,1,1,1,0,1,1,0},};
        System.out.println(IslandCount(Arr));
    }

    private static void Recursive(int[][] Arr, int i, int j, boolean[][] vizArray){
        if((i<0) || (j<0) || (i>=Arr.length) || (j>=Arr[0].length) || (Arr[i][j] == 1) || (vizArray[i][j])){
            return;
        } vizArray[i][j] = true;

        Recursive(Arr, (i-1), j, vizArray);
        Recursive(Arr, i, (j+1), vizArray);
        Recursive(Arr, (i+1), j, vizArray);
        Recursive(Arr, i, (j-1), vizArray);
    }

    private static int IslandCount(int[][] Arr){
        if((Arr == null) || (Arr.length <= 0)){
            return 0;
        } int count  = 0;

        boolean[][] vizArray = new boolean[Arr.length][Arr[0].length];
        for(int i=0; i<Arr.length; i++){
            for(int j=0; j<Arr[0].length; j++){
                if((Arr[i][j] == 0) && (!vizArray[i][j])){
                    Recursive(Arr, i, j, vizArray); count++;
                }
            }
        } return count;
    }
}
