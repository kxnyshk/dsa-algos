import java.util.Arrays;

public class AccentureArr{

    // https://practice.geeksforgeeks.org/problems/arranging-the-array1131/1
    // 2nd question of my Accenture's on-Campus Online Assesment Coding round.

    // Prompt: Given an array of positive and negative numbers, arrange them 
    // such that all negative integers appear before all the positive integers 
    // in the array without using any additional data structure like hash table, 
    // arrays, etc. The order of appearance should be maintained.

    public static void main(String[] args) {
        long[] a = {12,11,-13,-5,6,-7,5,-3,-6};
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(ReArrange(a)));
    }

    private static long[] ReArrange(long[] a) {
        if((a == null) || (a.length == 1)){
            return a;
        } int i = 0, j = 0;

        while(j < a.length){
            if(a[j] < 0){
                RotateArray(a, j, i); i++;
            } j++;
        } return a;
    }

    private static void RotateArray(long[] a, int j, int i) {
        if(j == i){
            return;
        } long Neg = a[j]; int k;

        for(k=j; k>i; k--){
            a[k] = a[k - 1];
        } a[i] = Neg;
    }
}