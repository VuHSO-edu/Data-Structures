package Hw2_22000132_NguyenDuyVu;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bai2 {
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length-1; i++){
            for (int j = 0; j < arr.length-i-1; j++){
                if (arr[j].compareTo(arr[j+1]) > 0){
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length-1; i++){
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j].compareTo(arr[minIndex]) < 0){
                    minIndex = j;
                }
            }
            T temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T[] arr, int left, int right){
        if (left >= right) return;

        if (left < right){
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static <T extends Comparable<T>> void merge(T[] arr, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;

        T[] L = (T[]) new Comparable[n1];
        T[] R = (T[]) new Comparable[n2];

        for (int i = 0; i < n1; i++){
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++){
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2){
            if (L[i].compareTo(R[j]) <= 0){
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high){
        if (low < high){
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static <T extends Comparable<T>> int partition(T[] arr, int low, int high){
        T pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++){
            if (arr[j].compareTo(pivot) < 0){
                i++;
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = Arrays.stream(new int[n]).map(i -> (new Random()).nextInt(100)).toArray();
        System.out.println("Original array: " + Arrays.toString(arr));
        Integer[] arr1 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        bubbleSort(arr1);
        System.out.println("Bubble Sort: " + Arrays.toString(arr1));

    }

}
