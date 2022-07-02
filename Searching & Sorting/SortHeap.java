import java.util.Arrays;

public class SortHeap {

    // https://www.geeksforgeeks.org/heap-sort/
    // build max heap. heapify non-leaf elements.
    // swap root with last. heapify, repeat.
    // TC : O(NlogN)
    // SC : O(1)
    
    public static void main(String[] args) {
        
        int[] Arr = {4, 10, 3, 5, 1};
        System.out.println(Arrays.toString(HeapSort(Arr)));
    }

    private static void Swap(int[] Arr, int i, int j){
        int temp = Arr[i];
        Arr[i] = Arr[j];
        Arr[j] = temp;
    }

    private static void Heapify(int[] Arr, int lastNode, int heapNode){
        int root = heapNode;
        int leftChild = (2*heapNode + 1);
        int rightChild = (2*heapNode + 2);

        if((leftChild <= lastNode) && (Arr[leftChild] > Arr[root])){
            root = leftChild;
        }
        if((rightChild <= lastNode) && (Arr[rightChild] > Arr[root])){
            root = rightChild;
        }
        if(root != heapNode){
            Swap(Arr, root, heapNode);
            Heapify(Arr, lastNode, root);
        }
    }

    private static int[] HeapSort(int[] Arr){
        if((Arr == null) || (Arr.length <= 1)){
            return Arr;
        }

        int nonLeaf = (Arr.length/2 - 1);
        for(int i=nonLeaf; i>=0; i--){
            Heapify(Arr, (Arr.length - 1), i);
        }
        for(int i=(Arr.length - 1); i>0; i--){
            Swap(Arr, 0, i);
            Heapify(Arr, (i - 1), 0);
        } return Arr;
    }
}
