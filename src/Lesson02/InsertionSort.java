package Lesson02;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    private static void swap(int[] arr, int i, int j){
        if (i != j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void InsertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int j = i - 1;
            int key = arr[i];
            while (j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }


    public static void InsertionSort2(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }


    public static void main(String[] args) {
        int[] arr = Arrays.stream(new int[10]).map(i -> (new Random()).nextInt(100)).toArray();
        System.out.println(Arrays.toString(arr));
        InsertionSort.InsertionSort2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
