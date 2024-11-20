import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public int countStr(int[] arr) {
        int count  = 1;
        int res = 0;
        for (int i = 1; i < arr.length-1; i++) {
            if (arr[i] == (arr[i-1] + 1)) {
                count++;
                res = Math.max(res, count);
            } else {
                count = 1;
            }
        }
        return res;
    }

    public int findLongestStr(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int res = 0;
        for (int i : arr) {
            if (!set.contains(i-1)) {
                int count = 1;
                while (set.contains(i+1)) {
                    count++;
                    i++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }

    public static String minStr(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static String getMinValueString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        char[] res = new char[chars.length];
        int count1 = 0;
        int i = 0;
        int j = 1;
        while (i < chars.length) {
            res[i] = chars[count1];
            count1 ++;
            i += 2;
        }
        while (j < chars.length) {
            res[j] = chars[count1];
            count1++;
            j += 2;
        }
        return new String(res).trim();
    }

    public static void main(String[] args) {
        System.out.println(getMinValueString("adjswnmc"));
    }


}