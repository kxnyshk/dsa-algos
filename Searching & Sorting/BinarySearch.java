public class BinarySearch {

    // https://practice.geeksforgeeks.org/problems/binary-search/1
    // https://leetcode.com/problems/binary-search/
    // TC : O(logN)
    // SC : O(logN)

    public static void main(String[] args) {
        
        int[] Arr = {10, 20, 30, 50, 60, 80, 110, 130, 140, 170};
        int X = 1;
        System.out.println(BinarySearch_(Arr, X, 0, (Arr.length - 1)));
    }

    private static int BinarySearch_(int[] Arr, int X, int start, int end){
        if((Arr == null) || (Arr.length <= 0)){
            return -1;
        } if(Arr.length == 1){
            return (X == Arr[0]) ? 0 : -1;
        }

        if(start <= end){
            int mid = ((end - start)/2 + start);
            if(X == Arr[mid]){
                return mid;
            } else if(X < Arr[mid]){
                return BinarySearch_(Arr, X, start, (mid - 1));
            } else {
                return BinarySearch_(Arr, X, (mid + 1), end);
            }
        } return -1;
    }
}