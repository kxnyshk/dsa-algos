import java.util.Arrays;

public class SortMerge {

    // https://practice.geeksforgeeks.org/problems/merge-sort/1/
    // https://leetcode.com/problems/sort-an-array/
    // divide until single indices, merge.
    // TC : O(NlogN)
    // SC : O(N)
    
    public static void main(String[] args) {
        
        int[] Arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println(Arrays.toString(MergeSort(Arr)));
    }

    private static int[] MergeSort(int[] Arr){
        if((Arr == null) || (Arr.length <= 1)){
            return Arr;
        } return Divide(Arr, 0, (Arr.length - 1));
    }

    private static int[] Divide(int[] Arr, int start, int end){
        if(start == end){
            int[] tempArr = new int[1];
            tempArr[0] = Arr[start];
            return tempArr;
        }

        int mid = ((end - start)/2 + start);
        return Merge(Divide(Arr, start, mid), Divide(Arr, (mid + 1), end));
    }

    private static int[] Merge(int[] Arr1, int[] Arr2){
        int[] Arr = new int[Arr1.length + Arr2.length];
        
        int i = 0, j = 0, k = 0;
        while((i < Arr1.length) && (j < Arr2.length)){
            if(Arr1[i] < Arr2[j]){
                Arr[k++] = Arr1[i++];
            } else {
                Arr[k++] = Arr2[j++];
            }
        } while(i < Arr1.length){
            Arr[k++] = Arr1[i++];
        } while(j < Arr2.length){
            Arr[k++] = Arr2[j++];
        } return Arr;
    }
}
