package Lesson02;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void BubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            boolean swapped = true;
            for (int j = 0; j < arr.length - i - 1; j++){
                if (arr[j] > arr[j + 1]){
                    swap(arr, j, j + 1);
                    swapped = false;
                }
            }
            if (swapped) break;
        }
    }
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = Arrays.stream(new int[10]).map(i -> random.nextInt(100)).toArray();
        BubbleSort.BubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
