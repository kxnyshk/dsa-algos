public class NumOfIslands {

    // https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1
    // https://leetcode.com/problems/number-of-islands/
    // Expected Time Complexity: O(n*m)
    // Expected Space Complexity: O(n*m)
    
    public static void main(String[] args) {
        char[][] Arr = {{'0','1'},{'1','0'},{'1','1'},{'1','0'}};
        System.out.println(countIslands(Arr));
    }

    private static void Recursive(char[][] Arr, boolean[][] Bool, int i, int j) {
        if((i < 0) || (j < 0) || (i >= Arr.length) || (j >= Arr[0].length) || Bool[i][j] || (Arr[i][j] == '0')){
            return;
        } Bool[i][j] = true;

        Recursive(Arr, Bool, (i-1), (j-1)); Recursive(Arr, Bool, (i-1), j);
        Recursive(Arr, Bool, (i-1), (j+1)); Recursive(Arr, Bool, i, (j-1));
        Recursive(Arr, Bool, i, (j+1)); Recursive(Arr, Bool, (i+1), (j-1));
        Recursive(Arr, Bool, (i+1), j); Recursive(Arr, Bool, (i+1), (j+1));
    }

    private static int countIslands(char[][] Arr) {
        if((Arr == null) || (Arr.length <= 0)){
            return 0;
        } int count = 0;

        boolean[][] Bool = new boolean[Arr.length][Arr[0].length];
        for(int i=0; i<Arr.length; i++){
            for(int j=0; j<Arr[0].length; j++){
                if((!Bool[i][j]) && (Arr[i][j] == '1')){
                    Recursive(Arr, Bool, i, j); count++;
                }
            }
        } return count;
    }
}
