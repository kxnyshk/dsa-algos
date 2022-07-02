import java.util.Arrays;

public class SortBubble {

    // https://practice.geeksforgeeks.org/problems/bubble-sort/1
    // pair by pair, bubble up large values at end.
    // TC : O(N^2)
    // TC : O(1)
    
    public static void main(String[] args) {
        
        int[] Arr = {5, 1, 4, 2, 8};
        System.out.println(Arrays.toString(BubbleSort(Arr)));
    }

    private static void Swap(int[] Arr, int i, int j){
        int temp = Arr[i];
        Arr[i] = Arr[j];
        Arr[j] = temp;
    }

    private static int[] BubbleSort(int[] Arr){
        if((Arr == null) || (Arr.length <= 1)){
            return Arr;
        }

        while(true){
            boolean flag = false;
            for(int i=0; i<(Arr.length - 1); i++){
                if(Arr[i] > Arr[i + 1]){
                    Swap(Arr, i, (i + 1));
                    flag = true;
                }
            } if(!flag){
                break;
            }
        } return Arr;
    }
}
