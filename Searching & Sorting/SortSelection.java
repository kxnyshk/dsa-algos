import java.util.Arrays;

public class SortSelection {

    // https://practice.geeksforgeeks.org/problems/selection-sort/1/
    // find minimum, select it, drag to start.
    // TC : O(N^2)
    // SC : O(1)
    
    public static void main(String[] args) {
        
        int[] Arr = {25, 12, 64, 22, 11};
        System.out.println(Arrays.toString(SelectionSort(Arr)));
    }

    private static void Swap(int[] Arr, int currIdx, int tempIdx){
        int tempVal = Arr[tempIdx];
        Arr[tempIdx] = Arr[currIdx];
        Arr[currIdx] = tempVal;
    }

    private static int[] SelectionSort(int[] Arr){
        if((Arr == null) || (Arr.length <= 1)){
            return Arr;
        }

        for(int i=0; i<(Arr.length - 1); i++){
            int tempVal = Integer.MAX_VALUE;
            int tempIdx = -1;
            
            for(int j=(i + 1); j<Arr.length; j++){
                if(Arr[j] < tempVal){
                    tempVal = Arr[j]; tempIdx = j;
                }
            } 
            
            if(Arr[i] > tempVal){
                Swap(Arr, i, tempIdx);
            } else{
                Swap(Arr, (i + 1), tempIdx);
            } 
        } return Arr;
    }
}
