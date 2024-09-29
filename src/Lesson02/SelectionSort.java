package Lesson02;

import java.util.*;

public class SelectionSort {
    private static void swap(int[] arr, int i, int j){
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void SelectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1 ; i++){
            int minindex = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[minindex]){
                    minindex = j;
                }
            }
            swap(arr, i, minindex);
        }
    }

    public static void main(String[] args) {
        int[] arr = Arrays.stream(new int[10]).map(i -> (new Random()).nextInt(100)).toArray();
        System.out.println(Arrays.toString(arr));
        SelectionSort.SelectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
