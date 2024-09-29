package Lesson02;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    private static void merge(int[] arr, int left,int mid, int right){
        int n1 = mid - left + 1; // Số lượng phần từ rong mảng bên trái
        int n2 = right - mid; // Số lượng phần tử mảng bên phải
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for(int i = 0; i < n1; i++){
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++){
            rightArr[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int index = left;

        while(i < n1 && j < n2){
            if (leftArr[i] < rightArr[j]) {
                arr[index] = leftArr[i];
                index++;
                i++;
            } else {
                arr[index] = rightArr[j];
                index++;
                j++;
            }
        }

        while(i < n1){
            arr[index] = leftArr[i];
            index++;
            i++;
        }

        while(j < n2){
            arr[index] = rightArr[j];
            index++;
            j++;
        }
    }

    public static void mergeSort(int[] arr, int left, int right){
        if (left >= right) return;

        if (left < right){
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    public static void main(String[] args) {
        int[] arr = Arrays.stream(new int[10]).map(i -> (new Random()).nextInt(100)).toArray();
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
}
