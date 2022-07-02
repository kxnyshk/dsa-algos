import java.util.Arrays;

public class SortQuick {

    // https://practice.geeksforgeeks.org/problems/quick-sort/1/
    // declare a pivot, fixed & var pointers. move var, swap all 
    // less than pivot with fixed. swap pivot with fixed. divide then recur.
    // TC : O(N^2)
    // SC : O(1)
    
    public static void main(String[] args) {
        
        int[] Arr = {4, 10, 8, 7, 6, 2, 3, 12, 14, 5};
        System.out.println(Arrays.toString(QuickSort(Arr)));
    }

    private static void Swap(int[] Arr, int i, int j){
        int temp = Arr[i];
        Arr[i] = Arr[j];
        Arr[j] = temp;
    }

    private static int[] QuickSort(int[] Arr){
        if((Arr == null) || (Arr.length <= 1)){
            return Arr;
        } Sorting(Arr, 0, (Arr.length - 1));
        return Arr;
    }

    private static void Sorting(int[] Arr, int start, int end){
        if(start  >= end){
            return;
        }
        
        int Piv = end;      // Pivot
        int Fix = start;    // Fixed
        int Var = start;    // Variable
        while(Var < end){
            if(Arr[Var] < Arr[Piv]){
                if((Var != 0) && (Var != Fix)){
                    Swap(Arr, Fix, Var);
                } Fix++; 
            } Var++;
        } Swap(Arr, Fix, Piv);
        
        Sorting(Arr, start, (Fix - 1));
        Sorting(Arr, (Fix + 1), end);
    }
}
