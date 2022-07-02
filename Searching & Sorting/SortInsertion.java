import java.util.Arrays;

public class SortInsertion {

    // https://practice.geeksforgeeks.org/problems/insertion-sort/1/
    // find the right place towards start, shift, then insert.
    // TC : O(N^2)
    // SC : O(1)
    
    public static void main(String[] args) {
        
        int[] Arr = {8, 2, 4, 1, 3};
        System.out.println(Arrays.toString(InsertionSort(Arr)));
    }

    private static void Shift(int[] Arr, int start, int end){
        int temp = Arr[end];
        for(int i=end; i>start; i--){
            Arr[i] = Arr[i - 1];
        } Arr[start] = temp;
    }

    private static int[] InsertionSort(int[] Arr){
        if((Arr == null) || (Arr.length <= 1)){
            return Arr;
        }

        for(int i=1; i<Arr.length; i++){
            if(Arr[i] < Arr[i - 1]){
                int tempIdx = 0;
                for(int j=(i - 1); j>=0; j--){
                    if(Arr[i] > Arr[j]){
                        tempIdx = (j + 1);
                        break;
                    }
                } Shift(Arr, tempIdx, i);
            }
        } return Arr;
    }
}
