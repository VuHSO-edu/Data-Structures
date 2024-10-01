package Hw2_22000132_NguyenDuyVu;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bai1 {
    private static Scanner sc = new Scanner(System.in);

    public static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++){
            for (int j = 0; j < arr.length-i-1; j++){
                if (arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
            System.out.println("Bubble Sort " + (i+1) + " : " + Arrays.toString(arr));
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++){
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }

                swap(arr, i, minIndex);
                System.out.println("Selection Sort " + (i+1) + " : " + Arrays.toString(arr));
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
            System.out.println("Insertion Sort " + (i+1) + " : " + Arrays.toString(arr));
        }
    }

    public static void mergeSort(int[] arr, int left, int right){
        if (left >= right) return;

        if (left < right){
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
            System.out.println("Merge Sort: " + Arrays.toString(arr));
        }
    }

    private static void merge(int[] arr, int left,int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;
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

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
            System.out.println("Quick Sort: " + Arrays.toString(arr));
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
// Funtion to measure time complexity of each sort algorithm

    public static long measureTime(Runnable sortingMethod){
        long startTime = System.nanoTime();
        sortingMethod.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void main(String[] args) {
       int n = sc.nextInt();
       int[] arr = Arrays.stream(new int[n]).map(i -> (new Random()).nextInt((int)Math.pow(10,5))).toArray();
        System.out.println("Begin:" + Arrays.toString(arr));
        System.out.println();
        Bai1.bubbleSort(arr);
        System.out.println("Bubble Sort: " + Arrays.toString(arr));
        System.out.println("Time complexity of Bubble Sort: " + measureTime(() -> Bai1.bubbleSort(arr)));
        System.out.println();
        Bai1.selectionSort(arr);
        System.out.println("Selection Sort: " + Arrays.toString(arr));
        System.out.println("Time complexity of Selection Sort: " + measureTime(() -> Bai1.selectionSort(arr)));
        System.out.println();
        Bai1.insertionSort(arr);
        System.out.println("Insertion Sort: " + Arrays.toString(arr));
        System.out.println("Time complexity of Insertion Sort: " + measureTime(() -> Bai1.insertionSort(arr)));
        System.out.println();
        Bai1.mergeSort(arr, 0, arr.length-1);
        System.out.println("Merge Sort: " + Arrays.toString(arr));
        System.out.println("Time complexity of Merge Sort: " + measureTime(() -> Bai1.mergeSort(arr, 0, arr.length-1)));
        System.out.println();
        Bai1.quickSort(arr, 0, arr.length-1);
        System.out.println("Quick Sort: " + Arrays.toString(arr));
        System.out.println("Time complexity of Quick Sort: " + measureTime(() -> Bai1.quickSort(arr, 0, arr.length-1)));

    }
}
