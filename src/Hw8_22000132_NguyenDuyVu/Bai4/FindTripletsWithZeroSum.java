package Hw8_22000132_NguyenDuyVu.Bai4;

import java.util.HashMap;
import java.util.Map;

public class FindTripletsWithZeroSum {

    public boolean findTriplets(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (map.containsKey(-sum)) {
                    return true;
                }
            }
            map.put(arr[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {0, -1, 2, -3, 1};
        FindTripletsWithZeroSum findTripletsWithZeroSum = new FindTripletsWithZeroSum();
        System.out.println(findTripletsWithZeroSum.findTriplets(arr));
    }
}
