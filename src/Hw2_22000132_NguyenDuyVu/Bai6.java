package Hw2_22000132_NguyenDuyVu;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static Hw2_22000132_NguyenDuyVu.Bai1.swap;

public class Bai6 {

    public static void sort(int[] arr){
        for (int i = 0; i < arr.length-1;i++){
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static int kSmallestNumber(int[] arr, int k){
        sort(arr);
        return arr[k - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = Arrays.stream(new int[n]).map(i -> (new Random()).nextInt(100)).toArray();
        System.out.println(Arrays.toString(arr));

        System.out.println("The " + k + "th smallest number is: " + kSmallestNumber(arr, k));
    }
}
