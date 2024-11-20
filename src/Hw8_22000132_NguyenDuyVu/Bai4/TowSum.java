package Hw8_22000132_NguyenDuyVu.Bai4;

import java.util.HashMap;
import java.util.Map;

public class TowSum {

    boolean towSum(int[] arr , int target){
        Map<Integer, Integer> map = new HashMap<>();
        boolean result = false;
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                result = true;
            }
            map.put(arr[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,3,6};
        int target = 11;
        TowSum towSum = new TowSum();
        System.out.println(towSum.towSum(arr, target));
    }
}
