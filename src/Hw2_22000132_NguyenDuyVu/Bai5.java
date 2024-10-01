package Hw2_22000132_NguyenDuyVu;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static Hw2_22000132_NguyenDuyVu.Bai1.swap;

public class Bai5 {
    public static void quickSort(int[] arr, int low,int hight){
        if (low > hight) return;

        int pi =  partition(arr, low, hight);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, hight);
    }

    public static int partition(int[] arr, int low, int hight){
        int pivot = arr[hight];
        int i = low - 1;
        for (int j = low; j < hight; j++){
            if (arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, hight);
        return i + 1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = Arrays.stream(new int[n]).map(i -> (new Random()).nextInt(100)).toArray();
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));

    }
}
