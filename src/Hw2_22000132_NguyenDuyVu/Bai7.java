package Hw2_22000132_NguyenDuyVu;

import java.util.Scanner;

public class Bai7 {
    public static void sort(int[] arr, int left, int right){
        if (left >= right) return;
        int mid = (left + right) / 2;
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++){
            L[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++){
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2){
            if (L[i] <= R[j]){
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

    public static int countingPairs(int[] arr, int k){
        int count = 0;
        sort(arr,0,arr.length-1);

        for (int i = 1 ; i < arr.length; i++){
            for (int j = 0; j < i; j++){
                if (k - arr[i] == arr[j]){
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(countingPairs(arr, k));
    }
}
